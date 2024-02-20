package com.ali.kidslearing.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesSingleton {

    private static SharedPreferencesSingleton instance;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "kidslearningsp";

    private SharedPreferencesSingleton(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPreferencesSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesSingleton(context);
        }
        return instance;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
