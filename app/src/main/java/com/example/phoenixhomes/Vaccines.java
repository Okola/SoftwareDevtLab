package com.example.phoenixhomes;

public class Vaccines {

   String vaccine,dose,date,nextDate;

    public Vaccines() {
    }

    public Vaccines(String vaccine, String dose, String date, String nextDate) {
        this.vaccine = vaccine;
        this.dose = dose;
        this.date = date;
        this.nextDate = nextDate;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNextDate() {
        return nextDate;
    }

    public void setNextDate(String nextDate) {
        this.nextDate = nextDate;
    }
}
