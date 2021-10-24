/*******************************************************************************
 * © 2021 Copyright Aayamya Tech.
 *
 ******************************************************************************/
package com.aayamyatech.aayamya.fragment;

import android.view.View;
import android.widget.Button;

import com.aayamyatech.aayamya.R;
import com.aayamyatech.aayamya.activity.MainActivity;
import com.aayamyatech.aayamya.baseClass.BaseFragment;
import com.aayamyatech.aayamya.constant.Constant;

/**
 * @author anilpraharaj on 23/10/21
 */
public class LoginFragment extends BaseFragment {

    private Button button;

    @Override
    protected void init(View view) {
        button = view.findViewById(R.id.login_button);
    }

    @Override
    protected void addListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseFragment fragment = new DashboardFragment();
                ((MainActivity) getActivity()).loadFragment(Constant.BASE_CONTAINER_ID, fragment, DashboardFragment.class.getSimpleName());
            }
        });
    }

    @Override
    protected void onRefresh() {

    }

    @Override
    protected void onResumeCall() {

    }

    @Override
    protected int getContentView() {
        return Constant.LOGIN_FRAGMENT_LAYOUT_ID;
    }

    @Override
    protected boolean onBackPressed() {
        ((MainActivity)getActivity()).finish();
        return false;
    }
}
