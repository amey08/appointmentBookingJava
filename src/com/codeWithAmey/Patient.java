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
//    private String lastName;
//    private String emailID;
    private int ssnNo;

    Patient(String firstName, int ssnNo){
        this.firstName = firstName;
        this.ssnNo = ssnNo;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public int getSsnNo() {
        return ssnNo;
    }

    public void setSsnNo(int ssnNo) {
        this.ssnNo = ssnNo;
    }

}
