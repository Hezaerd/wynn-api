package com.hezaerd;

import com.hezaerd.utils.ModLib;
import net.fabricmc.api.ModInitializer;

public class WynnAPI implements ModInitializer {
	@Override
	public void onInitialize() {
		ModLib.LOGGER.info("Successfully initialized");
	}
}
