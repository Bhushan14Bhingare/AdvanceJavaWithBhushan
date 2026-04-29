package com.bhushan.onlineElectronic;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class AddProductDAO {
 
	public int insertProduct(ProductBean pb) {
		int row = 0 ;
		
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement pstmt = conn.prepareStatement("Insert into product values(?,?,?,?,?)");
			
			pstmt.setString(1, pb.getPcode());
			pstmt.setString(2, pb.getPname());
			pstmt.setString(3, pb.getPcomp());
			pstmt.setString(4, pb.getPrice());
			pstmt.setString(5, pb.getQty());
			row = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return row;
	}
}
