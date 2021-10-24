/*******************************************************************************
 * © 2021 Copyright Aayamya Tech.
 *
 ******************************************************************************/
package com.aayamyatech.aayamya;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

import com.aayamyatech.aayamya.constant.Constant;
import com.aayamyatech.aayamya.utils.SharedInfoManager;

/**
 * @author anilpraharaj on 14/8/21
 */
public class AayamyaApplication extends Application {

    static AayamyaApplication application;

    /**
     * Singleton Instance for App Application Object
     *
     * @return AayamyaApplication Singleton Object
     */
    public static AayamyaApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        application = this; // Set Application object to static application variable

        switch (getThemeState()) {
            case Constant.DARK_THEME_STATE:
                setDarkTheme();
                break;

            default:
                setLightTheme();
        }
    }

    /**
     * Get selected theme
     *
     * @return LIGHT_THEME or DARK_THEME
     */
    public int getThemeState() {
        return SharedInfoManager.getPreferenceManager().getIntValue(getResources().getString(Constant.THEME_STATE));
    }

    /**
     * Set Dark theme to the app
     */
    public void setDarkTheme() {
        SharedInfoManager.getPreferenceManager().setIntValue(getResources().getString(Constant.THEME_STATE), getResources().getInteger(Constant.DARK_THEME_STATE));
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    /**
     * Set light theme to the app
     */
    public void setLightTheme() {
        SharedInfoManager.getPreferenceManager().setIntValue(getResources().getString(Constant.THEME_STATE), getResources().getInteger(Constant.LIGHT_THEME_STATE));
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
}
