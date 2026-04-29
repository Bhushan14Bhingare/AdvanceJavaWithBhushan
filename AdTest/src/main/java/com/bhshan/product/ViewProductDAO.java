package com.bhshan.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ViewProductDAO {
	 public ArrayList<ProductBean> al = new ArrayList<>();
	   
	   
	   public ArrayList<ProductBean> retriveProducts(){
		   try {
			   Connection conn = DBConnect.getConnect();
			  PreparedStatement pstmt =  conn.prepareStatement("Select * from products");
			  ResultSet rs = pstmt.executeQuery();
			  
			  while(rs.next()) {
				  ProductBean pb = new ProductBean();
				  pb.setId(rs.getString(1));
				  pb.setName(rs.getString(2));
				  
				  pb.setPrice(rs.getString(3));
				  pb.setQuantity(rs.getString(3));
				  al.add(pb);
			  }
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   return al;
	   }
}
