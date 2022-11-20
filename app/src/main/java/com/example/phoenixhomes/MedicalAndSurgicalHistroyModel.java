package com.example.phoenixhomes;

public class MedicalAndSurgicalHistroyModel {

    String surgicalOperation,diabetes,hypertension,bloodTransfusion,tb,drugAllergy,others,
            twins,tuberculosis;

    public MedicalAndSurgicalHistroyModel() {
    }

    public MedicalAndSurgicalHistroyModel(String surgicalOperation, String diabetes, String hypertension, String bloodTransfusion, String tb, String drugAllergy, String others, String twins, String tuberculosis) {
        this.surgicalOperation = surgicalOperation;
        this.diabetes = diabetes;
        this.hypertension = hypertension;
        this.bloodTransfusion = bloodTransfusion;
        this.tb = tb;
        this.drugAllergy = drugAllergy;
        this.others = others;
        this.twins = twins;
        this.tuberculosis = tuberculosis;
    }

    public String getSurgicalOperation() {
        return surgicalOperation;
    }

    public void setSurgicalOperation(String surgicalOperation) {
        this.surgicalOperation = surgicalOperation;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public String getHypertension() {
        return hypertension;
    }

    public void setHypertension(String hypertension) {
        this.hypertension = hypertension;
    }

    public String getBloodTransfusion() {
        return bloodTransfusion;
    }

    public void setBloodTransfusion(String bloodTransfusion) {
        this.bloodTransfusion = bloodTransfusion;
    }

    public String getTb() {
        return tb;
    }

    public void setTb(String tb) {
        this.tb = tb;
    }

    public String getDrugAllergy() {
        return drugAllergy;
    }

    public void setDrugAllergy(String drugAllergy) {
        this.drugAllergy = drugAllergy;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getTwins() {
        return twins;
    }

    public void setTwins(String twins) {
        this.twins = twins;
    }

    public String getTuberculosis() {
        return tuberculosis;
    }

    public void setTuberculosis(String tuberculosis) {
        this.tuberculosis = tuberculosis;
    }
}
