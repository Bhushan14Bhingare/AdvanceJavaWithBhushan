package com.bhushan.pack01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class JdbcPro09 {
	
	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String userName = "Bhushan_test";
	String pwd = "789";

	void meth1() {
		IO.println("Implementing Callable Statement");
		
		try {
			Class.forName(driver);
		    Connection conn	= DriverManager.getConnection(dburl,userName,pwd);
		    CallableStatement cstmt = conn.prepareCall("{call InsertData(?,?,?,?)}");		 
		    
		    String id = IO.readln("Enter a employee id : ");
		    String name = IO.readln("Enter a employee name : ");
		    String desgination = IO.readln("Enter a employee desgination : ");
		    int bsal =Integer.parseInt(IO.readln("Enter a employee salary : ")); 
		    float tsal = bsal + (0.35f * bsal) + (0.15f * bsal);
		    
		    cstmt.setString(1, id);
		    cstmt.setString(2, name);
		    cstmt.setString(3, desgination);
		    cstmt.setInt(4, bsal);
		    cstmt.setFloat(5, tsal);
		    cstmt.execute();
		    
		    IO.print("Data is inserted");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void meth2() {
		try {

			System.out.println("Implementing CallableStatement --> Procedure2 ");

			Class.forName(driver);
		    Connection con	= DriverManager.getConnection(dburl,userName,pwd);
			CallableStatement cstmt = con.prepareCall("{call ReteriveEmpData(?,?,?,?,?)}");
			
			String e_id = IO.readln("Enter a employee id : ");
			cstmt.setString(1, e_id);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.NUMERIC);

			cstmt.execute();

			System.out.println("--------Employee Details-------------");
			System.out.println("Employee ID: " + e_id);
			System.out.println("Employee Name : " + cstmt.getString(2));
			System.out.println("Employee Desg : " + cstmt.getString(3));
			System.out.println("Employee Basic Sal : " + cstmt.getInt(4));
			System.out.println("Employee Total sal : " + cstmt.getInt(5));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void meth3() {
		try {
			System.out.println("Implementing callable Statement ---> Functions ");
			
			Class.forName(driver);
		    Connection con	= DriverManager.getConnection(dburl,userName,pwd);
			CallableStatement cstmt = con.prepareCall("{call ?:=  ReteriveTsal(?)}");
			
			String e_id = IO.readln("Enter a employee id : ");
			cstmt.setString(2, e_id);
			cstmt.registerOutParameter(1, Types.NUMERIC);
			cstmt.execute();

			System.out.println("--------Employee Details-------------");
			System.out.println("Employee ID: " + e_id);
			System.out.println("Employee Total sal : " + cstmt.getInt(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		JdbcPro09 obj = new JdbcPro09();
		        obj.meth1();
//		        obj.meth2();
//				obj.meth3();
	}

}
