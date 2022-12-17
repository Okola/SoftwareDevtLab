package com.example.phoenixhomes.models;

public class User {

    public String fullNames, email, password,userId;

    public User() {
    }

    public User(String fullNames, String email, String password, String userId) {
        this.fullNames = fullNames;
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

