package com.bhushan.pack01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPro07 {

	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "Bhushan_test";
	String pwd = "789";
	
	public Connection connect() {
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,user,pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void meth1() {
		String query = "Select * from employee";
		try {
			Connection conn = connect();
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(query);
			
			
				rs.first();
				IO.println(rs.getString(1)+" , "+rs.getString(2)+" , "+rs.getString(3)+" , "+rs.getInt(4)+" , "+rs.getString(5));
				
				while(rs.next()) {
					IO.println(rs.getString(1)+" , "+rs.getString(2)+" , "+rs.getString(3)+" , "+rs.getInt(4)+" , "+rs.getString(5));
				}
		
				rs.last();
				IO.println(rs.getString(1)+" , "+rs.getString(2)+" , "+rs.getString(3)+" , "+rs.getInt(4)+" , "+rs.getString(5));
				
				while(rs.previous())
				IO.println(rs.getString(1)+" , "+rs.getString(2)+" , "+rs.getString(3)+" , "+rs.getInt(4)+" , "+rs.getString(5));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void meth2() {
		Connection conn = connect();
		
		try {
			Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stat.executeQuery("Select eid,efname,esal from employee");
			while (rs.next()){
				String e_id = rs.getString(1);
				
				if(e_id.equals("102")) {
					rs.updateInt(3,15000);
					rs.updateRow();
					}
			}
			IO.println("Data is Updated!!!");
			rs.absolute(3);
			IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JdbcPro07 obj = new JdbcPro07();
	    obj.meth1();
//		obj.meth2();
		}

}
