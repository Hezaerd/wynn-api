package com.hezaerd.wapi.models;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Represents guild data from the Wynncraft API.
 * Based on the Guild module documentation at https://docs.wynncraft.com/docs/modules/guild.html
 */
public class GuildData {
	@SerializedName("uuid")
	private String uuid;

	@SerializedName("name")
	private String name;

	@SerializedName("prefix")
	private String prefix;

	@SerializedName("level")
	private int level;

	@SerializedName("xpPercent")
	private int xpPercent;

	@SerializedName("territories")
	private int territories;

	@SerializedName("wars")
	private int wars;

	@SerializedName("created")
	private String created;

	@SerializedName("members")
	private GuildMembers members;

	@SerializedName("online")
	private int online;

	@SerializedName("banner")
	private GuildBanner banner;

	@SerializedName("seasonRanks")
	private Map<String, SeasonRank> seasonRanks;

	// Getters
	public String getUuid() { return uuid; }
	public String getName() { return name; }
	public String getPrefix() { return prefix; }
	public int getLevel() { return level; }
	public int getXpPercent() { return xpPercent; }
	public int getTerritories() { return territories; }
	public int getWars() { return wars; }
	public String getCreated() { return created; }
	public GuildMembers getMembers() { return members; }
	public int getOnline() { return online; }
	public GuildBanner getBanner() { return banner; }
	public Map<String, SeasonRank> getSeasonRanks() { return seasonRanks; }

	@Override
	public String toString() {
		return "GuildData{name='" + name + "', prefix='" + prefix + "', level=" + level + "}";
	}

	/**
	 * Guild members structure with different ranks.
	 */
	public static class GuildMembers {
		@SerializedName("total")
		private int total;

		@SerializedName("owner")
		private Map<String, GuildMember> owner;

		@SerializedName("chief")
		private Map<String, GuildMember> chief;

		@SerializedName("strategist")
		private Map<String, GuildMember> strategist;

		@SerializedName("captain")
		private Map<String, GuildMember> captain;

		@SerializedName("recruiter")
		private Map<String, GuildMember> recruiter;

		@SerializedName("recruit")
		private Map<String, GuildMember> recruit;

		public int getTotal() { return total; }
		public Map<String, GuildMember> getOwner() { return owner; }
		public Map<String, GuildMember> getChief() { return chief; }
		public Map<String, GuildMember> getStrategist() { return strategist; }
		public Map<String, GuildMember> getCaptain() { return captain; }
		public Map<String, GuildMember> getRecruiter() { return recruiter; }
		public Map<String, GuildMember> getRecruit() { return recruit; }
	}

	/**
	 * Individual guild member data.
	 */
	public static class GuildMember {
		@SerializedName("online")
		private boolean online;

		@SerializedName("server")
		private String server;

		@SerializedName("contributed")
		private int contributed;

		@SerializedName("guildRank")
		private int guildRank;

		@SerializedName("contributionRank")
		private Integer contributionRank;

		@SerializedName("joined")
		private String joined;

		public boolean isOnline() { return online; }
		public String getServer() { return server; }
		public int getContributed() { return contributed; }
		public int getGuildRank() { return guildRank; }
		public Integer getContributionRank() { return contributionRank; }
		public String getJoined() { return joined; }
	}

	/**
	 * Guild banner information.
	 */
	public static class GuildBanner {
		@SerializedName("base")
		private String base;

		@SerializedName("tier")
		private int tier;

		@SerializedName("structure")
		private String structure;

		@SerializedName("layers")
		private List<BannerLayer> layers;

		public String getBase() { return base; }
		public int getTier() { return tier; }
		public String getStructure() { return structure; }
		public List<BannerLayer> getLayers() { return layers; }

		/**
		 * Banner layer data.
		 */
		public static class BannerLayer {
			@SerializedName("colour")
			private String colour;

			@SerializedName("pattern")
			private String pattern;

			public String getColour() { return colour; }
			public String getPattern() { return pattern; }
		}
	}

	/**
	 * Season ranking data.
	 */
	public static class SeasonRank {
		@SerializedName("rating")
		private int rating;

		@SerializedName("finalTerritories")
		private int finalTerritories;

		public int getRating() { return rating; }
		public int getFinalTerritories() { return finalTerritories; }
	}
}
