package com.example.phoenixhomes.models;

public class InfantFeedingModel {

    String counsellingDone, counsellingOnBreastFeeding;

    public InfantFeedingModel() {
    }

    public InfantFeedingModel(String counsellingDone, String counsellingOnBreastFeeding) {
        this.counsellingDone = counsellingDone;
        this.counsellingOnBreastFeeding = counsellingOnBreastFeeding;
    }

    public String getCounsellingDone() {
        return counsellingDone;
    }

    public void setCounsellingDone(String counsellingDone) {
        this.counsellingDone = counsellingDone;
    }

    public String getCounsellingOnBreastFeeding() {
        return counsellingOnBreastFeeding;
    }

    public void setCounsellingOnBreastFeeding(String counsellingOnBreastFeeding) {
        this.counsellingOnBreastFeeding = counsellingOnBreastFeeding;
    }
}
