package com.bhushan.pack01;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcPro01 {
     String driver = "oracle.jdbc.OracleDriver";
     String url = "jdbc:oracle:thin:@localhost:1521:orcl";
     String username = "Bhushan_test";
     String password = "789";
     
     
     public void connect() {
    	 try {
    		 Class.forName(driver);
    		 IO.println("Data Base ready to connected");
    		 Connection conn = DriverManager.getConnection(url, username, password);
    		 IO.println("Data base is connected");
    		 conn.close();
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
     
     public static void main(String[] args) {
		new JdbcPro01().connect();
	}
}
