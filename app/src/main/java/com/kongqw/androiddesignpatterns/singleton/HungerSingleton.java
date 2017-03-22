package com.kongqw.androiddesignpatterns.singleton;

import android.util.Log;

/**
 * Created by kongqingwei on 2017/3/22.
 * 饿汉单例模式
 */
public class HungerSingleton {

    private static final String TAG = "HungerSingleton";

    private static final HungerSingleton mHungerSingleton = new HungerSingleton();

    private HungerSingleton() {
        Log.i(TAG, "HungerSingleton: ");
    }

    public static HungerSingleton getInstance() {
        return mHungerSingleton;
    }

    @Override
    public String toString() {
        return "I am " + TAG + "!";
    }
}
