package com.hezaerd.wapi.models;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Response wrapper for item database API calls (paginated version).
 * Based on https://docs.wynncraft.com/docs/modules/item.html
 */
public class ItemDatabaseResponse {
	@SerializedName("controller")
	private PaginationController controller;

	@SerializedName("results")
	private Map<String, ItemData> results;

	public PaginationController getController() { return controller; }
	public Map<String, ItemData> getResults() { return results; }

	/**
	 * Pagination controller for item database responses.
	 */
	public static class PaginationController {
		@SerializedName("count")
		private int count;

		@SerializedName("pages")
		private int pages;

		@SerializedName("previous")
		private String previous;

		@SerializedName("current")
		private int current;

		@SerializedName("next")
		private Integer next;

		@SerializedName("links")
		private PaginationLinks links;

		public int getCount() { return count; }
		public int getPages() { return pages; }
		public String getPrevious() { return previous; }
		public int getCurrent() { return current; }
		public Integer getNext() { return next; }
		public PaginationLinks getLinks() { return links; }

		/**
		 * Pagination links.
		 */
		public static class PaginationLinks {
			@SerializedName("previous")
			private String previous;

			@SerializedName("next")
			private String next;

			public String getPrevious() { return previous; }
			public String getNext() { return next; }
		}
	}
}
