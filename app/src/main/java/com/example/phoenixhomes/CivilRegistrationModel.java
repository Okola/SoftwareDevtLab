package com.example.phoenixhomes;

public class CivilRegistrationModel {

    String birthCertNo, dateOfReg, placeOfReg, fatherName, fatherTelNo, motherName,motherTelNo, guardianName,
    guardianTelNo, county, district, division, location, town, estate, postalAddress;

    public CivilRegistrationModel() {
    }

    public CivilRegistrationModel(String birthCertNo, String dateOfReg, String placeOfReg, String fatherName, String fatherTelNo, String motherName, String motherTelNo, String guardianName, String guardianTelNo, String county, String district, String division, String location, String town, String estate, String postalAddress) {
        this.birthCertNo = birthCertNo;
        this.dateOfReg = dateOfReg;
        this.placeOfReg = placeOfReg;
        this.fatherName = fatherName;
        this.fatherTelNo = fatherTelNo;
        this.motherName = motherName;
        this.motherTelNo = motherTelNo;
        this.guardianName = guardianName;
        this.guardianTelNo = guardianTelNo;
        this.county = county;
        this.district = district;
        this.division = division;
        this.location = location;
        this.town = town;
        this.estate = estate;
        this.postalAddress = postalAddress;
    }

    public String getBirthCertNo() {
        return birthCertNo;
    }

    public void setBirthCertNo(String birthCertNo) {
        this.birthCertNo = birthCertNo;
    }

    public String getDateOfReg() {
        return dateOfReg;
    }

    public void setDateOfReg(String dateOfReg) {
        this.dateOfReg = dateOfReg;
    }

    public String getPlaceOfReg() {
        return placeOfReg;
    }

    public void setPlaceOfReg(String placeOfReg) {
        this.placeOfReg = placeOfReg;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherTelNo() {
        return fatherTelNo;
    }

    public void setFatherTelNo(String fatherTelNo) {
        this.fatherTelNo = fatherTelNo;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherTelNo() {
        return motherTelNo;
    }

    public void setMotherTelNo(String motherTelNo) {
        this.motherTelNo = motherTelNo;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianTelNo() {
        return guardianTelNo;
    }

    public void setGuardianTelNo(String guardianTelNo) {
        this.guardianTelNo = guardianTelNo;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }
}
