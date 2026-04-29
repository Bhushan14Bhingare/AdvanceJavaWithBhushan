package com.bhushan.employee_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage {
	ConnectionToDatabase connect = new ConnectionToDatabase();
	
	public void login() {
	try {
		Connection conn = connect.connect();
		PreparedStatement ps =  conn.prepareStatement("Select id , name from employee_info where id = ? and name = ?");
		PreparedStatement ps1 = conn.prepareStatement("Select * from employee_info");
		PreparedStatement ps2 = conn.prepareStatement("Update employee_info set mailid = ? , phoneno = ? where id = ?");
		PreparedStatement ps3 = conn.prepareStatement("Delete from employee_info where salary between ? and ?");
		PreparedStatement ps4 = conn.prepareStatement("Update employee_info set salary = salary + (salary * 0.1)");
		String id = IO.readln("Enter a employee id : ");
		String password = IO.readln("Enter a employee password : ");
		
		ps.setString(1,id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			IO.println("Login Succesfully :)");
			
			while(true) {
				IO.println("1. Show all Employee");
				IO.println("2. Update your mailid and phone number");
				IO.println("3. Delete Employee whose salary range is 50000 to 90000");
				IO.println("4. Increment 10% salary for each person");
				IO.println("5. Logout your account");
				
				int choice = Integer.parseInt(IO.readln("Enter a your choice : "));
				switch(choice) {
				case 1->{
					ResultSet rs1 = ps1.executeQuery();
					IO.println("View all the employee details ");
					
					while(rs1.next()) {
						IO.println(rs1.getString(1) +" "+rs1.getString(2)+" "+rs1.getFloat(3)+" "+rs1.getString(4) +" "+rs1.getString(5)+" "+rs1.getString(6)+" "+rs1.getString(7));
					}
				}
                case 2->{
                    String mail = IO.readln("Enter a new mail id : ");
                    String phonenumber = IO.readln("Enter a new phone number : ");
                    ps2.setString(1, mail);
                    ps2.setString(2, phonenumber);
                    ps2.setString(3, id);
				    int rowCount =  ps2.executeUpdate();
				    if(rowCount > 0) {
				    	IO.println("Your mail id and phone number is update");
				    }
				    else {
				    	IO.println("Your mail id and phone number is not update");
				    }
				}
                
                case 3 -> {
                	int sal1 = Integer.parseInt(IO.readln("Enter a first range of salary : "));
                	int sal2 = Integer.parseInt(IO.readln("Enter a second range of salary : "));
                	
                	ps3.setInt(1, sal1);
                	ps3.setInt(2, sal2);
                	
                	int rowcount = ps3.executeUpdate();
                	if(rowcount > 0) {
                		IO.println("Employee record delete succesfully");
                	}
                	else {
                		IO.println("Employee record are not deleted");
                	}
                }
                
                case 4->{
                	int rowcount = ps4.executeUpdate();
                	if(rowcount > 0) {
                		IO.println("Employee salary is increment by 10%");
                	}
                	else {
                		IO.println("Employee record are not deleted");
                	}
                }
                case 5->{
                	IO.println("Logout your account succesfully.");
                	System.exit(0);
                }
                
				}
			}
		}
		else {
			IO.println("User name and password is wrong");
		}
		
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	
  }
}
