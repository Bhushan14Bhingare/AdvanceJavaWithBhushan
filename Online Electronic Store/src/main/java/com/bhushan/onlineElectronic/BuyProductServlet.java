package com.bhushan.onlineElectronic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/buy")
public class BuyProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		if(session==null)
		{
			throw new RuntimeException("Session Expired");
		}
		else {
			String pcode = req.getParameter("pcode");
			
			 ProductBean pb = new BuyProductDAO().isAvailable(pcode);
		       
		       session.setAttribute("product", pb);
		       req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
		}
	}
}
