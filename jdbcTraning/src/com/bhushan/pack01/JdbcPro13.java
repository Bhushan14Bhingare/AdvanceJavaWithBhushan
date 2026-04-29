package com.bhushan.pack01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class JdbcPro13 {

	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "Bhushan_test";
	String pwd = "789";
	String query1 = "Insert into mydata values(?,?)";	
	String query2 = "Select pic_data from mydata where id = ?";
	
	public Connection connect() {
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
	
	public void method1() {
		 try { 
		Connection con = connect();
		PreparedStatement pstmt = con.prepareStatement(query1);
		pstmt.setString(1, "101");
		FileInputStream fis = new FileInputStream("C:\\new\\Bhushan Pic.jpg");
		pstmt.setBlob(2, fis, fis.available());
		int rowCount = pstmt.executeUpdate();
		if(rowCount == 0)
			throw new RuntimeException("Image is not inserted");
		IO.println("Image is inserted");
		
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	
	
	public void method2() {
		try {
			Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(query2);
			pstmt.setString(1, "101");
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
			Blob b = rs.getBlob(1);
			byte arr[] = b.getBytes(1, (int)b.length());
			FileOutputStream fos = new FileOutputStream("C:\\new\\Bhushan Pic2.jpg");
			fos.write(arr);
			IO.println("Image is a downloaded");
			fos.close();			
			}	
			else {
				IO.println("Image is not found");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new JdbcPro13().method2();
	}
	
	
}
