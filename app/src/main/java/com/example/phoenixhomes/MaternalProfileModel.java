package com.example.phoenixhomes;

public class MaternalProfileModel {

    String nameOfInstitution,mflNo,ancNo,pncNo,nameOfClient,age,gravida,parity,height,weight,lmp,
            edd,maritalStatus,address,telephone,education,nextOfKin,relationship,nextofKinContact;

    public MaternalProfileModel() {
    }

    public MaternalProfileModel(String nameOfInstitution, String mflNo, String ancNo, String pncNo, String nameOfClient, String age, String gravida, String parity, String height, String weight, String lmp, String edd, String maritalStatus, String address, String telephone, String education, String nextOfKin, String relationship, String nextofKinContact) {
        this.nameOfInstitution = nameOfInstitution;
        this.mflNo = mflNo;
        this.ancNo = ancNo;
        this.pncNo = pncNo;
        this.nameOfClient = nameOfClient;
        this.age = age;
        this.gravida = gravida;
        this.parity = parity;
        this.height = height;
        this.weight = weight;
        this.lmp = lmp;
        this.edd = edd;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.telephone = telephone;
        this.education = education;
        this.nextOfKin = nextOfKin;
        this.relationship = relationship;
        this.nextofKinContact = nextofKinContact;
    }

    public String getNameOfInstitution() {
        return nameOfInstitution;
    }

    public void setNameOfInstitution(String nameOfInstitution) {
        this.nameOfInstitution = nameOfInstitution;
    }

    public String getMflNo() {
        return mflNo;
    }

    public void setMflNo(String mflNo) {
        this.mflNo = mflNo;
    }

    public String getAncNo() {
        return ancNo;
    }

    public void setAncNo(String ancNo) {
        this.ancNo = ancNo;
    }

    public String getPncNo() {
        return pncNo;
    }

    public void setPncNo(String pncNo) {
        this.pncNo = pncNo;
    }

    public String getNameOfClient() {
        return nameOfClient;
    }

    public void setNameOfClient(String nameOfClient) {
        this.nameOfClient = nameOfClient;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGravida() {
        return gravida;
    }

    public void setGravida(String gravida) {
        this.gravida = gravida;
    }

    public String getParity() {
        return parity;
    }

    public void setParity(String parity) {
        this.parity = parity;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLmp() {
        return lmp;
    }

    public void setLmp(String lmp) {
        this.lmp = lmp;
    }

    public String getEdd() {
        return edd;
    }

    public void setEdd(String edd) {
        this.edd = edd;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(String nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getNextofKinContact() {
        return nextofKinContact;
    }

    public void setNextofKinContact(String nextofKinContact) {
        this.nextofKinContact = nextofKinContact;
    }
}
