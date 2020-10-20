package com.codeWithAmey;

//import java.util.ListIterator;
import java.util.Scanner;
import java.util.List;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        DBconnect dbConn = new DBconnect();
        System.out.println(dbConn);
        boolean isValid = true;
        PatientDao patientDao = new PatientDaoImp();
//        for (Patient patient : patientDao.getAllPatients()) {
//            System.out.println("Patient: [SSN : " + patient.getSsnNo() + ", Name : " + patient.getName() + " ]");
//        }
        while (isValid) {

            System.out.println("Select Options from the below list: \t 1. Patient \t 2. Appointments \t 3. Reports \t 4.Exit");
            Scanner sc = new Scanner(System.in);
            int optionSelected = sc.nextInt();

            switch(optionSelected) {
                case 1:
                    System.out.println("You have selected option : " + optionSelected + " Patient");
                    System.out.println("Select Options from the Patient list: \t 1. Add \t 2. Update \t 3. Delete \t 4. Search \t 5. View \t 6. Exit");
                    int patientOptSelected = sc.nextInt();
                    Main.getPatientOptions(patientOptSelected, sc, patientDao);
                    break;
                case 2:
                    System.out.println("You have selected option : " + optionSelected + " Appointments");
                    break;
                case 3:
                    System.out.println("You have selected option : " + optionSelected + " Reports");
                    break;
                case 4:
                    System.out.println("You have selected option : " + optionSelected + " Exit");
                    isValid = false;
                    break;
                default:
                    System.out.println("invalid");
            }
        }
    }

    private static void getPatientOptions(int patientOptSelected, Scanner sc, PatientDao patientDao) throws Exception {
        /* Add, Update, Delete, Search, exit */
        switch(patientOptSelected) {
            case 1:
                System.out.println("You have selected option : " + patientOptSelected + " Add");

                patientDao.addPatient();
                break;
            case 2:
                //update patient
                System.out.println("Enter Name : ");
                String ptName = sc.next();
//                for (Patient patient : patientDao.getAllPatients()) {
//                    if(ptName.equals(patient.getName())) {
//                        System.out.println("Enter Updated Name : ");
//                        String patientUpdatedName = sc.next();
//                        System.out.println("Enter Updated SSN Number : ");
//                        int patientUpdatedNumber = sc.nextInt();
//                        patient.setName(patientUpdatedName);
//                        patient.setSsnNo(patientUpdatedNumber);
//                        break;
//                    }
//               }
                break;
            case 3:
                System.out.println("You have selected option : " + patientOptSelected + " Delete");
                System.out.println("Enter Name : ");
                String delPatientName = sc.next();
////                Patient delPatient = patientDao.getPatient(delPatientName);
////                Patient delPatient = patientDao.getPatientName(delPatientName);
//                int i = 0;
//                boolean flag = false;
//                for (Patient patient : patientDao.getAllPatients()) {
//                    i++;
//                    if (delPatientName.equals(patient.getName())) {
//                        System.out.println("Following Patient: [SSN : " + patient.getSsnNo() + ", Name : " + patient.getName() + " ] will be deleted");
//                        flag = true;
////                        delPatient = patientDao.getPatient(patient.getSsnNo());
//                        break;
//                    }
//                }
//                if(flag) {
//                    patientDao.deletePatient(i);
////                    patientDao.remove(i);
//                }

                break;
            case 4:
                System.out.println("You have selected option : " + patientOptSelected + " Search");
                System.out.println("Enter SSN Number : ");
                int searchPatientNumber = sc.nextInt();
                Patient patient = patientDao.getPatient(searchPatientNumber);
                System.out.println("Patient: [SSN : " + patient.getSsnNo() + ", Name : " + patient.getName() + " ]");
                break;
            case 5:
                System.out.println("You have selected option : " + patientOptSelected + " View Patients");
                patientDao.getAllPatients();
                System.out.println(" ======================== ");
                break;
            case 6:
                System.out.println("You have selected option : " + patientOptSelected + " Exit");
                System.exit(0);
                break;
            default:
                System.out.println("invalid");
        }
//        for (Patient patient : patientDao.getAllPatients()) {
//            System.out.println("Patient: [SSN : " + patient.getSsnNo() + ", Name : " + patient.getName() + " ]");
//        }
    }

        // Patient
            /* Add, Update, Delete, Search, exit */
        // Appointments
            /* Book Appointment, Cancel Appointment, exit */
        // Reports
            /* Patient, Appointments, Exit */
        // exit
//    }
}
