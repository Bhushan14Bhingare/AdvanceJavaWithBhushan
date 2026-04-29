package com.bhushan.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcPro03 {
	
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String username = "Bhushan_practice";
	String password = "123";
	String query1 = "Insert into customer_info values(?,?,?,?,?)";
		
	Connection connect() {
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,username,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void insertData() {
		int id = Integer.parseInt(IO.readln("Enter a customer id : "));
		String name = IO.readln("Enter a customer name : ");
		String mail = IO.readln("Enter a customer mail id : ");
		String phone = IO.readln("Enter a customer phone number : ");
		
		try {
			Connection conn = connect();
		PreparedStatement pstmt = conn.prepareStatement(query1);
		pstmt.setInt(1, id);
		pstmt.setString(2,name);
		pstmt.setString(3,mail);
		pstmt.setString(4, phone);
		FileInputStream fin = new FileInputStream("C:\\new\\Aadhar Card.jpg");
		pstmt.setBlob(5,fin,fin.available());
		
		int update =  pstmt.executeUpdate();
		
		if(update == 0) {
			IO.println("Data is not inserted please try again");
		}
		else {
			IO.println("Data is inserted succesfully");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		JdbcPro03 obj = new JdbcPro03();
		obj.insertData();
	}

}
