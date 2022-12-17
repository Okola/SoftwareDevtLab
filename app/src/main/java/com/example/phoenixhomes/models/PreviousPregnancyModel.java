package com.example.phoenixhomes.models;

public class PreviousPregnancyModel {

    String order,year,ancAttended,deliveryPlace,maturity,labourDuration,deliveryType,babyWeight,sex,outcome,puerperium;

    public PreviousPregnancyModel() {
    }

    public PreviousPregnancyModel(String order, String year, String ancAttended, String deliveryPlace, String maturity, String labourDuration,
                                  String deliveryType, String babyWeight, String sex, String outcome, String puerperium) {
        this.order = order;
        this.year = year;
        this.ancAttended = ancAttended;
        this.deliveryPlace = deliveryPlace;
        this.maturity = maturity;
        this.labourDuration = labourDuration;
        this.deliveryType = deliveryType;
        this.babyWeight = babyWeight;
        this.sex = sex;
        this.outcome = outcome;
        this.puerperium = puerperium;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAncAttended() {
        return ancAttended;
    }

    public void setAncAttended(String ancAttended) {
        this.ancAttended = ancAttended;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public String getMaturity() {
        return maturity;
    }

    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    public String getLabourDuration() {
        return labourDuration;
    }

    public void setLabourDuration(String labourDuration) {
        this.labourDuration = labourDuration;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getBabyWeight() {
        return babyWeight;
    }

    public void setBabyWeight(String babyWeight) {
        this.babyWeight = babyWeight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getPuerperium() {
        return puerperium;
    }

    public void setPuerperium(String puerperium) {
        this.puerperium = puerperium;
    }
}
