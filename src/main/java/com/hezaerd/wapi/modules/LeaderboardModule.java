package com.hezaerd.wapi.modules;

import java.util.concurrent.CompletableFuture;

import com.hezaerd.wapi.client.WapiHttpClient;
import com.hezaerd.wapi.models.ApiResponse;

/**
 * Module for interacting with <a href="https://docs.wynncraft.com/docs/modules/leaderboard.html">Wynncraft Leaderboard API endpoints</a>
 */
public class LeaderboardModule {
	private final WapiHttpClient httpClient;

	public LeaderboardModule(WapiHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	/**
	 * Get player leaderboard.
	 *
	 * @return CompletableFuture containing leaderboard data
	 */
	public CompletableFuture<ApiResponse<Object>> getPlayerLeaderboard() {
		return httpClient.get("/v3/leaderboard/player", Object.class);
	}

	/**
	 * Get guild leaderboard.
	 *
	 * @return CompletableFuture containing leaderboard data
	 */
	public CompletableFuture<ApiResponse<Object>> getGuildLeaderboard() {
		return httpClient.get("/v3/leaderboard/guild", Object.class);
	}

	/**
	 * Get PvP leaderboard.
	 *
	 * @return CompletableFuture containing leaderboard data
	 */
	public CompletableFuture<ApiResponse<Object>> getPvpLeaderboard() {
		return httpClient.get("/v3/leaderboard/pvp", Object.class);
	}

	/**
	 * Get leaderboard by type.
	 *
	 * @param type The leaderboard type
	 * @return CompletableFuture containing leaderboard data
	 */
	public CompletableFuture<ApiResponse<Object>> getLeaderboard(String type) {
		return httpClient.get("/v3/leaderboard/" + type, Object.class);
	}
}
