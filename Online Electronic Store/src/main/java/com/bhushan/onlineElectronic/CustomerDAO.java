package com.bhushan.onlineElectronic;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerDAO {
       
	public int insertCustomerData(CustomerBean cb) {
		int rowCount = 0;
		
		try {
			Connection conn = DBConnect.getConnect();
			
			 PreparedStatement pstmt = conn.prepareStatement("Insert into customer values (?,?,?,?,?,?,?)");
			pstmt.setString(1, cb.getUsername());
			pstmt.setString(2, cb.getPassword());
			pstmt.setString(3, cb.getFname());
			pstmt.setString(4, cb.getLname());
			pstmt.setString(5, cb.getAddress());
			pstmt.setString(6, cb.getMail());
			pstmt.setString(7, cb.getPhone());
			
			rowCount = pstmt.executeUpdate();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
