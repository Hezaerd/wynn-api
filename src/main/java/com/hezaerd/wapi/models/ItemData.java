package com.hezaerd.wapi.models;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Represents item data from the Wynncraft API.
 * Based on the Item module documentation at https://docs.wynncraft.com/docs/modules/item.html
 */
public class ItemData {
	@SerializedName("internalName")
	private String internalName;

	@SerializedName("type")
	private String type;

	@SerializedName("subType")
	private String subType;

	@SerializedName("icon")
	private ItemIcon icon;

	@SerializedName("identifier")
	private Boolean identifier;

	@SerializedName("allow_craftsman")
	private Boolean allowCraftsman;

	// Variable keys depending on type
	@SerializedName("armourMaterial")
	private String armourMaterial; // Armours

	@SerializedName("attackSpeed")
	private String attackSpeed; // Weapons

	@SerializedName("averageDPS")
	private Integer averageDPS; // Weapons

	@SerializedName("gatheringSpeed")
	private Integer gatheringSpeed; // Tools

	@SerializedName("tier")
	private String tier; // For ingredients and materials

	@SerializedName("rarity")
	private String rarity; // For normal items

	@SerializedName("consumableOnlyIDs")
	private ConsumableOnlyIDs consumableOnlyIDs; // Ingredients

	@SerializedName("ingredientPositionModifiers")
	private IngredientPositionModifiers ingredientPositionModifiers; // Ingredients

	@SerializedName("itemOnlyIDs")
	private ItemOnlyIDs itemOnlyIDs; // Ingredients

	@SerializedName("majorIds")
	private Map<String, String> majorIds;

	@SerializedName("craftable")
	private List<String> craftable; // Materials

	@SerializedName("powderSlots")
	private Integer powderSlots;

	@SerializedName("lore")
	private String lore;

	@SerializedName("dropRestriction")
	private String dropRestriction;

	@SerializedName("restriction")
	private String restriction;

	@SerializedName("raidReward")
	private Boolean raidReward;

	@SerializedName("dropMeta")
	private DropMeta dropMeta;

	@SerializedName("base")
	private ItemBase base;

	@SerializedName("requirements")
	private ItemRequirements requirements;

	@SerializedName("identifications")
	private Map<String, Object> identifications;

	// Getters
	public String getInternalName() { return internalName; }
	public String getType() { return type; }
	public String getSubType() { return subType; }
	public ItemIcon getIcon() { return icon; }
	public Boolean getIdentifier() { return identifier; }
	public Boolean getAllowCraftsman() { return allowCraftsman; }
	public String getArmourMaterial() { return armourMaterial; }
	public String getAttackSpeed() { return attackSpeed; }
	public Integer getAverageDPS() { return averageDPS; }
	public Integer getGatheringSpeed() { return gatheringSpeed; }
	public String getTier() { return tier; }
	public String getRarity() { return rarity; }
	public ConsumableOnlyIDs getConsumableOnlyIDs() { return consumableOnlyIDs; }
	public IngredientPositionModifiers getIngredientPositionModifiers() { return ingredientPositionModifiers; }
	public ItemOnlyIDs getItemOnlyIDs() { return itemOnlyIDs; }
	public Map<String, String> getMajorIds() { return majorIds; }
	public List<String> getCraftable() { return craftable; }
	public Integer getPowderSlots() { return powderSlots; }
	public String getLore() { return lore; }
	public String getDropRestriction() { return dropRestriction; }
	public String getRestriction() { return restriction; }
	public Boolean getRaidReward() { return raidReward; }
	public DropMeta getDropMeta() { return dropMeta; }
	public ItemBase getBase() { return base; }
	public ItemRequirements getRequirements() { return requirements; }
	public Map<String, Object> getIdentifications() { return identifications; }

	@Override
	public String toString() {
		return "ItemData{internalName='" + internalName + "', type='" + type + "', rarity='" + rarity + "'}";
	}

	/**
	 * Item icon data.
	 */
	public static class ItemIcon {
		@SerializedName("value")
		private Object value; // Can be dict or string

		@SerializedName("format")
		private String format;

		public Object getValue() { return value; }
		public String getFormat() { return format; }
	}

