package com.codeWithAmey;

public class Patient {

    // Patient
    /* Add, Update, Delete, Search, exit */

//    Patient Demographic
//    Patient First Name
//    Patient Last Name
//    Patient Address
//    Patient Email
//    Patient Phone Number
//    Patient City
//    Patient State
//    Gender
//    DOB (dd-mm-yyyy)
//    SSN

//    Patient Medical History
//    Height
//    Weight
//    Blood Pressure
//    Pulse Rate
//    Affected Organ
    private String firstName;
    private String lastName;
    private String emailID;
    private String phoneNumber;
    private int ssnNo;

    Patient(String firstName, String lastName, String emailID, String phoneNumber, int ssnNo){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.phoneNumber = phoneNumber;
        this.ssnNo = ssnNo;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPhoneNo() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSsnNo() {
        return ssnNo;
    }

    public void setSsnNo(int ssnNo) {
        this.ssnNo = ssnNo;
    }
}
