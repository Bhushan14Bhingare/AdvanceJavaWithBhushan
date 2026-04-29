package com.bhushan.onlineElectronic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewProductDAO {
   public ArrayList<ProductBean> al = new ArrayList<>();
   
   
   public ArrayList<ProductBean> retriveProducts(){
	   try {
		   Connection conn = DBConnect.getConnect();
		  PreparedStatement pstmt =  conn.prepareStatement("Select * from product");
		  ResultSet rs = pstmt.executeQuery();
		  
		  while(rs.next()) {
			  ProductBean pb = new ProductBean();
			  pb.setPcode(rs.getString(1));
			  pb.setPname(rs.getString(2));
			  pb.setPcomp(rs.getString(3));
			  pb.setPrice(rs.getString(4));
			  pb.setQty(rs.getString(5));
			  al.add(pb);
		  }
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return al;
   }
}
