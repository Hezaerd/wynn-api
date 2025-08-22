package com.hezaerd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 */
public final class ModLib {
	private ModLib() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}

	public static final String MOD_ID = "wapi";
	public static final String MOD_NAME = "WynnAPI";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
}
