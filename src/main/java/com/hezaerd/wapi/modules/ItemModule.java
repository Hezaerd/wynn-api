package com.hezaerd.wapi.modules;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.hezaerd.wapi.client.WapiHttpClient;
import com.hezaerd.wapi.models.ApiResponse;
import com.hezaerd.wapi.models.ItemData;
import com.hezaerd.wapi.models.ItemDatabaseResponse;
import com.hezaerd.wapi.models.ItemMetadata;

/**
 * Module for interacting with <a href="https://docs.wynncraft.com/docs/modules/item.html">Wynncraft Item API endpoints</a>
 */
public class ItemModule {
	private final WapiHttpClient httpClient;

	public ItemModule(WapiHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	/**
	 * Get paginated item database.
	 *
	 * @return CompletableFuture containing paginated item database response
	 */
	public CompletableFuture<ApiResponse<ItemDatabaseResponse>> getDatabase() {
		return httpClient.get("/v3/item", ItemDatabaseResponse.class);
	}

	/**
	 * Get paginated item database with specific page.
	 *
	 * @param page The page number to retrieve
	 * @return CompletableFuture containing paginated item database response
	 */
	public CompletableFuture<ApiResponse<ItemDatabaseResponse>> getDatabase(int page) {
		return httpClient.get("/v3/item", ItemDatabaseResponse.class, "page", String.valueOf(page));
	}

	/**
	 * Get full item database (bypasses pagination).
	 *
	 * @return CompletableFuture containing complete item database
	 */
	public CompletableFuture<ApiResponse<Object>> getDatabaseFull() {
		return httpClient.get("/v3/item", Object.class, "fullResult", "true");
	}

	/**
	 * Search for items by name (quick search).
	 *
	 * @param query The search query
	 * @return CompletableFuture containing item search results
	 */
	public CompletableFuture<ApiResponse<Object>> quickSearch(String query) {
		return httpClient.get("/v3/item/search/" + query, Object.class);
	}

	/**
	 * Get item metadata including available filters and identifications.
	 *
	 * @return CompletableFuture containing item metadata
	 */
	public CompletableFuture<ApiResponse<ItemMetadata>> getMetadata() {
		return httpClient.get("/v3/item/metadata", ItemMetadata.class);
	}

	/**
	 * Advanced item search using POST with filters.
	 * Note: This would require implementing a POST method in the HTTP client.
	 * For now, this is a placeholder that demonstrates the intended API.
	 *
	 * @param searchFilters The search filters as a Map
	 * @return CompletableFuture containing search results
	 */
	public CompletableFuture<ApiResponse<Object>> search(Map<String, Object> searchFilters) {
		// This would require implementing POST support in the HTTP client
		// For now, we'll use a GET approach as a workaround
		throw new UnsupportedOperationException("Advanced search with POST is not yet implemented. Use quickSearch() instead.");
	}

	/**
	 * Get specific item by internal name.
	 * This is a convenience method for quick access to individual items.
	 *
	 * @param internalName The internal name of the item
	 * @return CompletableFuture containing item data
	 */
	public CompletableFuture<ApiResponse<ItemData>> getItem(String internalName) {
		return quickSearch(internalName).thenApply(response -> {
			// This would need to be processed to extract a single ItemData
			// For now, we return a failure as this requires more complex processing
			return ApiResponse.failure("Individual item retrieval not yet implemented. Use quickSearch() instead.");
		});
	}

	/**
	 * Get items by type filter.
	 *
	 * @param type The item type (e.g., "weapons", "armour", "accessories")
	 * @return CompletableFuture containing filtered items
	 */
	public CompletableFuture<ApiResponse<Object>> getByType(String type) {
		return httpClient.get("/v3/item", Object.class, "type", type);
	}

	/**
	 * Get items by rarity.
	 *
	 * @param rarity The item rarity (e.g., "legendary", "mythic", "rare")
	 * @return CompletableFuture containing filtered items
	 */
	public CompletableFuture<ApiResponse<Object>> getByRarity(String rarity) {
		return httpClient.get("/v3/item", Object.class, "rarity", rarity);
	}

	/**
	 * Get items by level range.
	 *
	 * @param minLevel Minimum level requirement
	 * @param maxLevel Maximum level requirement
	 * @return CompletableFuture containing filtered items
	 */
	public CompletableFuture<ApiResponse<Object>> getByLevelRange(int minLevel, int maxLevel) {
		return httpClient.get("/v3/item", Object.class,
			"levelMin", String.valueOf(minLevel),
			"levelMax", String.valueOf(maxLevel));
	}

	/**
	 * Get weapons only.
	 *
	 * @return CompletableFuture containing weapon items
	 */
	public CompletableFuture<ApiResponse<Object>> getWeapons() {
		return getByType("weapons");
	}

	/**
	 * Get armour only.
	 *
	 * @return CompletableFuture containing armour items
	 */
	public CompletableFuture<ApiResponse<Object>> getArmour() {
		return getByType("armour");
	}

	/**
	 * Get accessories only.
	 *
	 * @return CompletableFuture containing accessory items
	 */
	public CompletableFuture<ApiResponse<Object>> getAccessories() {
		return getByType("accessories");
	}

	/**
	 * Get consumables only.
	 *
	 * @return CompletableFuture containing consumable items
	 */
	public CompletableFuture<ApiResponse<Object>> getConsumables() {
		return getByType("consumables");
	}

	/**
	 * Get ingredients only.
	 *
	 * @return CompletableFuture containing ingredient items
	 */
	public CompletableFuture<ApiResponse<Object>> getIngredients() {
		return getByType("ingredients");
	}

	/**
	 * Get materials only.
	 *
	 * @return CompletableFuture containing material items
	 */
	public CompletableFuture<ApiResponse<Object>> getMaterials() {
		return getByType("materials");
	}

	/**
	 * Get legendary items only.
	 *
	 * @return CompletableFuture containing legendary items
	 */
	public CompletableFuture<ApiResponse<Object>> getLegendaryItems() {
		return getByRarity("legendary");
	}

	/**
	 * Get mythic items only.
	 *
	 * @return CompletableFuture containing mythic items
	 */
	public CompletableFuture<ApiResponse<Object>> getMythicItems() {
		return getByRarity("mythic");
	}
}
