package com.bhushan.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fs")
public class FirstServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

     String name = req.getParameter("uname");
     String mail = req.getParameter("umail");
     PrintWriter pw = res.getWriter();
     res.setContentType("text/html");
     //System.out.println("User name : "+name);
     //System.out.println("User mail : "+mail);
     pw.println("User name : "+name);
     pw.print("User mail : "+mail);
     
		
	}

	
	
}
