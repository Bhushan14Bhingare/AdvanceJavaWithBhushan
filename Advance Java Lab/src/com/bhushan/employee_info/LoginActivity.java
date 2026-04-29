package com.bhushan.employee_info;

public class LoginActivity {

	public static void main(String[] args) {
		RegistrationPage registration = new RegistrationPage();
		LoginPage login = new LoginPage();
		
		while(true) {
			IO.println("1. Registration");
			IO.println("2. Login");
			int choice  = Integer.parseInt(IO.readln("Enter a choice : "));
			
				switch(choice) {
				
				case 1->{
				registration.registration();
			}
			case 2->{
				login.login();
			}
		}
	}
	
	}
}
