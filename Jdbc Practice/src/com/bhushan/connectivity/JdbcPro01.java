package com.bhushan.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcPro01 {
   
	String diver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "Bhushan_Table";
	String pwd = "1234";
	
	public void connection() {
		IO.println("Data Base Created");
		try {
			Class.forName(diver);
			Connection conn = DriverManager.getConnection(dbUrl, user, pwd);
			IO.println("Connected");
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	     new JdbcPro01().connection();
	}

}
