package com.hezaerd.wapi.models;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Represents character data from the Wynncraft API.
 */
public class CharacterData {
	@SerializedName("name")
	private String name;

	@SerializedName("type")
	private String type;

	@SerializedName("level")
	private int level;

	@SerializedName("xp")
	private long xp;

	@SerializedName("professions")
	private Map<String, ProfessionData> professions;

	@SerializedName("dungeons")
	private Map<String, DungeonData> dungeons;

	@SerializedName("raids")
	private Map<String, RaidData> raids;

	@SerializedName("quests")
	private Map<String, QuestData> quests;

	@SerializedName("items")
	private Map<String, ItemData> items;

	@SerializedName("skills")
	private Map<String, SkillData> skills;

	// Getters
	public String getName() { return name; }
	public String getType() { return type; }
	public int getLevel() { return level; }
	public long getXp() { return xp; }
	public Map<String, ProfessionData> getProfessions() { return professions; }
	public Map<String, DungeonData> getDungeons() { return dungeons; }
	public Map<String, RaidData> getRaids() { return raids; }
	public Map<String, QuestData> getQuests() { return quests; }
	public Map<String, ItemData> getItems() { return items; }
	public Map<String, SkillData> getSkills() { return skills; }

	@Override
	public String toString() {
		return "CharacterData{name='" + name + "', type='" + type + "', level=" + level + "}";
	}

	/**
	 * Profession data for a character.
	 */
	public static class ProfessionData {
		@SerializedName("level")
		private int level;

		@SerializedName("xp")
		private long xp;

		public int getLevel() { return level; }
		public long getXp() { return xp; }
	}

	/**
	 * Dungeon data for a character.
	 */
	public static class DungeonData {
		@SerializedName("completed")
		private int completed;

		@SerializedName("completions")
		private int completions;

		public int getCompleted() { return completed; }
		public int getCompletions() { return completions; }
	}

	/**
	 * Raid data for a character.
	 */
	public static class RaidData {
		@SerializedName("completed")
		private int completed;

		@SerializedName("completions")
		private int completions;

		public int getCompleted() { return completed; }
		public int getCompletions() { return completions; }
	}

	/**
	 * Quest data for a character.
	 */
	public static class QuestData {
		@SerializedName("status")
		private String status;

		@SerializedName("progress")
		private int progress;

		public String getStatus() { return status; }
		public int getProgress() { return progress; }
	}

	/**
	 * Item data for a character.
	 */
	public static class ItemData {
		@SerializedName("name")
		private String name;

		@SerializedName("rarity")
		private String rarity;

		@SerializedName("level")
		private int level;

		public String getName() { return name; }
		public String getRarity() { return rarity; }
		public int getLevel() { return level; }
	}

	/**
	 * Skill data for a character.
	 */
	public static class SkillData {
		@SerializedName("level")
		private int level;

		@SerializedName("xp")
		private long xp;

		public int getLevel() { return level; }
		public long getXp() { return xp; }
	}
}
