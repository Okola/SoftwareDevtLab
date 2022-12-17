package com.example.phoenixhomes.models;

public class FerrousFumerateModel {

    String order,weeks,tablets,date;

    public FerrousFumerateModel() {
    }

    public FerrousFumerateModel(String order, String weeks, String tablets, String date) {
        this.order = order;
        this.weeks = weeks;
        this.tablets = tablets;
        this.date = date;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    public String getTablets() {
        return tablets;
    }

    public void setTablets(String tablets) {
        this.tablets = tablets;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
