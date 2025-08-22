package com.hezaerd.wapi.models;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Represents class data from the Wynncraft API.
 */
public class ClassData {
	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("playstyle")
	private String playstyle;

	@SerializedName("difficulty")
	private String difficulty;

	@SerializedName("abilities")
	private Map<String, Object> abilities;

	public String getName() { return name; }
	public String getDescription() { return description; }
	public String getPlaystyle() { return playstyle; }
	public String getDifficulty() { return difficulty; }
	public Map<String, Object> getAbilities() { return abilities; }

	@Override
	public String toString() {
		return "ClassData{name='" + name + "', difficulty='" + difficulty + "'}";
	}
}
