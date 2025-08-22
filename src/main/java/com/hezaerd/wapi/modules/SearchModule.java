package com.hezaerd.wapi.modules;

import java.util.concurrent.CompletableFuture;

import com.hezaerd.wapi.client.WapiHttpClient;
import com.hezaerd.wapi.models.ApiResponse;

/**
 * Module for interacting with <a href="https://docs.wynncraft.com/docs/modules/search.html">Wynncraft Search API endpoints</a>
 */
public class SearchModule {
	private final WapiHttpClient httpClient;

	public SearchModule(WapiHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	/**
	 * Search for players, guilds, and items.
	 *
	 * @param query The search query
	 * @return CompletableFuture containing search results
	 */
	public CompletableFuture<ApiResponse<Object>> search(String query) {
		return httpClient.get("/v3/search/" + query, Object.class);
	}

	/**
	 * Search for players only.
	 *
	 * @param query The search query
	 * @return CompletableFuture containing player search results
	 */
	public CompletableFuture<ApiResponse<Object>> searchPlayers(String query) {
		return httpClient.get("/v3/search/player/" + query, Object.class);
	}

	/**
	 * Search for guilds only.
	 *
	 * @param query The search query
	 * @return CompletableFuture containing guild search results
	 */
	public CompletableFuture<ApiResponse<Object>> searchGuilds(String query) {
		return httpClient.get("/v3/search/guild/" + query, Object.class);
	}

	/**
	 * Search for items only.
	 *
	 * @param query The search query
	 * @return CompletableFuture containing item search results
	 */
	public CompletableFuture<ApiResponse<Object>> searchItems(String query) {
		return httpClient.get("/v3/search/item/" + query, Object.class);
	}
}
