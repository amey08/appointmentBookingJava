package com.codeWithAmey;
import java.util.List;
import java.util.ListIterator;

public interface PatientDao {
    public List<Patient> getAllPatients() throws Exception;
    public Patient getPatient(int ssnNumber);
    public Patient getPatientName(String patientName);
    public void updatePatient(Patient patient);
    public void deletePatient(int index);
    public void addPatient();
}
