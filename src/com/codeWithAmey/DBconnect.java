package com.codeWithAmey;

import java.sql.*;

public class DBconnect {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    String url = "jdbc:mysql://127.0.0.1:3306/appointmentdb";
    String user = "root";
    String password = "root";

    DBconnect(){
        try {
            connectMe();
            resultSet = statement.executeQuery("select * from patientdemographics");
            // System.out.println("step 5");
            writeResultSet(resultSet);

//            insertPatientData();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }
    private void connectMe () {
        try{
            // System.out.println("step 1");
            Class.forName("com.mysql.jdbc.Driver");
            // System.out.println("step 2");
            connect= DriverManager.getConnection(url,user,password);
            //here appointmentBooking is database name, root is username and password
            // System.out.println("step 3");
            statement = connect.createStatement();
            // System.out.println("step 4");
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void getAllPatientsData() throws Exception {
        try {
            connectMe();
            resultSet = statement.executeQuery("select * from patientdemographics");
            // System.out.println("step 5");
            writeResultSet(resultSet);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }

    public void insertPatientData() throws Exception {
        try {
            connectMe();
            //Create statement
            statement = connect.createStatement();

            //Insert first record
            String record1="INSERT INTO patientdemographics (idpatient, firstname, lastname, emailid, mobilenumber, dob, ssn) VALUES (3,'Bruno', 'Fernandez','bruno.f10@mutv.com','1231234560','1-jan-91', 3)";
            statement.executeUpdate(record1);
            resultSet = statement.executeQuery("select * from patientdemographics");
            // System.out.println("step 5");
            writeResultSet(resultSet);
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {

            String ssnId = resultSet.getString("ssn");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String emailId = resultSet.getString("emailid");
            String mobileNumber = resultSet.getString("mobilenumber");
            System.out.print("\n SSN id: " + ssnId);
            System.out.print("\t First name: " + firstName);
            System.out.print("\t Last name: " + lastName);
            System.out.print("\t Email: " + emailId);
            System.out.print("\t Mobile number: " + mobileNumber);
        }
    }

    private void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {  }
    }
}
