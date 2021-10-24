/*******************************************************************************
 * © 2021 Copyright Aayamya Tech.
 *
 ******************************************************************************/
package com.aayamyatech.aayamya.callback;

/**
 * @author anilpraharaj on 23/10/21
 */
public interface BaseCallback {

    void showProgress();

    void hideProgress();

    void showError(String errorMessage);

    void showSuccess(String successMessage);

    void logout();
}
