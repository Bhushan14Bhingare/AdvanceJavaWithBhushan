package com.bhushan.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcPro02 {
	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String username = "Bhushan_practice";
	String password = "123";
	
	public Connection connect() {
		Connection conn = null;
		
		try {
			Class.forName(driver);
			 conn = DriverManager.getConnection(dburl,username,password);
			
		}
		catch(Exception sq) {
			sq.printStackTrace();
		}
		
		return conn;
	}
	
	public void insertData() {
        IO.println("Implementing Callable Statement");
		
		try {
			
		    Connection conn	= connect();
		    CallableStatement cstmt = conn.prepareCall("{call ReteriveStudentData(?,?,?,?,?,?,?,?,?)}");
		    String id_number = IO.readln("Enter a student id : ");
		    cstmt.setString(1, id_number);
		    String rollNumber = IO.readln("Enter a student roll : ");
		    cstmt.setString(2, rollNumber);
		    String name = IO.readln("Enter a student name : ");
		    cstmt.setString(3, name);
		    String location = IO.readln("Enter a branch name : ");
		    cstmt.setString(4, location);
		    String houseNo = IO.readln("Enter a student house number : ");
		    cstmt.setString(5, houseNo);
		    String city = IO.readln("Enter a student city : ");
		    cstmt.setString(6, city);
		    long pinCode = Long.parseLong(IO.readln("Enter a student pin code : "));
		    cstmt.setLong(7,pinCode);
		    String mail = IO.readln("Enter a student mailId : ");
		    cstmt.setString(8, mail);
		    long phone = Long.parseLong(IO.readln("Enter a student phone number : "));
		    cstmt.setLong(9,phone);
		    boolean isInsert = cstmt.execute();
		    
		    if(!isInsert) {
		    	IO.println("Data is inserted succesfully");
		    }
		    else {
		    	IO.println("Data is not inserted.");
		    }
		    }
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void retriveData() {
		IO.println("Retrive the student details based on id");
		try {
			Connection conn = connect();
			conn.prepareCall("{call getStudentDetails(?)}");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new JdbcPro02().insertData();
	}
}
