package com.bhushan.registration;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
	   UserBean ub = new UserLoginDAO().login(req.getParameter("uname"),req.getParameter("upwd"));
	   
	   if(ub==null) {
		   req.setAttribute("msg", "Invalid Login Credentials!!!");
		   req.getRequestDispatcher("Register.jsp").forward(req, res);
	   }
	   else {
		   ServletContext context = req.getServletContext();
		   context.setAttribute("userBean", ub);
		   Cookie ck = new Cookie("ck1", ub.getU_fname());
		   res.addCookie(ck);
		   req.getRequestDispatcher("Home.jsp").forward(req, res);
	   }
		
	}
	

}
