package com.bhushan.elc.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bhushan.blc.employee.Employee;

public class JdbcProEmployee {

	
    String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
    String user = "Bhushan_practice";
    String password = "123";
    List<Employee> list = new ArrayList<>();
	
	
	public Connection connect() {
		Connection conn = null;
		
		try {
           Class.forName(driver);
           conn = DriverManager.getConnection(dburl, user, password); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public void retriveData() {
		Connection conn = connect();
		try {
			PreparedStatement pstmt =  conn.prepareStatement("Select * from Employee");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Employee(rs.getInt(1),rs.getString(2), rs.getInt(3),rs.getDouble(4)));
			}
			
			for(Employee e1 : list) {
				if(e1.getAge() >= 25) {
					IO.println(e1);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
    
	public static void main(String[] args) {
		
		new JdbcProEmployee().retriveData();
		
	}
}
