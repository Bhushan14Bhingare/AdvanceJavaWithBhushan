package com.bhushan.employee;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    static Connection conn = null;
    
    static {
    	try {
    		Class.forName(DBInfo.driver);
    		conn = DriverManager.getConnection(DBInfo.dbUrl, DBInfo.userName, DBInfo.pwd);
    	}
    	catch(Exception e) {
    		
    		System.out.println("Exception occured in DBConnect Class");
    		e.printStackTrace();
    	}
    }
    
    public static Connection getCon() {
    	return conn;
    }
}
