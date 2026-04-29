package com.bhushan.connection_pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPool {
       String driver,dburl,dbUsername,dbPwd;
       Vector<Connection> v = new Vector<>();

	   public ConnectionPool(String driver, String dburl, String dbUsername, String dbPwd) {
		
		this.driver = driver;
		this.dburl = dburl;
		this.dbUsername = dbUsername;
		this.dbPwd = dbPwd;
		
	   }
       
	   
	   public void con_Initialization() {
		   IO.println("Connection Pool is Empty");
		   IO.println("There are "+v.size()+" Connection object");
		   
		   while(v.size() < 5) {
			   try {
					Class.forName(driver);
				Connection conn	= DriverManager.getConnection(dburl,dbUsername,dbPwd);
				v.addElement(conn);				 			
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			   
			   for(Object o : v) {
				   IO.println(o);
				   IO.println("There are "+v.size()+" Connection object");
			   }
		   }
	   }
	   
	   public Connection con_Acquisition() {
		   Connection con = v.get(0);
		   v.remove(0);
		   return con;
	   }
	   
	   public void con_Return(Connection con) {
		   
		   IO.println("Adding the Connection object to the Connection Pool");
		   v.add(con);
		   IO.println("There are "+v.size()+" Connection object");
		   for(Object o : v) {
			   IO.println(o);
			   IO.println("There are "+v.size()+" Connection object");
		   }
		   
	   }
       
}
