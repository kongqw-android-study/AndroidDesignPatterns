package com.kongqw.androiddesignpatterns.builder;

/**
 * Created by kongqingwei on 2017/3/22.
 */

public class AudiBuilder extends CarBuilder {

    Car car = new AudiCar();

    @Override
    public AudiBuilder buildBrand() {
        car.setBrand();
        return this;
    }

    @Override
    public AudiBuilder buildModel(String model) {
        car.setModel(model);
        return this;
    }

    @Override
    public AudiBuilder buildColor(String color) {
        car.setColor(color);
        return this;
    }

    @Override
    public Car create() {
        return car;
    }
}
