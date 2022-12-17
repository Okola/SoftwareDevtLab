package com.example.phoenixhomes.models;

public class PreventiveServiceModel {

    String medicine,date, nextVisit;

    public PreventiveServiceModel() {
    }

    public PreventiveServiceModel(String medicine, String date, String nextVisit) {
        this.medicine = medicine;
        this.date = date;
        this.nextVisit = nextVisit;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNextVisit() {
        return nextVisit;
    }

    public void setNextVisit(String nextVisit) {
        this.nextVisit = nextVisit;
    }
}
