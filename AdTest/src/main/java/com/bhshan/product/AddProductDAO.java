package com.bhshan.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO {
        
	public int add(ProductBean pb) {
		
		int rowCount = 0;
		
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement pstmt = conn.prepareStatement("Insert into Products values (?,?,?,?)");
			pstmt.setString(1, pb.getId());
			pstmt.setString(2, pb.getName());
			pstmt.setString(3, pb.getPrice());
			pstmt.setString(4, pb.getQuantity());
			 
		 rowCount = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
