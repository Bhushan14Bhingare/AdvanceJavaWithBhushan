package com.bhushan.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddEmpDao {
 
	public int insertempData(EmpBean ab) {
		int rowCount = 0;
		
		try {
			Connection conn  = DBConnect.getCon();
			PreparedStatement pstmt = conn.prepareStatement("Insert into employee values(?,?,?,?,?)");
			pstmt.setString(1,ab.getEmp_id());
			pstmt.setString(2,ab.getEmp_first());
			pstmt.setString(3,ab.getEmp_last());
			pstmt.setInt(4,ab.getEmp_sal());
			pstmt.setString(5,ab.getEmp_add());
			
			rowCount = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		
		return rowCount;
	}
}
