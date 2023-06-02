package com.token.api.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Token {
	
	private static Map<Calendar, String> tokenMap = new HashMap<>();

	public static Map<Calendar, String> getTokenMap() {
		return tokenMap;
	}

	public static void setTokenMap(Map<Calendar, String> tokenMap) {
		Token.tokenMap = tokenMap;
	}

	
}
