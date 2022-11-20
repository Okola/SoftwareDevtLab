package com.example.phoenixhomes;

public class ReproductiveOrgansModel {

    String date, examination, test, results, treatment;

    public ReproductiveOrgansModel() {
    }

    public ReproductiveOrgansModel(String date, String examination, String test, String results, String treatment) {
        this.date = date;
        this.examination = examination;
        this.test = test;
        this.results = results;
        this.treatment = treatment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
