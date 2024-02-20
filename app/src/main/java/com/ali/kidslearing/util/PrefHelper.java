package com.ali.kidslearing.util;

import android.content.Context;

import com.ali.kidslearing.activity.SplashActivity;

public class PrefHelper {
    private static SharedPreferencesHelper helper;

    public  static  SharedPreferencesHelper getPrefHelper(Context c){
        if(helper ==null) {
            SharedPreferencesSingleton sharedPreferencesSingleton = SharedPreferencesSingleton.getInstance(c);
            helper = new SharedPreferencesHelper(sharedPreferencesSingleton.getSharedPreferences());
        }
        return helper;

    }
}
