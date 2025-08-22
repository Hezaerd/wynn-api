package com.hezaerd.wapi.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Represents search results from the Wynncraft API.
 */
public class SearchResults {
	@SerializedName("players")
	private List<String> players;

	@SerializedName("guilds")
	private List<String> guilds;

	@SerializedName("items")
	private List<String> items;

	public List<String> getPlayers() { return players; }
	public List<String> getGuilds() { return guilds; }
	public List<String> getItems() { return items; }

	@Override
	public String toString() {
		return "SearchResults{players=" + (players != null ? players.size() : 0) +
			", guilds=" + (guilds != null ? guilds.size() : 0) +
			", items=" + (items != null ? items.size() : 0) + "}";
	}
}
