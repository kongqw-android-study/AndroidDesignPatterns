package com.kongqw.androiddesignpatterns.singleton;

/**
 * Created by kongqingwei on 2017/3/22.
 * 枚举单例
 */

public enum EnumSingleton {

    INSTANCE;

    private static final String TAG = "EnumSingleton";

    @Override
    public String toString() {
        return "I am " + TAG + "!";
    }
}
