package com.bhushan.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/ms")
public class MainServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

           String data =  req.getParameter("choice");
           
           if(data.equals("GetFactorial")) {
        	   RequestDispatcher rd = req.getRequestDispatcher("/fs");
        	   rd.forward(req, res);
           }
           else {
        	   RequestDispatcher rd = req.getRequestDispatcher("/es");
        	   rd.forward(req, res);
           }
		
	}

}
