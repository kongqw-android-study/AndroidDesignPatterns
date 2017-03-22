package com.kongqw.androiddesignpatterns.singleton;

import android.util.Log;

/**
 * Created by kongqingwei on 2017/3/22.
 * 懒汉单例模式
 */
public class LazySingleton {

    private static final String TAG = "LazySingleton";

    private static LazySingleton mLazySingleton;

    private LazySingleton() {
        Log.i(TAG, "LazySingleton: ");
    }

    /**
     * 获取单例
     * synchronized 确保在多线程下对象唯一行
     *
     * @return 单例
     */
    public static synchronized LazySingleton getInstance() {
        if (null == mLazySingleton) {
            mLazySingleton = new LazySingleton();
        }
        return mLazySingleton;
    }

    @Override
    public String toString() {
        return "I am " + TAG + "!";
    }
}
