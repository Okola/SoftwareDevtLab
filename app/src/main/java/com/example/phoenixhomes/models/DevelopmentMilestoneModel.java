package com.example.phoenixhomes.models;

public class DevelopmentMilestoneModel {

    String milestone, ageArchieved, withinTime, delayed;

    public DevelopmentMilestoneModel() {
    }

    public DevelopmentMilestoneModel(String milestone, String ageArchieved, String withinTime, String delayed) {
        this.milestone = milestone;
        this.ageArchieved = ageArchieved;
        this.withinTime = withinTime;
        this.delayed = delayed;
    }

    public String getMilestone() {
        return milestone;
    }

    public void setMilestone(String milestone) {
        this.milestone = milestone;
    }

    public String getAgeArchieved() {
        return ageArchieved;
    }

    public void setAgeArchieved(String ageArchieved) {
        this.ageArchieved = ageArchieved;
    }

    public String getWithinTime() {
        return withinTime;
    }

    public void setWithinTime(String withinTime) {
        this.withinTime = withinTime;
    }

    public String getDelayed() {
        return delayed;
    }

    public void setDelayed(String delayed) {
        this.delayed = delayed;
    }
}
