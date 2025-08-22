package com.hezaerd.wapi.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Response wrapper for online players API calls.
 */
public class OnlinePlayersResponse {
	@SerializedName("players")
	private List<String> players;

	@SerializedName("count")
	private int count;

	public List<String> getPlayers() {
		return players;
	}

	public int getCount() {
		return count;
	}
}
