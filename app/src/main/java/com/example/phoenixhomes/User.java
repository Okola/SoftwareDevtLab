package com.example.phoenixhomes;

public class User {

    public String fullNames, phoneNumber, email, password,userId;

    public User() {
    }

    public User(String fullNames, String phoneNumber, String email, String password, String userId) {
        this.fullNames = fullNames;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.userId = userId;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

