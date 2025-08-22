package com.hezaerd.wapi.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Represents player data from the Wynncraft API.
 */
public class PlayerData {
	@SerializedName("username")
	private String username;

	@SerializedName("uuid")
	private String uuid;

	@SerializedName("rank")
	private String rank;

	@SerializedName("contribution")
	private String contribution;

	@SerializedName("firstJoin")
	private String firstJoin;

	@SerializedName("lastJoin")
	private String lastJoin;

	@SerializedName("lastSeen")
	private String lastSeen;

	@SerializedName("playtime")
	private long playtime;

	@SerializedName("guild")
	private GuildInfo guild;

	@SerializedName("characters")
	private List<CharacterData> characters;

	@SerializedName("meta")
	private PlayerMeta meta;

	// Getters
	public String getUsername() { return username; }
	public String getUuid() { return uuid; }
	public String getRank() { return rank; }
	public String getContribution() { return contribution; }
	public String getFirstJoin() { return firstJoin; }
	public String getLastJoin() { return lastJoin; }
	public String getLastSeen() { return lastSeen; }
	public long getPlaytime() { return playtime; }
	public GuildInfo getGuild() { return guild; }
	public List<CharacterData> getCharacters() { return characters; }
	public PlayerMeta getMeta() { return meta; }

	@Override
	public String toString() {
		return "PlayerData{username='" + username + "', rank='" + rank + "', playtime=" + playtime + "}";
	}

	/**
	 * Guild information for a player.
	 */
	public static class GuildInfo {
		@SerializedName("name")
		private String name;

		@SerializedName("rank")
		private String rank;

		public String getName() { return name; }
		public String getRank() { return rank; }
	}

	/**
	 * Player metadata information.
	 */
	public static class PlayerMeta {
		@SerializedName("location")
		private String location;

		@SerializedName("server")
		private String server;

		@SerializedName("firstJoin")
		private long firstJoin;

		@SerializedName("lastJoin")
		private long lastJoin;

		public String getLocation() { return location; }
		public String getServer() { return server; }
		public long getFirstJoin() { return firstJoin; }
		public long getLastJoin() { return lastJoin; }
	}
}
