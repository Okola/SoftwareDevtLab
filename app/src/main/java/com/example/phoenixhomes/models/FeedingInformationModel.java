package com.example.phoenixhomes.models;

public class FeedingInformationModel {

    String breastfeeding, otherFeedsIntroduced, complementaryFoods, indigestion;

    public FeedingInformationModel() {

    }

    public FeedingInformationModel(String breastfeeding, String otherFeedsIntroduced, String complementaryFoods, String indigestion) {
        this.breastfeeding = breastfeeding;
        this.otherFeedsIntroduced = otherFeedsIntroduced;
        this.complementaryFoods = complementaryFoods;
        this.indigestion = indigestion;
    }

    public String getBreastfeeding() {
        return breastfeeding;
    }

    public void setBreastfeeding(String breastfeeding) {
        this.breastfeeding = breastfeeding;
    }

    public String getOtherFeedsIntroduced() {
        return otherFeedsIntroduced;
    }

    public void setOtherFeedsIntroduced(String otherFeedsIntroduced) {
        this.otherFeedsIntroduced = otherFeedsIntroduced;
    }

    public String getComplementaryFoods() {
        return complementaryFoods;
    }

    public void setComplementaryFoods(String complementaryFoods) {
        this.complementaryFoods = complementaryFoods;
    }

    public String getIndigestion() {
        return indigestion;
    }

    public void setIndigestion(String indigestion) {
        this.indigestion = indigestion;
    }
}
