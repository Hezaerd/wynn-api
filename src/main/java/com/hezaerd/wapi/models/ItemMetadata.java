package com.hezaerd.wapi.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Represents item metadata from the Wynncraft API.
 * Contains all available filters and identifications for advanced search.
 * Based on https://docs.wynncraft.com/docs/modules/item.html
 */
public class ItemMetadata {
	@SerializedName("identifications")
	private List<String> identifications;

	@SerializedName("majorIds")
	private List<String> majorIds;

	@SerializedName("filters")
	private ItemFilters filters;

	public List<String> getIdentifications() { return identifications; }
	public List<String> getMajorIds() { return majorIds; }
	public ItemFilters getFilters() { return filters; }

	/**
	 * Available filters for item search.
	 */
	public static class ItemFilters {
		@SerializedName("type")
		private List<String> type;

		@SerializedName("advanced")
		private AdvancedFilters advanced;

		@SerializedName("tier")
		private TierFilters tier;

		@SerializedName("levelRange")
		private LevelRangeFilters levelRange;

		public List<String> getType() { return type; }
		public AdvancedFilters getAdvanced() { return advanced; }
		public TierFilters getTier() { return tier; }
		public LevelRangeFilters getLevelRange() { return levelRange; }

		/**
		 * Advanced filters (subtypes for main filters).
		 */
		public static class AdvancedFilters {
			@SerializedName("attackSpeed")
			private List<String> attackSpeed;

			@SerializedName("weapons")
			private List<String> weapons;

			@SerializedName("armour")
			private List<String> armour;

			@SerializedName("accessories")
			private List<String> accessories;

			@SerializedName("tomes")
			private List<String> tomes;

			@SerializedName("tools")
			private List<String> tools;

			@SerializedName("crafting")
			private List<String> crafting;

			@SerializedName("gathering")
			private List<String> gathering;

			public List<String> getAttackSpeed() { return attackSpeed; }
			public List<String> getWeapons() { return weapons; }
			public List<String> getArmour() { return armour; }
			public List<String> getAccessories() { return accessories; }
			public List<String> getTomes() { return tomes; }
			public List<String> getTools() { return tools; }
			public List<String> getCrafting() { return crafting; }
			public List<String> getGathering() { return gathering; }
		}

		/**
		 * Tier filters for items and ingredients.
		 */
		public static class TierFilters {
			@SerializedName("items")
			private List<String> items;

			@SerializedName("ingredients")
			private List<Integer> ingredients;

			public List<String> getItems() { return items; }
			public List<Integer> getIngredients() { return ingredients; }
		}

		/**
		 * Level range filters.
		 */
		public static class LevelRangeFilters {
			@SerializedName("items")
			private Integer items;

			@SerializedName("ingredients")
			private Integer ingredients;

			public Integer getItems() { return items; }
			public Integer getIngredients() { return ingredients; }
		}
	}
}
