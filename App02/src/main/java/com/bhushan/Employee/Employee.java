package com.bhushan.Employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/EmpLoyee Details")
public class Employee extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String empName = req.getParameter("empname");
		String empMail = req.getParameter("empId");
		String empSal = req.getParameter("empSal");
		String empExp = req.getParameter("empExp");
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		int exp = Integer.parseInt(empExp);
		double sal = Double.parseDouble(empSal);		
		if(exp >= 5){
			pw.println("<Center><h1>");
			pw.println("Employee data<br><br>");
			pw.println("Employee name : "+empName+"<br><br>");
			pw.println("Employee mail id : "+empMail+"<br><br>");
			pw.println("Employee salary : "+(sal*0.10+sal)+"<br><br>");
			pw.println("<h1></center>");			
		}

	}
}
