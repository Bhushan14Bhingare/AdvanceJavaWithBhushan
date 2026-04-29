
package com.bhushan.pack01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fs1")
public class UserName extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

         String user = req.getParameter("uname");
         String pass= req.getParameter("upassword");
         PrintWriter pw = res.getWriter();
         res.setContentType("text/html");
         pw.println("<Center><h1>");
         pw.println("WelCome "+user+"<br><br>");
         if(pass.equals("java is awesome")) {
        	 
 			
 			pw.println("You did the task!!!");
        			 
         }
         else {
        	 
        	 pw.println("Invalid credentials!!!");
         }
		
         pw.println("<h1></center>");
	}

	
	
}
