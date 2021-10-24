/*******************************************************************************
 * © 2021 Copyright Aayamya Tech.
 *
 ******************************************************************************/
package com.aayamyatech.aayamya.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.aayamyatech.aayamya.AayamyaApplication;

/**
 * @author anilpraharaj on 14/8/21
 */
public class SharedInfoManager {

    private static final String SHARED_PREFERENCE_NAME = "YWF5YW15YXRlY2guZHluYW1vLnN0YXRl";
    static SharedInfoManager sharedInfoManager;
    static SharedPreferences preferences;

    public static SharedInfoManager getPreferenceManager() {
        if (sharedInfoManager == null || preferences == null) {
            preferences = AayamyaApplication.getInstance().getSharedPreferences(Decoder.decodeValue(SHARED_PREFERENCE_NAME), Context.MODE_PRIVATE);
            sharedInfoManager = new SharedInfoManager();
        }

        return sharedInfoManager;
    }

    public void saveString(String key, String value) {
        preferences.edit().putString(key, value).apply();
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }

    public boolean getBool(String key) {
        boolean res = preferences.getBoolean(key, false);
        return res;
    }

    public void saveBool(String key, boolean val) {
        preferences.edit().putBoolean(key, val).apply();
    }

    public int getIntValue(String key) {
        return preferences.getInt(key, 0);
    }

    public void setIntValue(String key, int value) {
        preferences.edit().putInt(key, value).apply();
    }

    public void setLongValue(String key, long value) {
        preferences.edit().putLong(key, value).apply();
    }

    public long getLongValue(String key) {
        return preferences.getLong(key, 0);
    }

    public float getFloatValue(String key) {
        return preferences.getFloat(key, 0.0f);
    }

    public void setFloatValue(String key, float value) {
        preferences.edit().putFloat(key, value).apply();
    }

    public void clear() {
        preferences.edit().clear().apply();
    }
}
