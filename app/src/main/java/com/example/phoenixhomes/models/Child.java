package com.example.phoenixhomes.models;

public class Child {
    String nameOfChild,dateOfBirth,gender,id;

    public Child() {
    }

    public Child(String nameOfChild, String dateOfBirth, String gender, String id) {
        this.nameOfChild = nameOfChild;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;

    }

    public String getNameOfChild() {
        return nameOfChild;
    }

    public void setNameOfChild(String nameOfChild) {
        this.nameOfChild = nameOfChild;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
