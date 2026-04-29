package com.bhushan.resturant_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Orders {
	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "Bhushan_test";
	String pwd = "789";
	String query1 = "Select price from food where food_id = ?";
	String query2 = "Insert into orders values(?,?,?,?)";
	String query3 = "Select * from orders";
	static int billNumber = 1;
	
	
	public Connection connect() {
		Connection con = null;
		try{
			
		Class.forName(driver);
		 con = DriverManager.getConnection(dburl,user,pwd);
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;		
	}
	
	public void retriveData() {
		IO.println("Display items in restraunt : ");
		String query = "Select * from food";
		
		try {
			Connection conn = connect();
			PreparedStatement pstmt =  conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				IO.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void orderDetails() {
		int id = Integer.parseInt(IO.readln("Enter a food id : "));
		int quantity = Integer.parseInt(IO.readln("Enter a number of quantity : "));
		 try {
			 Connection conn = connect();
			 PreparedStatement stat =  conn.prepareStatement(query1);
			 stat.setInt(1, id);
			 ResultSet rs = stat.executeQuery();
			 
			 if(rs.next()) {
				 double total = rs.getInt(1)*quantity;
				 PreparedStatement stat1 = conn.prepareStatement(query2);
				 stat1.setInt(1, billNumber);
				 stat1.setInt(2,id);
				 stat1.setInt(3,quantity);
				 stat1.setDouble(4,total);
				 billNumber++;
				int rowCount =  stat1.executeUpdate();
				
				if(rowCount == 0) {
					IO.println("Order is cancled");
				}
				else {
					IO.println("Food Order placed successfully");
				}
			 }
			 else {
				 IO.println("Id is not found");
			 }
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	
	public void retriveOrderDetails() {
		IO.println("View order details");
		try {
			Connection conn = connect();
	     PreparedStatement pstmt = conn.prepareStatement(query3);
	   ResultSet rs = pstmt.executeQuery();
	   
	   while(rs.next()) {
		   IO.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3)+" "+rs.getObject(4));
	   }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Orders obj = new Orders();
		while(true) {
		IO.println("1. Display food details");
		IO.println("2. Gives Order");
		IO.println("3. View all order details");
		IO.println("4. Exit");
		
		int choice = Integer.parseInt(IO.readln("Enter your choice : "));
		switch(choice) {
		case 1 ->{
			obj.retriveData();
		}
		case 2 ->{
			obj.orderDetails();
		}
		case 4 ->{
			IO.println("Thank you for visiting.");
			System.exit(0);
		}
		case 3 ->{
			obj.retriveOrderDetails();
		}
		default ->{
			IO.println("Please enter a valid choice!!!");
		}
		}
		}
	}
	
	
	
}
