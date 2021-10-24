/*******************************************************************************
 * © 2021 Copyright Aayamya Tech.
 *
 ******************************************************************************/
package com.aayamyatech.aayamya.runnable;

import com.aayamyatech.aayamya.callback.RunnableCb;

/**
 * @author anilpraharaj on 24/10/21
 */
public class RunnableObjects {

    private RunnableCb runnableCallback;

    public RunnableObjects(RunnableCb runnableCallback) {
        this.runnableCallback = runnableCallback;
    }

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            runnableCallback.onRunComplete();
        }
    };
}
