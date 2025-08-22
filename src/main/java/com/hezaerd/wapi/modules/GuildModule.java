package com.hezaerd.wapi.modules;

import java.util.concurrent.CompletableFuture;

import com.hezaerd.wapi.client.WapiHttpClient;
import com.hezaerd.wapi.models.ApiResponse;
import com.hezaerd.wapi.models.GuildData;

/**
 * Module for interacting with <a href="https://docs.wynncraft.com/docs/modules/guild.html">Wynncraft Guild API endpoints</a>
 */
public class GuildModule {
	private final WapiHttpClient httpClient;

	public GuildModule(WapiHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	/**
	 * Get guild information by name.
	 *
	 * @param guildName The guild's name (case-insensitive)
	 * @return CompletableFuture containing guild data
	 */
	public CompletableFuture<ApiResponse<GuildData>> getByName(String guildName) {
		return httpClient.get("/v3/guild/" + guildName, GuildData.class);
	}

	/**
	 * Get guild information by name with specific member identifier.
	 *
	 * @param guildName The guild's name (case-insensitive)
	 * @param identifier Either "username" or "uuid" to specify how members should be identified
	 * @return CompletableFuture containing guild data
	 */
	public CompletableFuture<ApiResponse<GuildData>> getByName(String guildName, String identifier) {
		return httpClient.get("/v3/guild/" + guildName, GuildData.class, "identifier", identifier);
	}

	/**
	 * Get guild information by prefix.
	 *
	 * @param guildPrefix The guild's prefix
	 * @return CompletableFuture containing guild data
	 */
	public CompletableFuture<ApiResponse<GuildData>> getByPrefix(String guildPrefix) {
		return httpClient.get("/v3/guild/prefix/" + guildPrefix, GuildData.class);
	}

	/**
	 * Get guild information by prefix with specific member identifier.
	 *
	 * @param guildPrefix The guild's prefix
	 * @param identifier Either "username" or "uuid" to specify how members should be identified
	 * @return CompletableFuture containing guild data
	 */
	public CompletableFuture<ApiResponse<GuildData>> getByPrefix(String guildPrefix, String identifier) {
		return httpClient.get("/v3/guild/prefix/" + guildPrefix, GuildData.class, "identifier", identifier);
	}

	/**
	 * Get list of all guilds.
	 * Note: This endpoint returns a raw Map structure, so we need to handle it specially.
	 *
	 * @return CompletableFuture containing guild list response
	 */
	public CompletableFuture<ApiResponse<Object>> getGuildList() {
		return httpClient.get("/v3/guild/list", Object.class);
	}

	/**
	 * Get list of all guilds with specific identifier.
	 *
	 * @param identifier Either "uuid" or "name" to specify the key format
	 * @return CompletableFuture containing guild list response
	 */
	public CompletableFuture<ApiResponse<Object>> getGuildList(String identifier) {
		return httpClient.get("/v3/guild/list", Object.class, "identifier", identifier);
	}

	/**
	 * Get guild territory list.
	 * Returns information about all territories and their controlling guilds.
	 *
	 * @return CompletableFuture containing territory data
	 */
	public CompletableFuture<ApiResponse<Object>> getTerritories() {
		return httpClient.get("/v3/guild/list/territory", Object.class);
	}

	/**
	 * Convenience method to get guild by name with username identifiers.
	 *
	 * @param guildName The guild's name
	 * @return CompletableFuture containing guild data with username identifiers
	 */
	public CompletableFuture<ApiResponse<GuildData>> getByNameWithUsernames(String guildName) {
		return getByName(guildName, "username");
	}

	/**
	 * Convenience method to get guild by name with UUID identifiers.
	 *
	 * @param guildName The guild's name
	 * @return CompletableFuture containing guild data with UUID identifiers
	 */
	public CompletableFuture<ApiResponse<GuildData>> getByNameWithUuids(String guildName) {
		return getByName(guildName, "uuid");
	}

	/**
	 * Convenience method to get guild by prefix with username identifiers.
	 *
	 * @param guildPrefix The guild's prefix
	 * @return CompletableFuture containing guild data with username identifiers
	 */
	public CompletableFuture<ApiResponse<GuildData>> getByPrefixWithUsernames(String guildPrefix) {
		return getByPrefix(guildPrefix, "username");
	}

	/**
	 * Convenience method to get guild by prefix with UUID identifiers.
	 *
	 * @param guildPrefix The guild's prefix
	 * @return CompletableFuture containing guild data with UUID identifiers
	 */
	public CompletableFuture<ApiResponse<GuildData>> getByPrefixWithUuids(String guildPrefix) {
		return getByPrefix(guildPrefix, "uuid");
	}

	/**
	 * Convenience method to get guild list indexed by UUIDs.
	 *
	 * @return CompletableFuture containing guild list indexed by UUIDs
	 */
	public CompletableFuture<ApiResponse<Object>> getGuildListByUuid() {
		return getGuildList("uuid");
	}

	/**
	 * Convenience method to get guild list indexed by names.
	 *
	 * @return CompletableFuture containing guild list indexed by names
	 */
	public CompletableFuture<ApiResponse<Object>> getGuildListByName() {
		return getGuildList("name");
	}
}
