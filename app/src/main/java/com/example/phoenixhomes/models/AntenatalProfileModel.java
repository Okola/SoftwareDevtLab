package com.example.phoenixhomes.models;

public class AntenatalProfileModel {

    String hb,bloodGroup,rhesus,serology,tbScreening,ipt,nextVisit,hiv,urinalysis,coupleHivCounseling;

    public AntenatalProfileModel() {
    }

    public AntenatalProfileModel(String hb, String bloodGroup, String rhesus, String serology, String tbScreening, String ipt, String nextVisit, String hiv, String urinalysis, String coupleHivCounseling) {
        this.hb = hb;
        this.bloodGroup = bloodGroup;
        this.rhesus = rhesus;
        this.serology = serology;
        this.tbScreening = tbScreening;
        this.ipt = ipt;
        this.nextVisit = nextVisit;
        this.hiv = hiv;
        this.urinalysis = urinalysis;
        this.coupleHivCounseling = coupleHivCounseling;
    }

    public String getHb() {
        return hb;
    }

    public void setHb(String hb) {
        this.hb = hb;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getRhesus() {
        return rhesus;
    }

    public void setRhesus(String rhesus) {
        this.rhesus = rhesus;
    }

    public String getSerology() {
        return serology;
    }

    public void setSerology(String serology) {
        this.serology = serology;
    }

    public String getTbScreening() {
        return tbScreening;
    }

    public void setTbScreening(String tbScreening) {
        this.tbScreening = tbScreening;
    }

    public String getIpt() {
        return ipt;
    }

    public void setIpt(String ipt) {
        this.ipt = ipt;
    }

    public String getNextVisit() {
        return nextVisit;
    }

    public void setNextVisit(String nextVisit) {
        this.nextVisit = nextVisit;
    }

    public String getHiv() {
        return hiv;
    }

    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    public String getUrinalysis() {
        return urinalysis;
    }

    public void setUrinalysis(String urinalysis) {
        this.urinalysis = urinalysis;
    }

    public String getCoupleHivCounseling() {
        return coupleHivCounseling;
    }

    public void setCoupleHivCounseling(String coupleHivCounseling) {
        this.coupleHivCounseling = coupleHivCounseling;
    }
}
