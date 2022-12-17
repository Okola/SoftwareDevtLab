package com.example.phoenixhomes.models;

public class ParticularsOfChildModel {

    String name, sex, dateOfBirth, gestation, birthWeight, birthlenght, otherCharacteristics, order, dateFirstSeen;

    public ParticularsOfChildModel() {
    }

    public ParticularsOfChildModel(String name, String sex, String dateOfBirth, String gestation, String birthWeight, String birthlenght, String otherCharacteristics, String order, String dateFirstSeen) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.gestation = gestation;
        this.birthWeight = birthWeight;
        this.birthlenght = birthlenght;
        this.otherCharacteristics = otherCharacteristics;
        this.order = order;
        this.dateFirstSeen = dateFirstSeen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGestation() {
        return gestation;
    }

    public void setGestation(String gestation) {
        this.gestation = gestation;
    }

    public String getBirthWeight() {
        return birthWeight;
    }

    public void setBirthWeight(String birthWeight) {
        this.birthWeight = birthWeight;
    }

    public String getBirthlenght() {
        return birthlenght;
    }

    public void setBirthlenght(String birthlenght) {
        this.birthlenght = birthlenght;
    }

    public String getOtherCharacteristics() {
        return otherCharacteristics;
    }

    public void setOtherCharacteristics(String otherCharacteristics) {
        this.otherCharacteristics = otherCharacteristics;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDateFirstSeen() {
        return dateFirstSeen;
    }

    public void setDateFirstSeen(String dateFirstSeen) {
        this.dateFirstSeen = dateFirstSeen;
    }
}
