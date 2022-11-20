package com.example.phoenixhomes;

public class PregnancyOrderModel {

    String order, date,id;

    public PregnancyOrderModel() {
    }

    public PregnancyOrderModel(String order, String date, String id) {
        this.order = order;
        this.date = date;
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
