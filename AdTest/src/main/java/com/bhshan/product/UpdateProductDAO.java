package com.bhshan.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO {
	public int updateProduct(String price,String pqty,String pcode) {
	      int row = 0;
	      try {
	    	     Connection conn = DBConnect.getConnect();
	    	     PreparedStatement pstmt = conn.prepareStatement("Update products set price = ? , pqty = ? where pid = ?");
	    	     pstmt.setString(1, price);
	    	     pstmt.setString(2,pqty);
	    	     pstmt.setString(3, pcode);
	    	     row = pstmt.executeUpdate();
	      }
	      catch(Exception e) {
	    	  e.printStackTrace();
	      }
		  return row;
 }
}
