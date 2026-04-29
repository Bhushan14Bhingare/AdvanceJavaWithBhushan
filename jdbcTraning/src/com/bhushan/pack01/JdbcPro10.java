package com.bhushan.pack01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

public class JdbcPro10 {

    String driver = "oracle.jdbc.OracleDriver"; 
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String userName = "Bhushan_test";
	String pwd = "789";
	
	String query1 = "UPDATE TRAINSEATAVAILABITY SET  AVAILABLE_SEATS = AVAILABLE_SEATS - 1 WHERE TRAIN_ID = ?" 
			+" AND JOURNEY_DATE = ? AND CLASS = ? AND AVAILABLE_SEATS > 0";
	String query2 = "Insert into BOOKINGDETAILS values(?,?,?,?,?)";
	String query3 = "Select Payment_Status from CUSTOMERPAYMENT where CUSTOMER_ID =? ";
	String query4 = "Update BOOKINGDETAILS set Status = 'CONFIRMED' WHERE CUSTOMER_ID =?";
	public Connection connect() {
		Connection con = null;
		try{
			IO.println("Data base started");
		Class.forName(driver);
		 con = DriverManager.getConnection(dburl,userName,pwd);
		 IO.println("Database is connected");
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;		
	}
	
	void meth1() {
		IO.println("Implementing Transaction Management");
		try {
			Connection conn = connect();
			IO.println("Data base connected Succesfully");
			IO.println("Before disable the auto commit ===>"+conn.getAutoCommit());
			conn.setAutoCommit(false);
			IO.println("After disable the auto commit ===>"+conn.getAutoCommit());
		    PreparedStatement stmt = conn.prepareStatement(query1);
		    stmt.setString(1, "12345");
		    stmt.setString(2, "2024-10-10");
		    stmt.setString(3, "SLEEPER");
		    int rowcount = stmt.executeUpdate();
		    if(rowcount == 0) {
		    	throw new RuntimeException("Seat is not available for booking!!!");
		    }
		    else {
		    	IO.println("Seat is locked the book");
		    	
		    	@SuppressWarnings("unused")
				Savepoint sp = conn.setSavepoint();
		    	PreparedStatement stmt1 = conn.prepareStatement(query2);
		    	stmt1.setString(1,"B101");
		    	stmt1.setString(2,"12345");
		    	stmt1.setString(3,"C123");
		    	stmt1.setInt(4,1);
		    	stmt1.setString(5,"Payment Pending");
		    	int rowcount1 = stmt1.executeUpdate();
			    if(rowcount1 == 0) {
			    	throw new RuntimeException("Booking record not created");
			    }
			    else {
			    	IO.println("Booking record Created \nAwaiting for Payment Confirmation");	
			    	PreparedStatement stmt2 = conn.prepareStatement(query3);
			    	stmt2.setString(1, "C123");
			        ResultSet rs = stmt2.executeQuery();
			        String status = "Failed";
			        if(rs.next()) {
			        	status = rs.getString(1);
			        	if(status.equals("Failed")) {
			        		throw new RuntimeException("Transaction Failed");
			        	}
			        	else {
			        		PreparedStatement stmt3 = conn.prepareStatement(query4);
			        		stmt3.setString(1,"C123");
			        		int rowcount2 = stmt3.executeUpdate();
						    if(rowcount2 == 0) {
						    	throw new RuntimeException("Transcation Failed in a Payment Portal");
						    }
						    else {
						    	IO.println("Ticket successfully booked");
						    	conn.commit();
						    }
			        	}
			        }
			     }
              }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		JdbcPro10 obj = new JdbcPro10();
		obj.meth1();
	}

}
