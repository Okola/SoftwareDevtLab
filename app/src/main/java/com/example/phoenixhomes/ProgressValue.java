package com.example.phoenixhomes;

public class ProgressValue {
 int yValue;
 long xValue;

    public ProgressValue() {
    }

    public ProgressValue(int yValue, long xValue) {
        this.yValue = yValue;
        this.xValue = xValue;
    }


    public int getyValue() {
        return yValue;
    }

    public void setyValue(int yValue) {
        this.yValue = yValue;
    }

    public long getxValue() {
        return xValue;
    }

    public void setxValue(long xValue) {
        this.xValue = xValue;
    }
}
