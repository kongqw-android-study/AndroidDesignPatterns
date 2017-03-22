package com.kongqw.androiddesignpatterns.builder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.kongqw.androiddesignpatterns.R;

public class BuilderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);
    }

    /**
     * Builder构建一辆宝马轿车
     *
     * @param view view
     */
    public void onCreateBMWCar(View view) {
        BMWCar bmwCar = (BMWCar) new BMWBuilder()
                .buildBrand()
                .buildModel("3 Li")
                .buildColor("红色")
                .create();
        Toast.makeText(getApplicationContext(), bmwCar.toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * Builder构建一辆奥迪轿车
     *
     * @param view view
     */
    public void onCreateAudiCar(View view) {
        AudiCar audiCar = (AudiCar) new AudiBuilder()
                .buildBrand()
                .buildModel("A4 L")
                .buildColor("白色")
                .create();
        Toast.makeText(getApplicationContext(), audiCar.toString(), Toast.LENGTH_SHORT).show();
    }
}
