package com.example.phoenixhomes;

public class ClinicalNotesModel {

    String date,clinicalNotes;

    public ClinicalNotesModel() {
    }

    public ClinicalNotesModel(String date, String clinicalNotes) {
        this.date = date;
        this.clinicalNotes = clinicalNotes;
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
}
