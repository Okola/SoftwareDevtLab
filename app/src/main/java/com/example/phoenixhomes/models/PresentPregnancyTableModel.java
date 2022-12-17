package com.example.phoenixhomes.models;

public class PresentPregnancyTableModel {

    String visits,date,urine,weight,bp,hb,pallor,maturity,fundalHeight,presentatiion,lie,foetalHeart,foetalMovt,nextVisit;

    public PresentPregnancyTableModel() {
    }

    public PresentPregnancyTableModel(String visits, String date, String urine, String weight, String bp, String hb, String pallor, String maturity, String fundalHeight, String presentatiion, String lie, String foetalHeart, String foetalMovt, String nextVisit) {
        this.visits = visits;
        this.date = date;
        this.urine = urine;
        this.weight = weight;
        this.bp = bp;
        this.hb = hb;
        this.pallor = pallor;
        this.maturity = maturity;
        this.fundalHeight = fundalHeight;
        this.presentatiion = presentatiion;
        this.lie = lie;
        this.foetalHeart = foetalHeart;
        this.foetalMovt = foetalMovt;
        this.nextVisit = nextVisit;
    }

    public String getVisits() {
        return visits;
    }

    public void setVisits(String visits) {
        this.visits = visits;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrine() {
        return urine;
    }

    public void setUrine(String urine) {
        this.urine = urine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getHb() {
        return hb;
    }

    public void setHb(String hb) {
        this.hb = hb;
    }

    public String getPallor() {
        return pallor;
    }

    public void setPallor(String pallor) {
        this.pallor = pallor;
    }

    public String getMaturity() {
        return maturity;
    }

    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    public String getFundalHeight() {
        return fundalHeight;
    }

    public void setFundalHeight(String fundalHeight) {
        this.fundalHeight = fundalHeight;
    }

    public String getPresentatiion() {
        return presentatiion;
    }

    public void setPresentatiion(String presentatiion) {
        this.presentatiion = presentatiion;
    }

    public String getLie() {
        return lie;
    }

    public void setLie(String lie) {
        this.lie = lie;
    }

    public String getFoetalHeart() {
        return foetalHeart;
    }

    public void setFoetalHeart(String foetalHeart) {
        this.foetalHeart = foetalHeart;
    }

    public String getFoetalMovt() {
        return foetalMovt;
    }

    public void setFoetalMovt(String foetalMovt) {
        this.foetalMovt = foetalMovt;
    }

    public String getNextVisit() {
        return nextVisit;
    }

    public void setNextVisit(String nextVisit) {
        this.nextVisit = nextVisit;
    }
}
