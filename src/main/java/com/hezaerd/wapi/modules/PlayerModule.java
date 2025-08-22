package com.hezaerd.wapi.modules;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.hezaerd.wapi.client.WapiHttpClient;
import com.hezaerd.wapi.models.AbilityMap;
import com.hezaerd.wapi.models.ApiResponse;
import com.hezaerd.wapi.models.CharacterData;
import com.hezaerd.wapi.models.CharacterListResponse;
import com.hezaerd.wapi.models.OnlinePlayersResponse;
import com.hezaerd.wapi.models.PlayerData;

/**
 * Module for interacting with <a href="https://docs.wynncraft.com/docs/modules/player.html">Wynncraft Player API endpoints</a>
 */
public class PlayerModule {
	private final WapiHttpClient httpClient;

	public PlayerModule(WapiHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	/**
	 * Get basic player information.
	 *
	 * @param username The player's username
	 * @return CompletableFuture containing player data
	 */
	public CompletableFuture<ApiResponse<PlayerData>> get(String username) {
		return httpClient.get("/v3/player/" + username, PlayerData.class);
	}

	/**
	 * Get full player information including detailed stats.
	 *
	 * @param username The player's username
	 * @return CompletableFuture containing full player data
	 */
	public CompletableFuture<ApiResponse<PlayerData>> getFull(String username) {
		return httpClient.get("/v3/player/" + username, PlayerData.class, "fullResult", "True");
	}

	/**
	 * Get a list of player's characters.
	 *
	 * @param username The player's username
	 * @return CompletableFuture containing character list
	 */
	public CompletableFuture<ApiResponse<List<CharacterData>>> getCharacters(String username) {
		return httpClient.get("/v3/player/" + username + "/character", CharacterListResponse.class)
			.thenApply(response -> response.map(CharacterListResponse::getCharacters));
	}

	/**
	 * Get specific character data.
	 *
	 * @param username The player's username
	 * @param character The character name
	 * @return CompletableFuture containing character data
	 */
	public CompletableFuture<ApiResponse<CharacterData>> getCharacter(String username, String character) {
		return httpClient.get("/v3/player/" + username + "/character/" + character, CharacterData.class);
	}

	/**
	 * Get character ability map.
	 *
	 * @param username The player's username
	 * @param character The character name
	 * @return CompletableFuture containing ability data
	 */
	public CompletableFuture<ApiResponse<AbilityMap>> getCharacterAbility(String username, String character) {
		return httpClient.get("/v3/player/" + username + "/character/" + character + "/ability", AbilityMap.class);
	}

	/**
	 * Get list of online players.
	 *
	 * @return CompletableFuture containing online players list
	 */
	public CompletableFuture<ApiResponse<OnlinePlayersResponse>> getOnlinePlayers() {
		return httpClient.get("/v3/player", OnlinePlayersResponse.class);
	}

	/**
	 * Get online players count.
	 *
	 * @return CompletableFuture containing online players count
	 */
	public CompletableFuture<ApiResponse<Integer>> getOnlinePlayersCount() {
		return getOnlinePlayers().thenApply(response ->
			response.map(OnlinePlayersResponse::getCount));
	}

	/**
	 * Get list of online player usernames.
	 *
	 * @return CompletableFuture containing list of online usernames
	 */
	public CompletableFuture<ApiResponse<List<String>>> getOnlinePlayerNames() {
		return getOnlinePlayers().thenApply(response ->
			response.map(OnlinePlayersResponse::getPlayers));
	}
}
