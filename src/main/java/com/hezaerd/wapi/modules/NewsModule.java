package com.hezaerd.wapi.modules;

import java.util.concurrent.CompletableFuture;

import com.hezaerd.wapi.client.WapiHttpClient;
import com.hezaerd.wapi.models.ApiResponse;

/**
 * Module for interacting with <a href="https://docs.wynncraft.com/docs/modules/news.html">Wynncraft News API endpoints</a>
 */
public class NewsModule {
	private final WapiHttpClient httpClient;

	public NewsModule(WapiHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	/**
	 * Get latest news.
	 *
	 * @return CompletableFuture containing news data
	 */
	public CompletableFuture<ApiResponse<Object>> getNews() {
		return httpClient.get("/v3/news", Object.class);
	}

	/**
	 * Get latest news with limit.
	 *
	 * @param limit Maximum number of news items to return
	 * @return CompletableFuture containing news data
	 */
	public CompletableFuture<ApiResponse<Object>> getNews(int limit) {
		return httpClient.get("/v3/news", Object.class, "limit", String.valueOf(limit));
	}

	/**
	 * Get news by category.
	 *
	 * @param category The news category
	 * @return CompletableFuture containing news data
	 */
	public CompletableFuture<ApiResponse<Object>> getNewsByCategory(String category) {
		return httpClient.get("/v3/news", Object.class, "category", category);
	}

	/**
	 * Get news updates only.
	 *
	 * @return CompletableFuture containing update news
	 */
	public CompletableFuture<ApiResponse<Object>> getUpdates() {
		return getNewsByCategory("updates");
	}

	/**
	 * Get patch notes only.
	 *
	 * @return CompletableFuture containing patch notes
	 */
	public CompletableFuture<ApiResponse<Object>> getPatchNotes() {
		return getNewsByCategory("patches");
	}

	/**
	 * Get announcements only.
	 *
	 * @return CompletableFuture containing announcements
	 */
	public CompletableFuture<ApiResponse<Object>> getAnnouncements() {
		return getNewsByCategory("announcements");
	}
}
