package com.codeWithAmey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientDaoImp implements PatientDao{
    List<Patient> patients;

    public static boolean isValidEmailID(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    
    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m = p.matcher(phoneNumber);
        return (m.find() && m.group().equals(phoneNumber));
    }

    public PatientDaoImp(){
        patients = new ArrayList<Patient>();
//        Patient patient1 = new Patient("Robert",0);
//        Patient patient2 = new Patient("John",1);
//        patients.add(patient1);
//        patients.add(patient2);
    }
    @Override
    public void deletePatient(int index) {
        Patient p1 = patients.get(index);
        patients.remove(p1);
        System.out.println("Patient: SSN No " + p1.getSsnNo() + ", deleted from database");
    }

    @Override
    public void addPatient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first Name : ");
        String patientFirstName = sc.next();
        System.out.println("Enter last Number : ");
        String patientLastName = sc.next();
//        boolean isValidEmail = false;
        String patientEmailId = "";
        while(!PatientDaoImp.isValidEmailID(patientEmailId)) {
            System.out.println("Enter Email ID : ");
            patientEmailId = sc.next();
            if(!PatientDaoImp.isValidEmailID(patientEmailId)) {
                System.out.println("Enter valid email id");
            } else {
                System.out.println("Valid email id");
            }
        }
        String patientPhoneNumber = "";
        while(!PatientDaoImp.isValidPhoneNumber(patientPhoneNumber)) {
            System.out.println("Enter Phone Number : ");
            patientPhoneNumber = sc.next();

            if(!PatientDaoImp.isValidPhoneNumber(patientPhoneNumber)) {
                System.out.println("Enter valid phone number");
            } else {
                System.out.println("Valid phone number");
            }
        }
        System.out.println("Enter SSN ID : ");
        int ssnId = sc.nextInt();

        Patient patient = new Patient(patientFirstName, patientLastName, patientEmailId, patientPhoneNumber, ssnId);
        patients.add(patient);
        System.out.println("Patient Added successfully");
    }

    @Override
    public List<Patient> getAllPatients() throws Exception {
        DBconnect dbConn = new DBconnect();
        dbConn.getAllPatientsData();
        return patients;
    }

    @Override
    public Patient getPatient(int ssnNumber) {
        return patients.get(ssnNumber);
    }

    @Override
    public Patient getPatientName(String patientName) {
        return patients.get(1);
//        return patients.listIterator().next().getName().equals(patientName);
    }

    @Override
    public void updatePatient(Patient patient) {
        patients.get(patient.getSsnNo()).setName(patient.getName());
        System.out.println("Patient: SSN No " + patient.getSsnNo() + ", updated in the database");
    }
}
