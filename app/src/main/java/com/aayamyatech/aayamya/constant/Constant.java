/*******************************************************************************
 * © 2021 Copyright Aayamya Tech.
 *
 ******************************************************************************/
package com.aayamyatech.aayamya.constant;

import com.aayamyatech.aayamya.R;

/**
 * @author anilpraharaj on 23/10/21
 */
public interface Constant {

    // ID Constant
    int BASE_CONTAINER_ID = R.id.frame_layout_container;
    int CONTENT_ID = android.R.id.content;

    // Layout Constant
    int MAIN_ACTIVITY_LAYOUT_ID = R.layout.activity_main;
    int LOGIN_FRAGMENT_LAYOUT_ID = R.layout.fragment_login;
    int SPLASH_FRAGMENT_LAYOUT_ID = R.layout.fragment_splash;
    int DASHBOARD_FRAGMENT_LAYOUT_ID = R.layout.fragment_dashboard;
    int DYNAMIC_FRAGMENT_LAYOUT_ID = R.layout.fragment_dynamic;

    // Integer Constant
    int DARK_THEME_STATE = R.integer.dark_theme_state;
    int LIGHT_THEME_STATE = R.integer.light_theme_state;

    // String Constant
    int THEME_STATE = R.string.theme_state;
    int PLEASE_WAIT = R.string.please_wait;

    // Color Constant
    int ON_ERROR = R.color.on_error;
    int ON_SUCCESS = R.color.on_success;
}
