package com.bhushan.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcPro04 {
      String driver = "oracle.jdbc.OracleDriver";
      String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
      String username = "bhushan_practice";
      String password = "123";
      String query1 = "Insert into student_info values(?,?,?,?,?)";
    		  
    		  
      Connection connect() {
    	  Connection conn = null;
    	  try {
    		  Class.forName(driver);
    		 conn =  DriverManager.getConnection(dbUrl, username, password);
    		  
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  return conn;
      }
      
      void insertStudentData() {
    	try {
    		Connection conn = connect();
    		PreparedStatement pstmt =  conn.prepareStatement(query1);
    	    pstmt.setInt(1,120);
    		pstmt.setString(2, "Bhushan");
    		pstmt.setString(3, "bhushan@gmail");
    		pstmt.setString(4, "Java");
    		FileInputStream file = new FileInputStream("C:\\new\\Bhushan Pic.jpg");
    		pstmt.setBlob(5, file, file.available());
    		
    		int update = pstmt.executeUpdate();
    		
    		if(update == 0) {
    			throw new RuntimeException("Data is not inserted");
    		}
    		else {
    			IO.println("Data is an inserted");
    		}
    		
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
      }
      
      public static void main(String[] args) {
		JdbcPro04 obj = new JdbcPro04();
		obj.insertStudentData();
	}
}
