package com.bhushan.onlineElectronic;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AfterBuyProductDAO {
         public int updateData(ProductBean pb) {
        	         
        	 int rowCount = 0 ;
        	 
        	 try {
        		  Connection conn = DBConnect.getConnect();
        		  PreparedStatement pstmt = conn.prepareStatement("Update product set pqty = ? where pcode = ?");
        		  pstmt.setString(1, pb.getQty());
        		  pstmt.setString(2, pb.getPcode());
        	      rowCount = pstmt.executeUpdate();
        	 }
        	 catch(Exception e) {
        		 e.printStackTrace();
        	 }
			 return rowCount;
        	 
        	 
         }
}
