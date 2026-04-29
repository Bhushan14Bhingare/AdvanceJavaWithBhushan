package com.bhushan.pack01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPro04 {
	
	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "Bhushan_test";
	String pwd = "789";
	
	
	public Connection connection() {
		Connection con = null;
		try {
		Class.forName(driver);
		 con = DriverManager.getConnection(dburl,user,pwd);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;		
	}
	
	public void addBook() {
		String bookId = IO.readln("Enter a book id : ");
		String bookName = IO.readln("Enter a book name : ");
		String author = IO.readln("Enter a author name : ");
		String generic = IO.readln("Enter a genere type : ");
		double price = Double.parseDouble(IO.readln("Enter a cost of book : "));
		String query1 = "Insert into Library values('"+bookId+"','"+bookName+"','"+author+"','"+generic+"','"+price+"')";
		try {
			Connection conn = connection();
			Statement stat = conn.createStatement();
			int row = stat.executeUpdate(query1);
			
			if(row > 0) {
				IO.println(bookName+" book Inserted Succesfully");
			}
			else {
				IO.println(bookName+" book not Inserted");
			}		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reteriveBook() {
		
		String bookid = IO.readln("Enter a book id : ");
		String query2 = "Select * from library where bookid = '"+bookid+"'";
		try {
			Connection con = connection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query2);
			
			while(rs.next()) {
				IO.println(rs.getObject(1)+" , "+rs.getObject(2)+" , "+rs.getObject(3)+" , "+rs.getObject(4)+" , "+rs.getObject(5));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBook() {
		String bookid = IO.readln("Enter a book id : ");
		String query3 = "Delete  from library where bookid = '"+bookid+"'";
		try {
			Connection con = connection();
			Statement stat = con.createStatement();
			int row = stat.executeUpdate(query3);
			
			if(row > 0) {
				IO.println("Delete the book "+bookid+" succesfully");
			}
			else {
				IO.println("Book is not deleted.");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
public void viewBook() {
		
		
		String query2 = "Select * from library ";
		try {
			Connection con = connection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query2);
			
			while(rs.next()) {
				IO.println(rs.getObject(1)+" , "+rs.getObject(2)+" , "+rs.getObject(3)+" , "+rs.getObject(4)+" , "+rs.getObject(5));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void libraryMenu(){
		
		while(true) {
			
			IO.println("1. Adding book to the library.");
			IO.println("2. Reterving book from the library.");
			IO.println("3. Deleting book to the library.");
			IO.println("4. View book to the library.");
			IO.println("5. Exit");
			int choice = Integer.parseInt(IO.readln("Enter your choice : "));
			switch(choice) {
			case 1 ->{
				IO.println("Adding book to the library.");
				addBook();
			}
			case 2 ->{
				IO.println("Reterving book from the library.");
				reteriveBook();
			}
			case 3->{
				IO.println("Deleting book to the library.");
				deleteBook();
			}
			case 4->{
				IO.println("View book to the library.");
				viewBook();
			}
			
			case 5->{
				IO.println("Thank you see you soon :)");
				System.exit(0);
			}
			default ->{
				IO.println("Please choose valid option.");
			}
			}
		}
		
	}
	

	public static void main(String[] args) {
		
		JdbcPro04 obj = new JdbcPro04();
		obj.libraryMenu();
		}

}
