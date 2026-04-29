package com.bhushan.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewEmpDAO {
	
	ArrayList<EmpBean> al = new ArrayList<>();
	
	public ArrayList<EmpBean> retrive_EMPData(){
		
		try {
			Connection conn = DBConnect.getCon();
			
		PreparedStatement pstmt = 	conn.prepareCall("Select * from employee");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			EmpBean eb = new EmpBean();
	          eb.setEmp_id(rs.getString(1));
	          eb.setEmp_first(rs.getString(2));
	          eb.setEmp_last(rs.getString(3));
	          eb.setEmp_sal(rs.getInt(4));
	          eb.setEmp_add(rs.getString(5));
	          
	          al.add(eb);
		}
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}

}
