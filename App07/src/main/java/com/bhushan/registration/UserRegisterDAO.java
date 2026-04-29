package com.bhushan.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRegisterDAO {

	public int insertUserData(UserBean ub) {
		
		int rowCount = 0;
		
		try {
			
			Connection conn = DBConnect.getCon();
			PreparedStatement pstmt =  conn.prepareStatement("Insert into registration values(?,?,?,?,?,?)");
			
			pstmt.setString(1, ub.getU_name());			
			pstmt.setString(2, ub.getU_pwd());
			pstmt.setString(3, ub.getU_fname());
			pstmt.setString(4, ub.getU_lname());
			pstmt.setString(5, ub.getU_mail());
			pstmt.setString(6, ub.getU_phone());
			
			rowCount = pstmt.executeUpdate();
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return rowCount;
		
	}
	
	
}
