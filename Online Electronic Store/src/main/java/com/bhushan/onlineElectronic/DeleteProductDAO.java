package com.bhushan.onlineElectronic;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDAO {
   
	public int deleteProduct(String pcode) {
		
		int rowCont = 0;
		
		
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement pstmt = conn.prepareStatement("Delete from product where pcode = ?");
			pstmt.setString(1, pcode);
			rowCont = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rowCont;
		
	}
}
