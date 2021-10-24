/*******************************************************************************
 * © 2021 Copyright Aayamya Tech.
 *
 ******************************************************************************/
package com.aayamyatech.aayamya.baseClass;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.aayamyatech.aayamya.callback.BackPressedCb;
import com.aayamyatech.aayamya.callback.BaseCallback;
import com.aayamyatech.aayamya.utils.Tools;

import java.util.List;

/**
 * @author anilpraharaj on 23/10/21
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseCallback {

    private BackPressedCb backPressedCallback; // Callback of Back Press For fragments
    private Handler handler; // Handles the runnable thread

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentView());

        handler = new Handler();

        init();
        addListeners();
    }

    /**
     * Initial Method - On start of the Activity this method will be called
     *
     * Initialize all variables if needed here or set id to Views
     */
    protected abstract void init();

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

    @Override
    protected void onResume() {
        super.onResume();

        onResumeCall();
    }

    @Override
    public void showProgress() {
        Tools.showProgress(this);
    }

    @Override
    public void hideProgress() {
        Tools.hideProgress();
    }

    @Override
    public void showError(String errorMessage) {
        Tools.showSnack(this, errorMessage, true);
    }

    @Override
    public void showSuccess(String successMessage) {
        Tools.showSnack(this, successMessage, false);
    }

    @Override
    public void logout() {

    }

    /**
     * Loading Fragments to stack
     *
     * @param containerId
     * @param fragment
     * @param tag
     */
    public void loadFragment(int containerId, BaseFragment fragment, String tag) {
        Fragment contFragment = getSupportFragmentManager().findFragmentById(containerId);
        if (contFragment == null || !(contFragment.getClass() == (fragment.getClass()))) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                    .replace(containerId, fragment);
            if (tag != null) {
                fragmentTransaction.addToBackStack(tag);
            } else {
                getSupportFragmentManager().popBackStack();
            }
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            fragmentTransaction.show(fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        getFragment();
        if (backPressedCallback == null || backPressedCallback.onBackPressedState()) {
            super.onBackPressed();
        }
    }

    /**
     * Set Back Pressed Callback for fragments
     *
     * @param backPressedCallback
     */
    public void setBackPressedCallback(BackPressedCb backPressedCallback) {
        this.backPressedCallback = backPressedCallback;
    }

    /**
     * Get top fragment from the stack and assign the back pressed callback
     */
    private void getFragment() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null && fragments.size() > 0) {
            setBackPressedCallback(((BaseFragment) fragments.get(fragments.size() - 1)));
        }
    }

    /**
     * Start the runnable thread with Timestamp
     *
     * @param runnable
     * @param timeStamp
     */
    public void startRunnable(Runnable runnable, long timeStamp) {
        handler.postDelayed(runnable, timeStamp);
    }

    /**
     * Stop the runnable thread in between timestamp assigned
     *
     * @param runnable
     */
    public void stopRunnable(Runnable runnable) {
        handler.removeCallbacks(runnable);
    }
}
