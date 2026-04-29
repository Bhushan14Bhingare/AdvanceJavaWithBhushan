package com.bhushan.onlineElectronic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDAO {
     
	public AdminBean checkValid(String user,String pass) {
		AdminBean ab = null;
		
		try {
			Connection conn = DBConnect.getConnect();
		PreparedStatement pstmt = conn.prepareStatement("Select * from admin where uname = ? and password = ? ");
		pstmt.setString(1, user);
		pstmt.setString(2, pass);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			ab = new AdminBean();
			ab.setUsername(rs.getString(1));
			ab.setPassword(rs.getString(2));
			ab.setFname(rs.getString(3));
			ab.setLname(rs.getString(4));
			ab.setAddress(rs.getString(5));
			ab.setMail(rs.getString(6));
			ab.setPhone(rs.getString(7));
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
}
