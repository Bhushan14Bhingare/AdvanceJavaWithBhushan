package com.bhushan.onlineElectronic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuyProductDAO {
      public ProductBean isAvailable(String pcode) {
		  ProductBean pb = null;
		  
		  try {
			  Connection conn = DBConnect.getConnect();
			  PreparedStatement pstmt = conn.prepareStatement("select * from product where pcode = ?");
			  pstmt.setString(1, pcode);
			  ResultSet rs = pstmt.executeQuery();
			  if(rs.next()) {
				  pb = new ProductBean();
				  pb.setPcode(rs.getString(1));
				  pb.setPname(rs.getString(2));
				  pb.setPcomp(rs.getString(3));
				  pb.setPrice(rs.getString(4));
				  pb.setQty(rs.getString(5));
				  
			  }
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return pb;
    	  
      }
}
