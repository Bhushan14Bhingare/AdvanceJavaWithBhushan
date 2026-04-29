package com.bhushan.pack01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

public class JdbcPro15 {

	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String userName = "Bhushan_test";
	String password = "789";
	
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, userName, password);	
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return conn;
	}
	
	public void method1() {
		IO.println("Implementing Batch Processing");
		
		try {
			Connection conn = connect();
			Statement stmt = conn.createStatement();
		    int noOfQuery = Integer.parseInt(IO.readln("How many queries you want to add the batch : "));
		    for(int i = 1 ; i <= noOfQuery ; i++) {
		    	stmt.addBatch(IO.readln("Enter a "+i+" query"));
		    }
		    IO.println(noOfQuery+" queries add to the batch");
		    int rowCount[] = stmt.executeBatch();
		    IO.println("====>"+Arrays.toString(rowCount));
		    stmt.clearBatch();
			
		}
		catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		new JdbcPro15().method1();
	}
}
