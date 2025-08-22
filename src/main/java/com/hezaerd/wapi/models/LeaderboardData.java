package com.hezaerd.wapi.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Represents leaderboard data from the Wynncraft API.
 * Based on common leaderboard API patterns.
 */
public class LeaderboardData {
	@SerializedName("entries")
	private List<LeaderboardEntry> entries;

	@SerializedName("timeframe")
	private String timeframe;

	@SerializedName("type")
	private String type;

	@SerializedName("lastUpdated")
	private String lastUpdated;

	public List<LeaderboardEntry> getEntries() { return entries; }
	public String getTimeframe() { return timeframe; }
	public String getType() { return type; }
	public String getLastUpdated() { return lastUpdated; }

	/**
	 * Individual leaderboard entry.
	 */
	public static class LeaderboardEntry {
		@SerializedName("rank")
		private int rank;

		@SerializedName("name")
		private String name;

		@SerializedName("value")
		private Object value; // Can be number or string

		@SerializedName("level")
		private Integer level;

		@SerializedName("class")
		private String characterClass;

		@SerializedName("guild")
		private String guild;

		@SerializedName("score")
		private Long score;

		public int getRank() { return rank; }
		public String getName() { return name; }
		public Object getValue() { return value; }
		public Integer getLevel() { return level; }
		public String getCharacterClass() { return characterClass; }
		public String getGuild() { return guild; }
		public Long getScore() { return score; }

		@Override
		public String toString() {
			return "LeaderboardEntry{rank=" + rank + ", name='" + name + "', value=" + value + "}";
		}
	}
}
