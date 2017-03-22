package com.kongqw.androiddesignpatterns.singleton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kongqw.androiddesignpatterns.R;

public class SingletonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton);

    }

    /**
     * 饿汉单例模式
     *
     * @param view view
     */
    public void onHungerSingleton(View view) {
        Toast.makeText(getApplicationContext(), HungerSingleton.getInstance().toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * 懒汉单例模式
     *
     * @param view view
     */
    public void onLazySingleton(View view) {
        Toast.makeText(getApplicationContext(), LazySingleton.getInstance().toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * Double Check Lock(DCL)单例模式
     *
     * @param view view
     */
    public void onDCLSingleton(View view) {
        Toast.makeText(getApplicationContext(), DCLSingleton.getInstance().toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * 静态内部类单例模式
     *
     * @param view view
     */
    public void onStaticInnerClassSingleton(View view) {
        Toast.makeText(getApplicationContext(), StaticInnerClassSingleton.getInstance().toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * 枚举单例
     *
     * @param view view
     */
    public void onEnumSingleton(View view) {
        Toast.makeText(getApplicationContext(), EnumSingleton.INSTANCE.toString(), Toast.LENGTH_SHORT).show();
    }
}
