package com.hezaerd.wapi.modules;

import java.util.concurrent.CompletableFuture;

import com.hezaerd.wapi.client.WapiHttpClient;
import com.hezaerd.wapi.models.ApiResponse;

/**
 * Module for interacting with <a href="https://docs.wynncraft.com/docs/modules/map.html">Wynncraft Map API endpoints</a>
 */
public class MapModule {
	private final WapiHttpClient httpClient;

	public MapModule(WapiHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	/**
	 * Get map locations.
	 *
	 * @return CompletableFuture containing map location data
	 */
	public CompletableFuture<ApiResponse<Object>> getLocations() {
		return httpClient.get("/v3/map/locations", Object.class);
	}

	/**
	 * Get map markers.
	 *
	 * @return CompletableFuture containing map marker data
	 */
	public CompletableFuture<ApiResponse<Object>> getMarkers() {
		return httpClient.get("/v3/map/markers", Object.class);
	}

	/**
	 * Get territories data.
	 *
	 * @return CompletableFuture containing territory data
	 */
	public CompletableFuture<ApiResponse<Object>> getTerritories() {
		return httpClient.get("/v3/map/territories", Object.class);
	}

	/**
	 * Get location by name.
	 *
	 * @param locationName The name of the location
	 * @return CompletableFuture containing location data
	 */
	public CompletableFuture<ApiResponse<Object>> getLocation(String locationName) {
		return httpClient.get("/v3/map/location/" + locationName, Object.class);
	}
}
