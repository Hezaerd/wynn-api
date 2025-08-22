package com.hezaerd.wapi;

import com.hezaerd.wapi.utils.ModLib;

import net.fabricmc.api.ModInitializer;

public class WynnAPI implements ModInitializer {
	@Override
	public void onInitialize() {
		ModLib.LOGGER.info("Successfully initialized");
	}
}
