package com.bhushan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/pd")
public class Person extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("pname");
		String age = req.getParameter("page");
		String mob = req.getParameter("pmob");
		String gender = req.getParameter("choice");
		String []check = req.getParameterValues("check");
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.println("<center><h1>");
		pw.println("Name : "+name+"<br><br>");
		pw.println("Age : "+age+"<br><br>");
		pw.println("Mobile : "+mob+"<br><br>");
		pw.println("Gender : "+gender+"<br><br>");
		for(String str : check) {
		pw.println("Hobbies are : "+str+"<br><br>");
		}
		pw.println("</h></center>");
	}

}
