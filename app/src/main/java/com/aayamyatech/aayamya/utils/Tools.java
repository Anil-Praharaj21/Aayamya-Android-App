/*******************************************************************************
 * © 2021 Copyright Aayamya Tech.
 *
 ******************************************************************************/
package com.aayamyatech.aayamya.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.aayamyatech.aayamya.AayamyaApplication;
import com.aayamyatech.aayamya.R;
import com.aayamyatech.aayamya.constant.Constant;
import com.google.android.material.snackbar.Snackbar;

/**
 * @author anilpraharaj on 23/10/21
 */
public class Tools {

    private static ProgressDialog progressDialog; // Static Progress Dialog Object - To show loading dialog in all over the screens

    /**
     * Show Progress Dialog for any Screen(Static Object called from any Activity or Fragment) and hides loading dialog if already shown
     *
     * @param context
     */
    public static void showProgress(Context context) {
        try {
            hideProgress();
            if (progressDialog == null) {
                progressDialog = ProgressDialog.show(context, context.getString(Constant.PLEASE_WAIT), null, true, false);
                progressDialog.setContentView(R.layout.custom_dialog);
                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                progressDialog.setCancelable(false);
            }
        } catch (Exception e) {
            // TODO : Add Error Handler
        }
    }

    /**
     * Hid Progress Dialog for any Screen(Static Object called from any Activity or Fragment)
     */
    public static void hideProgress() {
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        } catch (Exception e) {
            // TODO : Add Error Handler
        }
    }

    /**
     * Show Success or Error Snack bar message(Static Object called from any Activity or Fragment)
     *
     * @param activity
     * @param message
     * @param isError
     */
    public static void showSnack(Activity activity, String message, boolean isError) {
        try {
            Snackbar snackbar = Snackbar.make(activity.findViewById(Constant.CONTENT_ID), message, Snackbar.LENGTH_LONG);
            if (isError) {
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, Constant.ON_ERROR));
            } else {
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, Constant.ON_SUCCESS));
            }
            snackbar.show();
        }catch (Exception e){
            Toast.makeText(AayamyaApplication.getInstance(),message, Toast.LENGTH_SHORT).show();
        }
    }
}
