package com.bhushan.pack01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcPro14 {
 
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "Bhushan_test";
	String pwd = "789";
	String query = "Insert into mydata1 values(?,?)";
	String query1 = "Select file_data from mydata1 where id = ?";
	
	Connection connect() {
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
	
	public void insertFile() {
		Connection conn = connect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,"101");
			pstmt.setClob(2, new FileReader("C:\\new\\World 1.txt"));
			int rowCount =  pstmt.executeUpdate();
			
			if(rowCount > 0 ) {
				IO.println("File inserted successfully");
			}
			else {
				IO.println("File not inserted");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reteriveFile() {
		Connection conn = connect();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query1);
			pstmt.setString(1,"101");
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Clob b = rs.getClob(1);
				Reader data = b.getCharacterStream();
				BufferedReader br = new BufferedReader(data);
				FileWriter fw = new FileWriter("C:\\new\\World 1.txt");
				String line;
				
				while((line=br.readLine())!=null) {
					fw.write(line);
				}
				br.close();
				fw.close();
				IO.println("Clob data is retrived");
			}
			else {
				IO.print("Data is not available");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JdbcPro14 obj =	new JdbcPro14();
//				obj.insertFile();
				obj.reteriveFile();
	}

}
