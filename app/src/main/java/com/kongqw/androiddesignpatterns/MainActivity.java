package com.kongqw.androiddesignpatterns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kongqw.androiddesignpatterns.singleton.SingletonActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 单例设计模式
     * @param view view
     */
    public void onSingleInstance(View view) {
        startActivity(new Intent(this, SingletonActivity.class));
    }
}
