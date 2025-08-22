package com.hezaerd.wapi.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

import com.hezaerd.wapi.models.ApiResponse;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Implementation of IWapiHttpClient using Java's built-in HttpClient.
 * Automatically parses Wynncraft's rate limit headers and provides
 * a simple interface for making API requests.
 */
public class WapiHttpClient {
	private static final String BASE_URL = "https://api.wynncraft.com";
	private static final Logger LOGGER = Logger.getLogger(WapiHttpClient.class.getName());

	private final HttpClient httpClient;
	private final Gson gson;
	private final boolean enableLogging;

	// Rate limit tracking from API headers
	private volatile int remainingRequests = 120;
	private volatile long resetTime = 0;
	private volatile int rateLimit = 120;

	public WapiHttpClient(WapiHttpClientConfig config) {
		this.enableLogging = config.isLoggingEnabled();
		this.gson = new Gson();

		HttpClient.Builder builder = HttpClient.newBuilder()
			.connectTimeout(config.getConnectTimeout())
			.connectTimeout(config.getRequestTimeout());

		if (config.getExecutor() != null) {
			builder.executor(config.getExecutor());
		}

		this.httpClient = builder.build();
	}

	/**
	 * Make a GET request to the specified endpoint.
	 *
	 * @param endpoint The API endpoint (e.g., "/player/{username}")
	 * @param responseType The expected response type.
	 * @param <T> The type of the response data.
	 * @return CompletableFuture containing the ApiResponse.
	 */
	public <T> CompletableFuture<ApiResponse<T>> fetch(String endpoint, Class<T> responseType) {
		return get(endpoint, responseType);
	}

	/**
	 * Makes a GET request with query parameters.
	 *
	 * @param endpoint the API endpoint
	 * @param responseType the expected response type
	 * @param queryParams alternating key-value pairs (e.g., "key1", "value1", "key2", "value2")
	 * @return CompletableFuture containing the API response
	 */
	public <T> CompletableFuture<ApiResponse<T>> get(String endpoint, Class<T> responseType, String... queryParams) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				String url = buildUrl(endpoint, queryParams);

				if (enableLogging) {
					LOGGER.info("Making GET request to: " + url);
				}

				HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.header("User-Agent", "WynnAPI-Client/1.0")
					.GET()
					.build();

				HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

				// Parse rate limit headers
				parseRateLimitHeaders(response);

				if (enableLogging) {
					LOGGER.info("Response status: " + response.statusCode() +
							", Rate limit remaining: " + remainingRequests);
				}

				if (response.statusCode() == 429) {
					return ApiResponse.failure("Rate limit exceeded. Reset in " +
						Math.max(0, resetTime - System.currentTimeMillis() / 1000) + " seconds");
				}

				if (response.statusCode() != 200) {
					return ApiResponse.failure("HTTP " + response.statusCode() + ": " + response.body());
				}

				try {
					T data = gson.fromJson(response.body(), responseType);
					return ApiResponse.success(data);
				} catch (JsonSyntaxException e) {
					return ApiResponse.failure("Failed to parse JSON response: " + e.getMessage());
				}

			} catch (IOException | InterruptedException e) {
				Thread.currentThread().interrupt();
				return ApiResponse.failure("Request failed: " + e.getMessage());
			}
		});
	}

	/**
	 * Builds the full URL with query parameters.
	 */
	private String buildUrl(String endpoint, String... queryParams) {
		StringBuilder url = new StringBuilder(BASE_URL);

		if (!endpoint.startsWith("/")) {
			url.append("/");
		}
		url.append(endpoint);

		if (queryParams.length > 0 && queryParams.length % 2 == 0) {
			url.append("?");
			for (int i = 0; i < queryParams.length; i += 2) {
				if (i > 0) url.append("&");
				url.append(queryParams[i]).append("=").append(queryParams[i + 1]);
			}
		}

		return url.toString();
	}

	/**
	 * Parses rate limit headers from the API response.
	 * Uses Wynncraft's own rate limit data to stay synchronized.
	 */
	private void parseRateLimitHeaders(HttpResponse<String> response) {
		response.headers().firstValue("RateLimit-Remaining")
			.ifPresent(remaining -> {
				try {
					this.remainingRequests = Integer.parseInt(remaining);
				} catch (NumberFormatException e) {
					// Ignore parsing errors, keep current value
				}
			});

		response.headers().firstValue("RateLimit-Reset")
			.ifPresent(reset -> {
				try {
					this.resetTime = System.currentTimeMillis() / 1000 + Long.parseLong(reset);
				} catch (NumberFormatException e) {
					// Ignore parsing errors, keep current value
				}
			});

		response.headers().firstValue("RateLimit-Limit")
			.ifPresent(limit -> {
				try {
					this.rateLimit = Integer.parseInt(limit);
				} catch (NumberFormatException e) {
					// Ignore parsing errors, keep current value
				}
			});
	}

	/**
	 * Record representing the current rate limit status.
	 */
	public record RateLimitStatus(int remaining, long resetTime, int limit) {
		public long getSecondsUntilReset() {
			return Math.max(0, resetTime - System.currentTimeMillis() / 1000);
		}
	}

	/**
	 * Gets the current rate limit status.
	 */
	public RateLimitStatus getRateLimitStatus() {
		return new RateLimitStatus(remainingRequests, resetTime, rateLimit);
	}
}
