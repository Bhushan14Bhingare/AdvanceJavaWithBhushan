package com.bhushan.pack01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

public class JdbcPro05 {
	
	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "Bhushan_test";
	String pwd = "789";
	
	
	public Connection connect() {
		Connection con = null;
		try{
		Class.forName(driver);
		 con = DriverManager.getConnection(dburl,user,pwd);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;		
	}
	
	public void patientOpreation() {
		try{
			Connection con = connect();
			PreparedStatement pstmt1 = con.prepareStatement("Insert into Patient values(?,?,?,?)");
			PreparedStatement pstmt2 = con.prepareStatement("Select * from Patient");
			PreparedStatement pstmt3 = con.prepareStatement("Select * from Patient where pid = ?");
			PreparedStatement pstmt4 = con.prepareStatement("Update Patient set age = ? where pid = ?");
			PreparedStatement pstmt5 = con.prepareStatement("Delete from Patient where pid = ?");
			
			while(true) {
				IO.println("1. Adding the pateient details");
				IO.println("2. View all the pateient details");
				IO.println("3. Reterive the pateient details");
				IO.println("4. Update the pateient details");
				IO.println("5. Delete the pateient details");
				IO.println("6. Exit");
				
				int choice = Integer.parseInt(IO.readln("Enter a choice "));
				
				switch(choice) {
				case 1->{
					IO.println("Adding the pateient details");
					
					String p_id = IO.readln("Enter a patient id : ");
					String p_name = IO.readln("Enter a patient name: ");
					int  p_age = Integer.parseInt(IO.readln("Enter a patient age : "));
					long p_contact = Long.parseLong(IO.readln("Enter a patient contact : "));					
					
					pstmt1.setString(1, p_id);
					pstmt1.setString(2, p_name);
					pstmt1.setInt(3, p_age);
					pstmt1.setLong(4, p_contact);
					int row = pstmt1.executeUpdate();
					
					if(row>0) {
						IO.println("paitent data inserted");
					}
					else {
						throw new RuntimeException("Patient data is not inserted");
					}
				}
				case 2->{
					IO.println("View all the pateient details");
					
					ResultSet rs = pstmt2.executeQuery();
					
					while(rs.next()) {
						IO.println(rs.getString(1)+" , "+rs.getString(2)+" , "+rs.getInt(3)+" , "+rs.getLong(4));
					}
					
					
				}
                case 3->{
					IO.println("Reterive the pateient details");  
					String p_id = IO.readln("Enter a patient id : ");
					pstmt3.setString(1, p_id);
					ResultSet rs = pstmt3.executeQuery();

					if(rs.next()) {
						IO.println(rs.getString(1)+" , "+rs.getString(2)+" , "+rs.getInt(3)+" , "+rs.getLong(4));
					}
					else {
						IO.println("Patient record with patient id "+p_id+" is not found");
					}
					
				}
                case 4->{
                	IO.println("Update the pateient details"); 
                	int  p_age = Integer.parseInt(IO.readln("Enter a patient age : "));
                	String p_id = IO.readln("Enter a patient id : ");
                	
                	pstmt4.setInt(1, p_age);
                	pstmt4.setString(2, p_id);
                	
                    int row = pstmt4.executeUpdate();
					
					if(row>0) {
						IO.println("Paitent record "+p_id+" is update.");
					}
					else {
						IO.println("Patient record with patient id "+p_id+" is not Updated.");
					}
                	
				}
                case 5->{
					IO.println("Delete the pateient details");
					String p_id = IO.readln("Enter a patient id : ");
					pstmt5.setString(1, p_id);
					
                   int row1 = pstmt5.executeUpdate();
					
					if(row1>0) {
						IO.println("Paitent record with patient id "+p_id+" is delete.");
					}
					else {
						IO.println("Patient record with patient id "+p_id+" is not delete.");
					}
					
					
				}
				case 6->{
					IO.println("Thank you for Visiting...");
					System.exit(0);
				}
				default ->{
					IO.println("Please enter a valid choice");
				}
				}
			}
		}
		catch(SQLIntegrityConstraintViolationException sql) {
			IO.println("Please do not enter a duplicate value");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		JdbcPro05 obj = new JdbcPro05();
		obj.patientOpreation();

	}

}
