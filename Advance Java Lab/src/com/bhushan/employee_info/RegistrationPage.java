package com.bhushan.employee_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

public class RegistrationPage {
	
	public void registration() {
		ConnectionToDatabase connect = new ConnectionToDatabase();
		
		try {
			Connection conn =  connect.connect();
			PreparedStatement ps =  conn.prepareStatement("Insert into employee_info values(?,?,?,?,?,?,?)");
			
			String id = IO.readln("Enter a employee id : ");
			String name = IO.readln("Enter a employee password : ");
			float sal = Float.parseFloat(IO.readln("Enter a employee salary : "));
			String fName = IO.readln("Enter a employee first name : ");
			String lName = IO.readln("Enter a employee last name : ");
			String mail = IO.readln("Enter a employee mailid : ");
			String mobile = IO.readln("Enter a employee mobile number : ");
			
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setFloat(3, sal);
			ps.setString(4, fName);
			ps.setString(5, lName);
			ps.setString(6, mail);
			ps.setString(7, mobile);
			
			int row = ps.executeUpdate();
			if(row > 0) {
				IO.println("Employee data inserted succesfully");
			}
			else {
				IO.println("Employee data is not inserted.");
			}
			
		}
		catch(SQLIntegrityConstraintViolationException e){
			IO.println("Employee already completed the registation");
			System.exit(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
