/*******************************************************************************
 * © 2021 Copyright Aayamya Tech.
 *
 ******************************************************************************/
package com.aayamyatech.aayamya.fragment;

import android.view.View;

import com.aayamyatech.aayamya.activity.MainActivity;
import com.aayamyatech.aayamya.baseClass.BaseFragment;
import com.aayamyatech.aayamya.callback.RunnableCb;
import com.aayamyatech.aayamya.constant.Constant;
import com.aayamyatech.aayamya.runnable.RunnableObjects;

/**
 * @author anilpraharaj on 24/10/21
 */
public class SplashFragment extends BaseFragment implements RunnableCb {

    @Override
    protected void init(View view) {
        RunnableObjects runnableObjects = new RunnableObjects(this);
        ((MainActivity) getActivity()).startRunnable(runnableObjects.runnable, 2000);
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
        return Constant.SPLASH_FRAGMENT_LAYOUT_ID;
    }

    @Override
    protected boolean onBackPressed() {
        ((MainActivity)getActivity()).finish();
        return false;
    }

    @Override
    public void onRunComplete() {
        BaseFragment fragment = new LoginFragment();
        ((MainActivity) getActivity()).loadFragment(Constant.BASE_CONTAINER_ID, fragment, LoginFragment.class.getSimpleName());
    }
}