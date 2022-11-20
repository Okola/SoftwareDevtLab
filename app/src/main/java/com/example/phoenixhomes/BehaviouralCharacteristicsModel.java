package com.example.phoenixhomes;

public class BehaviouralCharacteristicsModel {

    String sleepAndWakeupCycles, irritability, thumborFingerSucking, others;

    public BehaviouralCharacteristicsModel() {
    }

    public BehaviouralCharacteristicsModel(String sleepAndWakeupCycles, String irritability, String thumborFingerSucking, String others) {
        this.sleepAndWakeupCycles = sleepAndWakeupCycles;
        this.irritability = irritability;
        this.thumborFingerSucking = thumborFingerSucking;
        this.others = others;
    }

    public String getSleepAndWakeupCycles() {
        return sleepAndWakeupCycles;
    }

    public void setSleepAndWakeupCycles(String sleepAndWakeupCycles) {
        this.sleepAndWakeupCycles = sleepAndWakeupCycles;
    }

    public String getIrritability() {
        return irritability;
    }

    public void setIrritability(String irritability) {
        this.irritability = irritability;
    }

    public String getThumborFingerSucking() {
        return thumborFingerSucking;
    }

    public void setThumborFingerSucking(String thumborFingerSucking) {
        this.thumborFingerSucking = thumborFingerSucking;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
