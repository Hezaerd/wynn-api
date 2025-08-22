package com.hezaerd.wapi.models;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Response wrapper for guild list API calls.
 * The response structure changes based on the identifier parameter.
 * Based on https://docs.wynncraft.com/docs/modules/guild.html
 */
public class GuildListResponse {

	// The response is a Map where keys are either guild UUIDs or names
	// depending on the identifier parameter used
	private Map<String, GuildListEntry> guilds;

	public Map<String, GuildListEntry> getGuilds() {
		return guilds;
	}

	public void setGuilds(Map<String, GuildListEntry> guilds) {
		this.guilds = guilds;
	}

	/**
	 * Individual guild entry in the list.
	 * Contains basic guild information.
	 */
	public static class GuildListEntry {
		@SerializedName("uuid")
		private String uuid;

		@SerializedName("name")
		private String name;

		@SerializedName("prefix")
		private String prefix;

		@SerializedName("level")
		private Integer level;

		@SerializedName("territories")
		private Integer territories;

		@SerializedName("wars")
		private Integer wars;

		@SerializedName("members")
		private Integer members;

		@SerializedName("created")
		private String created;

		public String getUuid() { return uuid; }
		public String getName() { return name; }
		public String getPrefix() { return prefix; }
		public Integer getLevel() { return level; }
		public Integer getTerritories() { return territories; }
		public Integer getWars() { return wars; }
		public Integer getMembers() { return members; }
		public String getCreated() { return created; }

		@Override
		public String toString() {
			return "GuildListEntry{name='" + name + "', prefix='" + prefix + "'}";
		}
	}
}
