package com.example.phoenixhomes;

public class WeightGainModel {

    float yValue;
    long xValue;

    public WeightGainModel() {
    }

    public WeightGainModel(float yValue, long xValue) {
        this.yValue = yValue;
        this.xValue = xValue;
    }

    public float getyValue() {
        return yValue;
    }

    public void setyValue(float yValue) {
        this.yValue = yValue;
    }

    public long getxValue() {
        return xValue;
    }

    public void setxValue(long xValue) {
        this.xValue = xValue;
    }
}
