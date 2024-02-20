package com.ali.kidslearing.util;

import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreferencesHelper(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    // Save String value
    public void saveString(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    // Retrieve String value
    public String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    // Save Int value
    public void saveInt(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    // Retrieve Int value
    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }
}
