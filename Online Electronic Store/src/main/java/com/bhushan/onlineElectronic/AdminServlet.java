package com.bhushan.onlineElectronic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/alog")
public class AdminServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		AdminBean ab = new AdminLoginDAO().checkValid(req.getParameter("user"),req.getParameter("pass"));
		
		if(ab==null) {
			req.setAttribute("msg", "Invalid user credintial");
			req.getRequestDispatcher("AdminLogin.html").forward(req, res);
		}
		else {
			HttpSession session  = req.getSession();
			session.setAttribute("abean", ab);
			req.getRequestDispatcher("AdminHome.jsp").forward(req, res);
		}
		
	}

}
