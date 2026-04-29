package com.bhushan.registrationTask;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	public class Employee {
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
		
		public void registration() {
			
			try {
				Connection conn = connect();
				PreparedStatement pstmt1 = conn.prepareStatement("Insert into  Employee_Details values(?,?,?,?,?,?,?)");
				
				String eName = IO.readln();	
				String pswd = IO.readln();
				String fName = IO.readln();
				String lName = IO.readln();
				String addr = IO.readln();
				String mail = IO.readln();
				long number = Integer.parseInt(IO.readln());
				
				pstmt1.setString(1, eName);
				pstmt1.setString(2, pswd);
				pstmt1.setString(3, fName);
				pstmt1.setString(4, lName);
				pstmt1.setString(5, addr);
				pstmt1.setString(6, mail);
				pstmt1.setLong(7,number);
				
				int row = pstmt1.executeUpdate();
				
				if(row > 0) {
					IO.println("Employee registration successfull");
				}
				else {
					IO.println("Employee registration unsuccessfull");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}		
		}
		
		public void Login() {
			try {
				Connection conn = connect();
				PreparedStatement pstmt1 = conn.prepareStatement("Select ENAME from Employee_Details");
				PreparedStatement pstmt2 = conn.prepareStatement("Select PASSWORD from Employee_Details");
				
				
				String username = IO.readln("Enter a user name : ");
				String password = IO.readln("Enter a password : ");
				ResultSet rs = pstmt1.executeQuery();
				ResultSet r1 = pstmt2.executeQuery();
				PreparedStatement pstmt4 = conn.prepareStatement("Update Employee_Details set  address = ? where Ename = '"+username+"'");
				PreparedStatement pstmt5 = conn.prepareStatement("Update Employee_Details set PHONE_NUMBER  = ? where Ename = '"+username+"'");
				PreparedStatement pstmt3 = conn.prepareStatement("Select ENAME,FNAME,LNAME,ADDRESS,MAIL_ID,PHONE_NUMBER from Employee_Details Where Ename = '"+username+"'");
				
				if(rs.next() && r1.next()) {
				if(username.equals(rs.getString(1)) && password.equals(r1.getString(1))) {
					
					IO.println("User Name and Password is a matching ");
					while(true) {
						
						IO.println("1. View Profile");
						IO.println("2. Update Profile");
						IO.println("3. Exit");
						int choice = Integer.parseInt(IO.readln("Enter a choice : "));
						switch(choice) {
						
						case 1 ->{
							IO.println("View Profile");
							ResultSet rs1 = pstmt3.executeQuery();

							if(rs1.next()) {
								IO.println(rs1.getString(1)+" , "+rs1.getString(2)+" , "+rs1.getString(3)+" , "+rs1.getString(4)+" , "+rs1.getString(5)+" , "+rs1.getLong(6));
							}
							else {
								IO.println("Employee record with username "+username+" is not found");
							}
						}
	                    case 2->{
							IO.println("Update Profile");
							IO.println();
							IO.println("1. Modify the address");
							IO.println("2. Modify the Phone number");
							
							int choice1 = Integer.parseInt(IO.readln());
							
							switch(choice1) {
							case 1->{
								String address1 = IO.readln("Enter a address");
								pstmt4.setString(1, address1);
			                	
			                    int row = pstmt4.executeUpdate();
								
								if(row>0) {
									IO.println("Employee  address  is update.");
								}
								else {
									IO.println("Employee address is not Updated.");
								}
							}
							case 2->{
								
								long phone = Long.parseLong(IO.readln("Enter a employee number"));
								
								pstmt5.setLong(1, phone);
	                            int row = pstmt4.executeUpdate();
								
								if(row>0) {
									IO.println("Employee  phone  is update.");
								}
								else {
									IO.println("Employee phone is not Updated.");
								}
							}
					
							}
						}
	                    case 3 ->{
	                    	IO.println("Thank for using application");
							System.exit(0);
						}
						}
					}
				}
				else {
					IO.println("User Name and password is not matching");
				}
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

		public static void main(String[] args) {
			Employee emp = new Employee();
			
			emp.registration();
//			emp.Login();
		}

	}

