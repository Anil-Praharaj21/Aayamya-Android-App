/*******************************************************************************
 * © 2021 Copyright Aayamya Tech.
 *
 ******************************************************************************/
package com.aayamyatech.aayamya.utils;


import android.util.Base64;
import android.util.Log;

import com.aayamyatech.aayamya.BuildConfig;

import java.nio.charset.StandardCharsets;

/**
 * @author anilpraharaj on 15/8/21
 */
public class Decoder {

    public static String decodeValue(String value) {
        byte[] data = Base64.decode(value.replace(BuildConfig.random, ""), Base64.DEFAULT);
        String text = new String(data, StandardCharsets.UTF_8);
        return text;
    }
}
