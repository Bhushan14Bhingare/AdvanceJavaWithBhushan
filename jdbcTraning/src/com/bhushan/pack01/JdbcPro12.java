package com.bhushan.pack01;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


public class JdbcPro12 {

	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "Bhushan_test";
	String pwd = "789";
	String query = "Select * from Employee where eid = ?";
	
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
	
	public void meth01() {
		Connection conn = connection();
		
		try {
			
		DatabaseMetaData dtmt = conn.getMetaData();
		IO.println("getDatabaseProductName() "+dtmt.getDatabaseProductName());
		IO.println("getDatabaseProductVersion() "+dtmt.getDatabaseProductVersion());
		IO.println("getDriverName() "+dtmt.getDriverName());
		IO.println("supportsStoreProcedure() "+dtmt.supportsStoredProcedures());
		IO.println("========================================");
		
	   PreparedStatement pstmt = conn.prepareStatement(query);
	   pstmt.setString(1, "101");
	    ResultSet rs = pstmt.executeQuery();
	    
	    ParameterMetaData pmt = pstmt.getParameterMetaData();
	    IO.println("getParameterCount() "+pmt.getParameterCount());
	    IO.println("getParameterType() "+pmt.getParameterType(1));
	    IO.println("getParameterMode() "+pmt.getParameterMode(1));
	    IO.println("isNullable() "+pmt.isNullable(1));
	    IO.println("========================================");
	    
	    ResultSetMetaData rsmtd = rs.getMetaData();
	    IO.println("getColumnCount() "+rsmtd.getColumnCount());
	    IO.println("getColumnName() "+rsmtd.getColumnName(1));
	    IO.println("getColumnDisplaySize() "+rsmtd.getColumnDisplaySize(1));
	    IO.println("isAutoIncrement() "+rsmtd.isAutoIncrement(1));
	    IO.println("========================================");
	    
	    RowSetFactory rsf = RowSetProvider.newFactory();
		CachedRowSet crs = rsf.createCachedRowSet();
		crs.setUrl(dburl);
		crs.setUsername(user);
		crs.setPassword(pwd);
		crs.setCommand("select eid,efname,esal from employee");
		crs.execute();
	    RowSetMetaData row = (RowSetMetaData)crs.getMetaData();
	    IO.println("getColumnCount() "+row.getColumnCount());
	    IO.println("getColumnName() "+row.getColumnName(1));
	    IO.println("getColumnDisplaySize() "+row.getColumnDisplaySize(1));
	    IO.println("isAutoIncrement() "+row.isAutoIncrement(1));
	    IO.println("getColumnType() "+row.getColumnType(1));
	    
	    
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		new JdbcPro12().meth01();
	}

}
