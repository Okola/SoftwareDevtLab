package com.example.phoenixhomes.models;

public class ChildPostNatalExaminationModel {

    String visit, generalCondition, temp, breathPM,feedingMethod, breastfeedingPositioning, umblicalCord,
    immunizationStarted, artprophylaxis,cotrimoxazoleInitiated;

    public ChildPostNatalExaminationModel() {
    }

    public ChildPostNatalExaminationModel(String visit, String generalCondition, String temp, String breathPM, String feedingMethod, String breastfeedingPositioning,
                                          String umblicalCord, String immunizationStarted, String artprophylaxis, String cotrimoxazoleInitiated) {
        this.visit = visit;
        this.generalCondition = generalCondition;
        this.temp = temp;
        this.breathPM = breathPM;
        this.feedingMethod = feedingMethod;
        this.breastfeedingPositioning = breastfeedingPositioning;
        this.umblicalCord = umblicalCord;
        this.immunizationStarted = immunizationStarted;
        this.artprophylaxis = artprophylaxis;
        this.cotrimoxazoleInitiated = cotrimoxazoleInitiated;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public String getGeneralCondition() {
        return generalCondition;
    }

    public void setGeneralCondition(String generalCondition) {
        this.generalCondition = generalCondition;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getBreathPM() {
        return breathPM;
    }

    public void setBreathPM(String breathPM) {
        this.breathPM = breathPM;
    }

    public String getFeedingMethod() {
        return feedingMethod;
    }

    public void setFeedingMethod(String feedingMethod) {
        this.feedingMethod = feedingMethod;
    }

    public String getBreastfeedingPositioning() {
        return breastfeedingPositioning;
    }

    public void setBreastfeedingPositioning(String breastfeedingPositioning) {
        this.breastfeedingPositioning = breastfeedingPositioning;
    }

    public String getUmblicalCord() {
        return umblicalCord;
    }

    public void setUmblicalCord(String umblicalCord) {
        this.umblicalCord = umblicalCord;
    }

    public String getImmunizationStarted() {
        return immunizationStarted;
    }

    public void setImmunizationStarted(String immunizationStarted) {
        this.immunizationStarted = immunizationStarted;
    }

    public String getArtprophylaxis() {
        return artprophylaxis;
    }

    public void setArtprophylaxis(String artprophylaxis) {
        this.artprophylaxis = artprophylaxis;
    }

    public String getCotrimoxazoleInitiated() {
        return cotrimoxazoleInitiated;
    }

    public void setCotrimoxazoleInitiated(String cotrimoxazoleInitiated) {
        this.cotrimoxazoleInitiated = cotrimoxazoleInitiated;
    }
}
