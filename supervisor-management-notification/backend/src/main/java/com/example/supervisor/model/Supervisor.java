package com.example.supervisor.model;

public class Supervisor {

    private String jurisdiction;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String supervisor;

    // Getters and setters
    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction() {
        this.jurisdiction = jurisdiction;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
}
