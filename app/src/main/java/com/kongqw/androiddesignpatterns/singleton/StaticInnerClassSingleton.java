package com.kongqw.androiddesignpatterns.singleton;

import android.util.Log;

/**
 * Created by kongqingwei on 2017/3/22.
 * 静态内部类单例模式
 */

public class StaticInnerClassSingleton {
    private static final String TAG = "StaticInnerClassSinglet";

    private StaticInnerClassSingleton() {
        Log.i(TAG, "StaticInnerClassSingleton: ");
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.staticInnerClassSingleton;
    }

    private static class SingletonHolder {
        private static final StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    @Override
    public String toString() {
        return "I am " + TAG + "!";
    }
}
