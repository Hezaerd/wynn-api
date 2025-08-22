package com.hezaerd.wapi;

import com.hezaerd.wapi.client.WapiHttpClient;
import com.hezaerd.wapi.client.WapiHttpClientConfig;
import com.hezaerd.wapi.modules.AbilityModule;
import com.hezaerd.wapi.modules.ClassesModule;
import com.hezaerd.wapi.modules.GuildModule;
import com.hezaerd.wapi.modules.ItemModule;
import com.hezaerd.wapi.modules.LeaderboardModule;
import com.hezaerd.wapi.modules.MapModule;
import com.hezaerd.wapi.modules.NewsModule;
import com.hezaerd.wapi.modules.PlayerModule;
import com.hezaerd.wapi.modules.SearchModule;

/**
 * Main client class for interacting with the Wynncraft API.
 * This class serves as the entry point for making API requests.
 * Provides a fluent, simple interface for accessing different API modules.
 */
public final class WapiClient {
	private final WapiHttpClientConfig config;
	private final WapiHttpClient httpClient;

	// API modules
	private final PlayerModule playerModule;
	private final GuildModule guildModule;
	private final ItemModule itemModule;
	private final LeaderboardModule leaderboardModule;
	private final AbilityModule abilityModule;
	private final MapModule mapModule;
	private final SearchModule searchModule;
	private final ClassesModule classesModule;
	private final NewsModule newsModule;

	/**
	 * Creates a new WapiClient with custom configuration.
	 *
	 * @param config The HTTP client configuration
	 */
	public WapiClient(WapiHttpClientConfig config) {
		this.config = config;
		this.httpClient = new WapiHttpClient(config);

		this.playerModule = new PlayerModule(httpClient);
		this.guildModule = new GuildModule(httpClient);
		this.itemModule = new ItemModule(httpClient);
		this.leaderboardModule = new LeaderboardModule(httpClient);
		this.abilityModule = new AbilityModule(httpClient);
		this.mapModule = new MapModule(httpClient);
		this.searchModule = new SearchModule(httpClient);
		this.classesModule = new ClassesModule(httpClient);
		this.newsModule = new NewsModule(httpClient);
	}

	/**
	 * Creates a new WapiClient with default configuration.
	 */
	public WapiClient() {
		this(new WapiHttpClientConfig.Builder().build());
	}

	/**
	 * Access player-related API endpoints.
	 *
	 * @return PlayerModule for player operations
	 */
	public PlayerModule player() {
		return playerModule;
	}

	/**
	 * Access guild-related API endpoints.
	 *
	 * @return GuildModule for guild operations
	 */
	public GuildModule guild() {
		return guildModule;
	}

	/**
	 * Access item-related API endpoints.
	 *
	 * @return ItemModule for item operations
	 */
	public ItemModule item() {
		return itemModule;
	}

	/**
	 * Access leaderboard API endpoints.
	 *
	 * @return LeaderboardModule for leaderboard operations
	 */
	public LeaderboardModule leaderboard() {
		return leaderboardModule;
	}

	/**
	 * Access ability and aspects API endpoints.
	 *
	 * @return AbilityModule for ability operations
	 */
	public AbilityModule ability() {
		return abilityModule;
	}

	/**
	 * Access map-related API endpoints.
	 *
	 * @return MapModule for map operations
	 */
	public MapModule map() {
		return mapModule;
	}

	/**
	 * Access search API endpoints.
	 *
	 * @return SearchModule for search operations
	 */
	public SearchModule search() {
		return searchModule;
	}

	/**
	 * Access class-related API endpoints.
	 *
	 * @return ClassesModule for class operations
	 */
	public ClassesModule classes() {
		return classesModule;
	}

	/**
	 * Access news API endpoints.
	 *
	 * @return NewsModule for news operations
	 */
	public NewsModule news() {
		return newsModule;
	}

	/**
	 * Get the underlying HTTP client for advanced usage.
	 *
	 * @return The HTTP client instance
	 */
	public WapiHttpClient getHttpClient() {
		return httpClient;
	}

	/**
	 * Get the current configuration.
	 *
	 * @return The client configuration
	 */
	public WapiHttpClientConfig getConfig() {
		return config;
	}
}
