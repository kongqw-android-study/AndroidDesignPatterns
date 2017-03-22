package com.kongqw.androiddesignpatterns.builder;

/**
 * Created by kongqingwei on 2017/3/22.
 */
public abstract class Car {
    // 品牌
    protected String mBrand;
    // 型号
    protected String mModel;
    // 颜色
    protected String mColor;

    public abstract void setBrand();

    public void setColor(String mColor) {
        this.mColor = mColor;
    }

    public void setModel(String model) {
        this.mModel = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mBrand='" + mBrand + '\'' +
                ", mModel='" + mModel + '\'' +
                ", mColor='" + mColor + '\'' +
                '}';
    }
}
