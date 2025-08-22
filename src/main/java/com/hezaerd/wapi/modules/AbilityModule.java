package com.hezaerd.wapi.modules;

import java.util.concurrent.CompletableFuture;

import com.hezaerd.wapi.client.WapiHttpClient;
import com.hezaerd.wapi.models.ApiResponse;

/**
 * Module for interacting with <a href="https://docs.wynncraft.com/docs/modules/ability.html">Wynncraft Ability & Aspects API endpoints</a>
 */
public class AbilityModule {
	private final WapiHttpClient httpClient;

	public AbilityModule(WapiHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	/**
	 * Get all abilities.
	 *
	 * @return CompletableFuture containing ability data
	 */
	public CompletableFuture<ApiResponse<Object>> getAbilities() {
		return httpClient.get("/v3/abilities", Object.class);
	}

	/**
	 * Get specific ability.
	 *
	 * @param abilityName The name of the ability
	 * @return CompletableFuture containing ability data
	 */
	public CompletableFuture<ApiResponse<Object>> getAbility(String abilityName) {
		return httpClient.get("/v3/abilities/" + abilityName, Object.class);
	}

	/**
	 * Get all aspects.
	 *
	 * @return CompletableFuture containing aspect data
	 */
	public CompletableFuture<ApiResponse<Object>> getAspects() {
		return httpClient.get("/v3/aspects", Object.class);
	}

	/**
	 * Get specific aspect.
	 *
	 * @param aspectName The name of the aspect
	 * @return CompletableFuture containing aspect data
	 */
	public CompletableFuture<ApiResponse<Object>> getAspect(String aspectName) {
		return httpClient.get("/v3/aspects/" + aspectName, Object.class);
	}

	/**
	 * Get abilities by class.
	 *
	 * @param className The class name
	 * @return CompletableFuture containing class abilities
	 */
	public CompletableFuture<ApiResponse<Object>> getAbilitiesByClass(String className) {
		return httpClient.get("/v3/abilities", Object.class, "class", className);
	}
}
