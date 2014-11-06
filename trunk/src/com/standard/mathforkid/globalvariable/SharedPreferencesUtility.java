package com.standard.mathforkid.globalvariable;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesUtility {

	private static String shared_name = "freaking_math_shared";

	public static String getStringPreferences(String key, String defaultValue, Context context) {
		SharedPreferences sharedPreferences =context.getSharedPreferences(shared_name,0);		
		String name = sharedPreferences.getString(key, defaultValue);
		return name;
	}

	public static int getIntPreferences(String key, int defaultValue, Context context) {
		SharedPreferences sharedPreferences =context.getSharedPreferences(shared_name,0);		
		int name = sharedPreferences.getInt(key, defaultValue);
		return name;
	}
	
	public static void savePreferences(String key, boolean value,Context context) {
		SharedPreferences sharedPreferences =context.getSharedPreferences(shared_name,0);
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public static void savePreferences(String key, String value, Context context) {
		SharedPreferences sharedPreferences =context.getSharedPreferences(shared_name,0);
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}
	public static void savePreferences(String key, int value, Context context) {
		SharedPreferences sharedPreferences =context.getSharedPreferences(shared_name,0);
		Editor editor = sharedPreferences.edit();
		editor.putInt(key, value);
		editor.commit();
	}
}