package com.kongqw.androiddesignpatterns.builder;

/**
 * Created by kongqingwei on 2017/3/22.
 */

public abstract class CarBuilder {

    public abstract CarBuilder buildBrand();

    public abstract CarBuilder buildModel(String model);

    public abstract CarBuilder buildColor(String color);

    public abstract Car create();
}
