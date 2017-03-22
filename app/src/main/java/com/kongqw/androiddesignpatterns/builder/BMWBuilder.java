package com.kongqw.androiddesignpatterns.builder;

/**
 * Created by kongqingwei on 2017/3/22.
 */

public class BMWBuilder extends CarBuilder {

    Car car = new BMWCar();

    @Override
    public BMWBuilder buildBrand() {
        car.setBrand();
        return this;
    }

    @Override
    public BMWBuilder buildModel(String model) {
        car.setModel(model);
        return this;
    }

    @Override
    public BMWBuilder buildColor(String color) {
        car.setColor(color);
        return this;
    }

    @Override
    public Car create() {
        return car;
    }
}
