package com.bhushan.pack01;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcPro08 {

	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String userName = "Bhushan_test";
	String pwd = "789";

	void meth1() {
		IO.println("Implementing JdbcRowSet");
		
		try {
			RowSetFactory rsf = RowSetProvider.newFactory();
			JdbcRowSet jrs = rsf.createJdbcRowSet();
			jrs.setUrl(dburl);
			jrs.setUsername(userName);
			jrs.setPassword(pwd);
			jrs.setCommand("select * from employee");
			jrs.execute();
			
			while(jrs.next()) {
				 IO.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
		   		 }
			IO.println("-----------------------------------------------");

			while(jrs.previous()) {
				IO.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
		   		 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void meth2() {
		try {
			RowSetFactory rsf = RowSetProvider.newFactory();
			CachedRowSet crs = rsf.createCachedRowSet();
			crs.setUrl(dburl);
			crs.setUsername(userName);
			crs.setPassword(pwd);
			crs.setCommand("select eid,efname,esal from employee");
			crs.execute();
			
			while (crs.next()){
				String e_id = crs.getString(1);
				
				if(e_id.equals("102")) {
					crs.updateInt(3,75000);
					crs.updateRow();
					}
			}
			crs.acceptChanges();
			crs.absolute(3);
			IO.println(crs.getString(1)+" "+crs.getString(2)+" "+crs.getString(3));
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		JdbcPro08 obj = new JdbcPro08();
		obj.meth2();
	}

}
