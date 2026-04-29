package com.bhushan.executedQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPro01 {
	
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "Bhushan_Table";
	String pwd = "1234";
	
	public Connection connection() {
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

	public void display() {
		String query = "Select * from emp";
		try {
		  Connection conn = connection();
		  Statement stat = conn.createStatement();
		  ResultSet rs =  stat.executeQuery(query);

         while(rs.next()) {
        	 IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
         }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		JdbcPro01 jd = new JdbcPro01();
		jd.display();
	}

}
