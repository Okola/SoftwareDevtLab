package com.example.phoenixhomes.models;

public class HealthRecordModel {

    String healthFacility, birthNotificationNo, date, permanentRegisterNo, childWelfareClinicNo, healthfacilityName, masterFacilityListNo;

    public HealthRecordModel() {
    }

    public HealthRecordModel(String healthFacility, String birthNotificationNo, String date, String permanentRegisterNo, String childWelfareClinicNo, String healthfacilityName, String masterFacilityListNo) {
        this.healthFacility = healthFacility;
        this.birthNotificationNo = birthNotificationNo;
        this.date = date;
        this.permanentRegisterNo = permanentRegisterNo;
        this.childWelfareClinicNo = childWelfareClinicNo;
        this.healthfacilityName = healthfacilityName;
        this.masterFacilityListNo = masterFacilityListNo;
    }

    public String getHealthFacility() {
        return healthFacility;
    }

    public void setHealthFacility(String healthFacility) {
        this.healthFacility = healthFacility;
    }

    public String getBirthNotificationNo() {
        return birthNotificationNo;
    }

    public void setBirthNotificationNo(String birthNotificationNo) {
        this.birthNotificationNo = birthNotificationNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPermanentRegisterNo() {
        return permanentRegisterNo;
    }

    public void setPermanentRegisterNo(String permanentRegisterNo) {
        this.permanentRegisterNo = permanentRegisterNo;
    }

    public String getChildWelfareClinicNo() {
        return childWelfareClinicNo;
    }

    public void setChildWelfareClinicNo(String childWelfareClinicNo) {
        this.childWelfareClinicNo = childWelfareClinicNo;
    }

    public String getHealthfacilityName() {
        return healthfacilityName;
    }

    public void setHealthfacilityName(String healthfacilityName) {
        this.healthfacilityName = healthfacilityName;
    }

    public String getMasterFacilityListNo() {
        return masterFacilityListNo;
    }

    public void setMasterFacilityListNo(String masterFacilityListNo) {
        this.masterFacilityListNo = masterFacilityListNo;
    }
}
