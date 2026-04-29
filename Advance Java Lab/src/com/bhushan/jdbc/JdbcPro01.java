package com.bhushan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;


public class JdbcPro01 {
      
	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String username = "Bhushan_practice";
	String password = "123";
	
	public Connection connect() {
		Connection conn = null;
		
		try {
			Class.forName(driver);
			 conn = DriverManager.getConnection(dburl,username,password);
			
		}
		catch(Exception sq) {
			sq.printStackTrace();
		}
		
		return conn;
	}
	
	public void InsertData() {
		Connection conn = connect();
		try {
			PreparedStatement pstmt = conn.prepareStatement("Insert into product values(?,?,?,?)");
			String id = IO.readln("Enter a product id : ");
			String name = IO.readln("Enter a product name : ");
			float price = Float.parseFloat(IO.readln("Enter a price of product : "));
			int quantity = Integer.parseInt(IO.readln("Enter a quantity of product : "));
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setFloat(3, price);
			pstmt.setFloat(4, quantity);
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount <= 0) {
				IO.println("Row not insereted in a database");
			}
			else {
				IO.println("Row inserted in a database succesfully");
			}
		}
		catch(SQLIntegrityConstraintViolationException e) {
			IO.println("Already add this product and do not empty product name.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void retriveData(){
		
		Connection conn = connect();
		
		try {
			
		PreparedStatement pstmt = conn.prepareStatement("Select * from product");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			IO.println(rs.getObject(1)+"    "+rs.getObject(2)+"    "+rs.getObject(3)+"   "+rs.getObject(4));
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
	 
		JdbcPro01 obj = new JdbcPro01();
		   obj.InsertData();
	       obj.retriveData();
     
	}

}
