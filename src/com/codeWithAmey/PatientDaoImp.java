package com.codeWithAmey;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoImp implements PatientDao{
    List<Patient> patients;

    public PatientDaoImp(){
        patients = new ArrayList<Patient>();
        Patient patient1 = new Patient("Robert",0);
        Patient patient2 = new Patient("John",1);
        patients.add(patient1);
        patients.add(patient2);
    }
    @Override
    public void deletePatient(int index) {
        Patient p1 = patients.get(index);
        patients.remove(p1);
        System.out.println("Patient: SSN No " + p1.getSsnNo() + ", deleted from database");
    }

    @Override
    public void addPatient(String patientName, int ssnNumber) {
        Patient patient = new Patient(patientName, ssnNumber);
        patients.add(patient);
        System.out.println("Patient Added successfully");
    }

    @Override
    public List<Patient> getAllPatients() {
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
