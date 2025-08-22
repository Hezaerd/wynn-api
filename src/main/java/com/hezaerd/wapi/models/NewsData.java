package com.hezaerd.wapi.models;

import com.google.gson.annotations.SerializedName;

/**
 * Represents news data from the Wynncraft API.
 */
public class NewsData {
	@SerializedName("title")
	private String title;

	@SerializedName("content")
	private String content;

	@SerializedName("date")
	private String date;

	@SerializedName("author")
	private String author;

	@SerializedName("url")
	private String url;

	@SerializedName("category")
	private String category;

	public String getTitle() { return title; }
	public String getContent() { return content; }
	public String getDate() { return date; }
	public String getAuthor() { return author; }
	public String getUrl() { return url; }
	public String getCategory() { return category; }

	@Override
	public String toString() {
		return "NewsData{title='" + title + "', date='" + date + "', author='" + author + "'}";
	}
}
