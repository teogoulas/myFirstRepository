package com.syllogos.model;

public class GlobalVariables {

	private static String locale = "gr";

	public static String getLocale() {
		return locale;
	}

	public static void setLocale(String locale) {
		GlobalVariables.locale = locale;
	}
}
