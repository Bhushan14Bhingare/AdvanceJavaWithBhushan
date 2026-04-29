package com.bhushan.employee_info;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToDatabase {
    String driver = "oracle.jdbc.OracleDriver";
    String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
    String user = "Bhushan_practice";
    String pwd = "123";
    
    public Connection connect() {
    	Connection conn = null;
    	
    	try {
    		
    	    Class.forName(driver);
    	   conn = DriverManager.getConnection(dbUrl, user, pwd);
    	}
    	catch(Exception e) {
    	  e.printStackTrace();
    	}
		return conn;
    	
    }    
}
