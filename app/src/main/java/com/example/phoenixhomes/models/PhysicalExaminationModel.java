package com.example.phoenixhomes.models;

public class PhysicalExaminationModel {

    String general,bp,height,cvs,resp,breasts,abdomen,virginalExamination,discharge;

    public PhysicalExaminationModel() {
    }

    public PhysicalExaminationModel(String general, String bp, String height, String cvs, String resp, String breasts, String abdomen, String virginalExamination, String discharge) {
        this.general = general;
        this.bp = bp;
        this.height = height;
        this.cvs = cvs;
        this.resp = resp;
        this.breasts = breasts;
        this.abdomen = abdomen;
        this.virginalExamination = virginalExamination;
        this.discharge = discharge;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getCvs() {
        return cvs;
    }

    public void setCvs(String cvs) {
        this.cvs = cvs;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getBreasts() {
        return breasts;
    }

    public void setBreasts(String breasts) {
        this.breasts = breasts;
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public String getVirginalExamination() {
        return virginalExamination;
    }

    public void setVirginalExamination(String virginalExamination) {
        this.virginalExamination = virginalExamination;
    }

    public String getDischarge() {
        return discharge;
    }

    public void setDischarge(String discharge) {
        this.discharge = discharge;
    }
}
