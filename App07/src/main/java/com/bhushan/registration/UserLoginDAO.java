package com.bhushan.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDAO {
	
	public UserBean login(String username,String password) {
		UserBean user = null;
		
		try {
			Connection conn = DBConnect.getCon();
		PreparedStatement pstmt =	conn.prepareStatement("Select * from registration where username = ? and password = ?");
		
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			user = new UserBean();
			user.setU_name(rs.getString(1));
			user.setU_pwd(rs.getString(2));
			user.setU_fname(rs.getString(3));
			user.setU_lname(rs.getString(4));
			user.setU_mail(rs.getString(5));
			user.setU_phone(rs.getString(6));
		}
		
		}
		catch(Exception e){
			System.out.println("Exception Occered in  UserDAO");
			e.printStackTrace();
		}
		
		return user;
	}

}
