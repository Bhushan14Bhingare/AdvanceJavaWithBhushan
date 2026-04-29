package com.bhushan.pack01;

import java.sql.Connection;

import com.bhushan.connection_pool.ConnectionPool;

public class JdbcPro11 {
	
	
	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String userName = "Bhushan_test";
	String pwd = "789";
	
	public void meth1() {
		ConnectionPool cp = new ConnectionPool(driver, dburl, userName, pwd);
		cp.con_Initialization();
		IO.println("\n--------User1--------");
		Connection con1 = cp.con_Acquisition();
		IO.println("User1 get the connection "+con1);
		IO.println("\n--------User2--------");
		Connection con2 =cp.con_Acquisition();
		IO.println("User2 get the connection "+con2);
		
		IO.println("\n--------User3--------");
		Connection con3 = cp.con_Acquisition();
		IO.println("User2 get the connection "+con3);
		
		cp.con_Return(con3);
		cp.con_Return(con2);
		cp.con_Return(con1);
	}
	public static void main(String[] args) {

		new JdbcPro11().meth1();

	}

}
