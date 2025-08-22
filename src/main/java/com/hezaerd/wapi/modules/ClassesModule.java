package com.hezaerd.wapi.modules;

import java.util.concurrent.CompletableFuture;

import com.hezaerd.wapi.client.WapiHttpClient;
import com.hezaerd.wapi.models.ApiResponse;

/**
 * Module for interacting with <a href="https://docs.wynncraft.com/docs/modules/classes.html">Wynncraft Classes API endpoints</a>
 */
public class ClassesModule {
	private final WapiHttpClient httpClient;

	public ClassesModule(WapiHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	/**
	 * Get all available classes.
	 *
	 * @return CompletableFuture containing all class data
	 */
	public CompletableFuture<ApiResponse<Object>> getAllClasses() {
		return httpClient.get("/v3/classes", Object.class);
	}

	/**
	 * Get specific class information.
	 *
	 * @param className The name of the class
	 * @return CompletableFuture containing class data
	 */
	public CompletableFuture<ApiResponse<Object>> getClass(String className) {
		return httpClient.get("/v3/classes/" + className, Object.class);
	}

	/**
	 * Convenience methods for getting specific classes.
	 */
	public CompletableFuture<ApiResponse<Object>> getWarrior() {
		return getClass("warrior");
	}

	public CompletableFuture<ApiResponse<Object>> getArcher() {
		return getClass("archer");
	}

	public CompletableFuture<ApiResponse<Object>> getMage() {
		return getClass("mage");
	}

	public CompletableFuture<ApiResponse<Object>> getAssassin() {
		return getClass("assassin");
	}

	public CompletableFuture<ApiResponse<Object>> getShaman() {
		return getClass("shaman");
	}
}
