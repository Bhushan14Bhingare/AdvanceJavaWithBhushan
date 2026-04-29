package com.bhushan.pack01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPro02 {
	
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String userName = "Bhushan_test";
	String pwd = "789";
	
	String query1 = "Select * from employee";
	String query2 = "Insert into employee values('201','Bhushan','Bhingare',120000,'pune')";
	String query3 = "Delete from employee where eid = '201'";
	String query4 = "Update employee set esal = 55000 where eid = '101'";
	
	public void getData() {
		System.out.println("Get a employee Data");
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(dbUrl, userName, pwd);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query1);
			 while(rs.next()) {
   			  IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
   		  }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void insertData() {
		IO.println("Insert data in a database");
	    
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(dbUrl,userName,pwd);
			Statement stat = con.createStatement();
			int insert = stat.executeUpdate(query2);
			
			if(insert == 0) {
				IO.println("Row is not insert");
			}
			else {
				IO.println("Row is inserted");
				getData();
			}
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	
	public void deleteData() {
		IO.println("Delete the row in a data base");
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(dbUrl,userName,pwd);
			Statement stat = con.createStatement();
			int delete = stat.executeUpdate(query3);
			
			if(delete == 0) {
				IO.println("Data is not deleted in a database");
			}
			else {
				IO.println("Data is deleted succesfully");
				getData();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
      
	public void updateData() {
		IO.println("update the data base");
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(dbUrl,userName,pwd);
			Statement stat = con.createStatement();
			int update = stat.executeUpdate(query4);
			
			if(update == 0) {
				IO.println("Data is not update in a database");
			}
			else {
				IO.println("Data is update succesfully");
				getData();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JdbcPro02 obj = new JdbcPro02();
//		obj.getData();
//		obj.insertData();
//		obj.deleteData();
		obj.updateData();

	}

}
