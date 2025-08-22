package com.hezaerd.wapi.client;

import java.time.Duration;
import java.util.concurrent.Executor;

/**
 * Configuration class for WapiHttpClient.
 */
public class WapiHttpClientConfig {
	private final Duration connectTimeout;
	private final Duration requestTimeout;
	private final int maxRetryAttempts;
	private final Duration retryDelay;
	private final boolean enableLogging;
	private final Executor executor;
	private final int maxConnections;
	private final Duration connectionIdleTimeout;

	private WapiHttpClientConfig(Builder builder) {
		this.connectTimeout = builder.connectTimeout;
		this.requestTimeout = builder.requestTimeout;
		this.maxRetryAttempts = builder.maxRetryAttempts;
		this.retryDelay = builder.retryDelay;
		this.enableLogging = builder.enableLogging;
		this.executor = builder.executor;
		this.maxConnections = builder.maxConnections;
		this.connectionIdleTimeout = builder.connectionIdleTimeout;
	}

	// Getters
	public Duration getConnectTimeout() { return connectTimeout; }
	public Duration getRequestTimeout() { return requestTimeout; }
	public int getMaxRetryAttempts() { return maxRetryAttempts; }
	public Duration getRetryDelay() { return retryDelay; }
	public boolean isLoggingEnabled() { return enableLogging; }
	public Executor getExecutor() { return executor; }
	public int getMaxConnections() { return maxConnections; }
	public Duration getConnectionIdleTimeout() { return connectionIdleTimeout; }

	/**
	 * Builder for WapiHttpClientConfig.
	 */
	public static class Builder {
		private Duration connectTimeout = Duration.ofSeconds(10);
		private Duration requestTimeout = Duration.ofSeconds(30);
		private int maxRetryAttempts = 3;
		private Duration retryDelay = Duration.ofSeconds(1);
		private boolean enableLogging = false;
		private Executor executor = null;
		private int maxConnections = 10;
		private Duration connectionIdleTimeout = Duration.ofMinutes(5);

		public Builder connectTimeout(Duration connectTimeout) {
			this.connectTimeout = connectTimeout;
			return this;
		}

		public Builder requestTimeout(Duration requestTimeout) {
			this.requestTimeout = requestTimeout;
			return this;
		}

		public Builder maxRetryAttempts(int maxRetryAttempts) {
			this.maxRetryAttempts = Math.max(0, Math.min(maxRetryAttempts, 10));
			return this;
		}

		public Builder retryDelay(Duration retryDelay) {
			this.retryDelay = retryDelay;
			return this;
		}

		public Builder enableLogging(boolean enableLogging) {
			this.enableLogging = enableLogging;
			return this;
		}

		public Builder executor(Executor executor) {
			this.executor = executor;
			return this;
		}

		public Builder maxConnections(int maxConnections) {
			this.maxConnections = Math.max(1, maxConnections);
			return this;
		}

		public Builder connectionIdleTimeout(Duration connectionIdleTimeout) {
			this.connectionIdleTimeout = connectionIdleTimeout;
			return this;
		}

		public WapiHttpClientConfig build() {
			return new WapiHttpClientConfig(this);
		}
	}

	public static Builder builder() {
		return new Builder();
	}
}
