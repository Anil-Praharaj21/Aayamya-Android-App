/*******************************************************************************
 * © 2021 Copyright Aayamya Tech.
 *
 ******************************************************************************/
package com.aayamyatech.aayamya.fragment;

import android.view.View;

import com.aayamyatech.aayamya.baseClass.BaseFragment;
import com.aayamyatech.aayamya.constant.Constant;

/**
 * @author anilpraharaj on 24/10/21
 */
public class DynamicFragment extends BaseFragment {

    @Override
    protected void init(View view) {

    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void onRefresh() {

    }

    @Override
    protected void onResumeCall() {

    }

    @Override
    protected int getContentView() {
        return Constant.DYNAMIC_FRAGMENT_LAYOUT_ID;
    }

    @Override
    protected boolean onBackPressed() {
        return true;
    }
}
