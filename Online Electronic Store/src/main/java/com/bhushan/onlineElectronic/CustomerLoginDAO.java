package com.bhushan.onlineElectronic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDAO {
	
      public CustomerBean checkValid(String user,String pass) {
    	       CustomerBean cb = null;
    	       
    	       try {
    	    	      Connection conn = DBConnect.getConnect();
    	    	     PreparedStatement pstmt = conn.prepareStatement("Select * from customer where uname = ? and password = ?");
    	    	     pstmt.setString(1, user);
    	    	     pstmt.setString(2, pass);
    	    	     
    	    	     ResultSet rs = pstmt.executeQuery();
    	    	     if(rs.next()) {
    	    	    	    cb = new CustomerBean();
    	    	    	    cb.setUsername(rs.getString(1));
    	    	    	    cb.setPassword(rs.getString(2));
    	    	    	    cb.setFname(rs.getString(3));
    	    	    	    cb.setLname(rs.getString(4));
    	    	    	    cb.setAddress(rs.getString(5));
    	    	    	    cb.setMail(rs.getString(6));
    	    	    	    cb.setPhone(rs.getString(7));
    	    	     }
    	       }
    	       catch(Exception e) {
    	    	       e.printStackTrace();
    	       }
    	       
			   return cb;
      }
}
