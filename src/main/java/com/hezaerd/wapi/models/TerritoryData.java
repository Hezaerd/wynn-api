package com.hezaerd.wapi.models;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Represents territory data from the Wynncraft API.
 * Used for guild territory list endpoint.
 * Based on https://docs.wynncraft.com/docs/modules/guild.html
 */
public class TerritoryData {

	// The response is a Map where keys are territory names
	private Map<String, Territory> territories;

	public Map<String, Territory> getTerritories() {
		return territories;
	}

	public void setTerritories(Map<String, Territory> territories) {
		this.territories = territories;
	}

	/**
	 * Individual territory information.
	 */
	public static class Territory {
		@SerializedName("guild")
		private TerritoryGuild guild;

		@SerializedName("acquired")
		private String acquired;

		@SerializedName("location")
		private TerritoryLocation location;

		public TerritoryGuild getGuild() { return guild; }
		public String getAcquired() { return acquired; }
		public TerritoryLocation getLocation() { return location; }

		@Override
		public String toString() {
			return "Territory{guild=" + guild + ", acquired='" + acquired + "'}";
		}
	}

	/**
	 * Guild information for territory owner.
	 */
	public static class TerritoryGuild {
		@SerializedName("uuid")
		private String uuid;

		@SerializedName("name")
		private String name;

		@SerializedName("prefix")
		private String prefix;

		public String getUuid() { return uuid; }
		public String getName() { return name; }
		public String getPrefix() { return prefix; }

		@Override
		public String toString() {
			return "TerritoryGuild{name='" + name + "', prefix='" + prefix + "'}";
		}
	}

	/**
	 * Territory location coordinates.
	 */
	public static class TerritoryLocation {
		@SerializedName("start")
		private List<Integer> start;

		@SerializedName("end")
		private List<Integer> end;

		public List<Integer> getStart() { return start; }
		public List<Integer> getEnd() { return end; }

		/**
		 * Get start X coordinate.
		 */
		public int getStartX() {
			return start != null && start.size() >= 1 ? start.get(0) : 0;
		}

		/**
		 * Get start Z coordinate.
		 */
		public int getStartZ() {
			return start != null && start.size() >= 2 ? start.get(1) : 0;
		}

		/**
		 * Get end X coordinate.
		 */
		public int getEndX() {
			return end != null && end.size() >= 1 ? end.get(0) : 0;
		}

		/**
		 * Get end Z coordinate.
		 */
		public int getEndZ() {
			return end != null && end.size() >= 2 ? end.get(1) : 0;
		}

		@Override
		public String toString() {
			return "TerritoryLocation{start=" + start + ", end=" + end + "}";
		}
	}
}
