package com.bhushan.registration;

import java.sql.Connection;
import java.sql.DriverManager;



public class DBConnect {

	
	    static Connection conn = null;
	    
	    static {
	    	try {
	    		Class.forName(DBInfo.driver);
	    		conn = DriverManager.getConnection(DBInfo.url, DBInfo.user, DBInfo.pass);
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


