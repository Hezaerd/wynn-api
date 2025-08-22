package com.hezaerd.wapi.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Response wrapper for character list API calls.
 */
public class CharacterListResponse {
	@SerializedName("characters")
	private List<CharacterData> characters;

	public List<CharacterData> getCharacters() {
		return characters;
	}
}
