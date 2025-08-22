package com.hezaerd.wapi.models;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Represents character ability map from the Wynncraft API.
 */
public class AbilityMap {
	@SerializedName("abilities")
	private Map<String, AbilityData> abilities;

	public Map<String, AbilityData> getAbilities() {
		return abilities;
	}

	/**
	 * Individual ability data.
	 */
	public static class AbilityData {
		@SerializedName("name")
		private String name;

		@SerializedName("description")
		private String description;

		@SerializedName("level")
		private int level;

		@SerializedName("maxLevel")
		private int maxLevel;

		public String getName() { return name; }
		public String getDescription() { return description; }
		public int getLevel() { return level; }
		public int getMaxLevel() { return maxLevel; }
	}
}
