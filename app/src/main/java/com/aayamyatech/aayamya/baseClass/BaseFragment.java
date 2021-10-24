/*******************************************************************************
 * © 2021 Copyright Aayamya Tech.
 *
 ******************************************************************************/
package com.aayamyatech.aayamya.baseClass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aayamyatech.aayamya.callback.BackPressedCb;

/**
 * @author anilpraharaj on 23/10/21
 */
public abstract class BaseFragment extends Fragment implements BackPressedCb {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getContentView(), null);
    }

    /**
     * Initial Method - On start of the Fragment, this method will be called
     *
     * Initialize all variables if needed here or set id to Views
     */
    protected abstract void init(View view);

    /**
     * Add all callback listeners here if needed
     */
    protected abstract void addListeners();

    /**
     * Set all method inside when required to refresh the screen data
     */
    protected abstract void onRefresh();

    /**
     * This method is called during on Resume of the activity lifecycle is called
     */
    protected abstract void onResumeCall();

    /**
     * Add XML layout
     *
     * @return int
     */
    protected abstract int getContentView();

    /**
     * Called on system back button is pressed
     *
     * @return boolean (State says if the backtrack should be performed or not)
     */
    protected abstract boolean onBackPressed();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
        addListeners();
    }

    @Override
    public void onResume() {
        super.onResume();

        onResumeCall();
    }


    @Override
    public boolean onBackPressedState() {
        return onBackPressed();
    }
}
