package com.bhushan.onlineElectronic;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
 
     static Connection conn = null;
      
      static {
    	  try {
    		  Class.forName(DBInfo.driver);
    		  conn = DriverManager.getConnection(DBInfo.url, DBInfo.username, DBInfo.password);
        	  }
    	  catch(Exception e) {
    		  System.out.println("Exception occured in DBConnect Class");
    		  e.printStackTrace();
    	  }
      }
      
      public static Connection getConnect() {
		return conn;
    	  
      }
}
