package com.codeWithAmey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconnect {
    DBconnect(){
        try{
            System.out.println("step 1");
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("step 2");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/appointmentBooking","root","test");
            //here appointmentBooking is database name, root is username and password
            System.out.println("step 3");
            Statement stmt = con.createStatement();
            System.out.println("step 4");
            ResultSet rs = stmt.executeQuery("select * from patientdemographics");
            System.out.println("step 5");
            while(rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
