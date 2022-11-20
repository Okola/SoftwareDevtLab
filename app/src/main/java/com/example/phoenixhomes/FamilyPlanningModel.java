package com.example.phoenixhomes;

public class FamilyPlanningModel {

    String date, clinicalNotes, nextVisit;

    public FamilyPlanningModel() {
    }

    public FamilyPlanningModel(String date, String clinicalNotes, String nextVisit) {
        this.date = date;
        this.clinicalNotes = clinicalNotes;
        this.nextVisit = nextVisit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClinicalNotes() {
        return clinicalNotes;
    }

    public void setClinicalNotes(String clinicalNotes) {
        this.clinicalNotes = clinicalNotes;
    }

    public String getNextVisit() {
        return nextVisit;
    }

    public void setNextVisit(String nextVisit) {
        this.nextVisit = nextVisit;
    }
}
