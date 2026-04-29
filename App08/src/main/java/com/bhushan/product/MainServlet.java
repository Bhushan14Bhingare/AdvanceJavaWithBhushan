package com.bhushan.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/product")
public class MainServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	String pname = 	req.getParameter("pname");
	String pid   = 	req.getParameter("pid");
	String pqty  = 	req.getParameter("pqty");
	String price = 	req.getParameter("pprice");
		
	req.setAttribute("pname", pname);
	req.setAttribute("pid", pid);
	req.setAttribute("pqty", pqty);
	req.setAttribute("price", price);
	
	req.getRequestDispatcher("Display.jsp").forward(req, res);
	}

}
