package com.aayamyatech.aayamya.activity;

import com.aayamyatech.aayamya.R;
import com.aayamyatech.aayamya.baseClass.BaseActivity;
import com.aayamyatech.aayamya.baseClass.BaseFragment;
import com.aayamyatech.aayamya.constant.Constant;
import com.aayamyatech.aayamya.fragment.SplashFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void init() {
        BaseFragment fragment = new SplashFragment();
        loadFragment(Constant.BASE_CONTAINER_ID, fragment, SplashFragment.class.getSimpleName());
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
        return Constant.MAIN_ACTIVITY_LAYOUT_ID;
    }
}