	/**
	 * Consumable-only identifications for ingredients.
	 */
	public static class ConsumableOnlyIDs {
		@SerializedName("duration")
		private Integer duration;

		@SerializedName("charges")
		private Integer charges;

		public Integer getDuration() { return duration; }
		public Integer getCharges() { return charges; }
	}

	/**
	 * Ingredient position modifiers.
	 */
	public static class IngredientPositionModifiers {
		@SerializedName("left")
		private Integer left;

		@SerializedName("right")
		private Integer right;

		@SerializedName("above")
		private Integer above;

		@SerializedName("under")
		private Integer under;

		@SerializedName("touching")
		private Integer touching;

		@SerializedName("not_touching")
		private Integer notTouching;

		public Integer getLeft() { return left; }
		public Integer getRight() { return right; }
		public Integer getAbove() { return above; }
		public Integer getUnder() { return under; }
		public Integer getTouching() { return touching; }
		public Integer getNotTouching() { return notTouching; }
	}

	/**
	 * Item-only identifications for ingredients.
	 */
	public static class ItemOnlyIDs {
		@SerializedName("durability_modifier")
		private Integer durabilityModifier;

		@SerializedName("strength_requirement")
		private Integer strengthRequirement;

		@SerializedName("dexterity_requirement")
		private Integer dexterityRequirement;

		@SerializedName("intelligence_requirement")
		private Integer intelligenceRequirement;

		@SerializedName("defence_requirement")
		private Integer defenceRequirement;

		@SerializedName("agility_requirement")
		private Integer agilityRequirement;

		public Integer getDurabilityModifier() { return durabilityModifier; }
		public Integer getStrengthRequirement() { return strengthRequirement; }
		public Integer getDexterityRequirement() { return dexterityRequirement; }
		public Integer getIntelligenceRequirement() { return intelligenceRequirement; }
		public Integer getDefenceRequirement() { return defenceRequirement; }
		public Integer getAgilityRequirement() { return agilityRequirement; }
	}

	/**
	 * Drop metadata.
	 */
	public static class DropMeta {
		@SerializedName("coordinates")
		private List<Integer> coordinates;

		@SerializedName("name")
		private String name;

		@SerializedName("type")
		private String type;

		public List<Integer> getCoordinates() { return coordinates; }
		public String getName() { return name; }
		public String getType() { return type; }
	}

	/**
	 * Item base stats.
	 */
	public static class ItemBase {
		@SerializedName("baseDamage")
		private BaseDamage baseDamage;

		public BaseDamage getBaseDamage() { return baseDamage; }

		/**
		 * Base damage values.
		 */
		public static class BaseDamage {
			@SerializedName("min")
			private Integer min;

			@SerializedName("max")
			private Integer max;

			@SerializedName("raw")
			private Integer raw;

			public Integer getMin() { return min; }
			public Integer getMax() { return max; }
			public Integer getRaw() { return raw; }
		}
	}

	/**
	 * Item requirements.
	 */
	public static class ItemRequirements {
		@SerializedName("level")
		private Integer level;

		@SerializedName("levelRange")
		private LevelRange levelRange;

		@SerializedName("strength")
		private Integer strength;

		@SerializedName("dexterity")
		private Integer dexterity;

		@SerializedName("intelligence")
		private Integer intelligence;

		@SerializedName("defence")
		private Integer defence;

		@SerializedName("agility")
		private Integer agility;

		@SerializedName("quest")
		private String quest;

		@SerializedName("class_requirement")
		private String classRequirement;

		@SerializedName("skills")
		private List<String> skills; // For ingredients

		public Integer getLevel() { return level; }
		public LevelRange getLevelRange() { return levelRange; }
		public Integer getStrength() { return strength; }
		public Integer getDexterity() { return dexterity; }
		public Integer getIntelligence() { return intelligence; }
		public Integer getDefence() { return defence; }
		public Integer getAgility() { return agility; }
		public String getQuest() { return quest; }
		public String getClassRequirement() { return classRequirement; }
		public List<String> getSkills() { return skills; }

		/**
		 * Level range for ingredients.
		 */
		public static class LevelRange {
			@SerializedName("min")
			private Integer min;

			@SerializedName("max")
			private Integer max;

			public Integer getMin() { return min; }
			public Integer getMax() { return max; }
		}
	}
}
