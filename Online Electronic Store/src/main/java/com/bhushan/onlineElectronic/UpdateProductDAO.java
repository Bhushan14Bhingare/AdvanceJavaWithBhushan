package com.bhushan.onlineElectronic;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO {
       public int updateProduct(ProductBean pb) {
    	      int row = 0;
    	      try {
    	    	     Connection conn = DBConnect.getConnect();
    	    	     PreparedStatement pstmt = conn.prepareStatement("Update product set pprice = ? , pqty = ? where pcode = ?");
    	    	     pstmt.setString(1, pb.getPrice());
    	    	     pstmt.setString(2,pb.getQty());
    	    	     pstmt.setString(3, pb.getPcode());
    	    	     row = pstmt.executeUpdate();
    	      }
    	      catch(Exception e) {
    	    	  e.printStackTrace();
    	      }
			  return row;
       }
}
