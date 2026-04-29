package com.bhushan.pack01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPro03 {
     /* Task 01 : Retrieve a employee details 
      * Task 02 : Ask the User to enter EMP data and insert the data in to employee table
      * Task 03 : Ask the User EID the employee record from the data base 
      *           If the record is Not available display that msg in the console including EMPID 
      * Task 04 : Ask the User EID the employee delete from the data base 
      *           If the record is Not available display that msg in the console including EMPID 
      * Task 05 : Ask the User EID and Esal and update the employee record in the table accordingly 
      *           If the record is Not available display that msg in the console including EMPID
      */
	
	
	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "Bhushan_test";
	String pwd = "789";
	
	
	public Connection connection() {
		Connection con = null;
		try {
		Class.forName(driver);
		 con = DriverManager.getConnection(dburl,user,pwd);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;		
	}
	
	
	public void retrieve() {
		IO.println("Retrive data ");
		String query1 = "Select * from employee";
		try {
			Connection con = connection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query1);
			
			while(rs.next()) {
				IO.println(rs.getObject(1)+" , "+rs.getObject(2)+" , "+rs.getObject(3)+" , "+rs.getObject(4)+" , "+rs.getObject(5));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void insertData() {
		IO.println("Insert data  ");
		String id = IO.readln("Enter a employee id : ");
		String firstName = IO.readln("Enter a employee first name: ");
		String lastName = IO.readln("Enter a employee last name: ");
		int sal = Integer.parseInt(IO.readln("Enter a employee sal"));
		String loc = IO.readln("Enter a employee location: ");
		
		String query2 = "Insert into employee values ('"+id+"' , '"+firstName+"' , '"+lastName+"', '"+sal+"' ,'"+loc+"')";
		
		try {
			Connection con = connection();
		Statement stat = con.createStatement();
		int row  = stat.executeUpdate(query2);
		
		if(row == 0) {
			IO.println("Data is not inserted");
		}
		else {
			IO.println("Data is inserted");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteData() {
		IO.println("Delete  a data  ");
		String id = IO.readln("Enter a employee id : ");
		String query3 = "Delete from employee where eid = '"+id+"'";
		try {
			Connection con = connection();
		Statement stat = con.createStatement();
		int row  = stat.executeUpdate(query3);
		
		if(row == 0) {
			IO.println("Data is not deleted");
		}
		else {
			IO.println("Data is delete");
			retrieve();
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findData() {
		IO.println("Retrive data based on id ");
		String id = IO.readln("Enter a employee id : ");
		String query5 = "Select * from employee where eid = '"+id+"'";
		try {
			Connection con = connection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query5);
			
			while(rs.next()) {
				IO.println(rs.getObject(1)+" , "+rs.getObject(2)+" , "+rs.getObject(3)+" , "+rs.getObject(4)+" , "+rs.getObject(5));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateData() {
		IO.println("Update esal based on id ");
		String id = IO.readln("Enter a employee id : ");
		int sal = Integer.parseInt(IO.readln("Enter a employee sal"));
		String query4 = "Update employee set esal = '"+sal+"' where eid = '"+id+"'";
		try {
			Connection con = connection();
		Statement stat = con.createStatement();
		int row  = stat.executeUpdate(query4);
		
		if(row == 0) {
			IO.println("Data is not updated");
		}
		else {
			IO.println("Data is updated");
			retrieve();
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JdbcPro03 obj  = new JdbcPro03();
		obj.retrieve();
		obj.insertData();
		obj.findData();
		obj.deleteData();
		obj.updateData();
	}
}
