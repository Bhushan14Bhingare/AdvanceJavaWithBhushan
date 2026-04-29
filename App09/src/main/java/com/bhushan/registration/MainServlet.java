package com.bhushan.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/dis")
public class MainServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	    UserBean ub = new UserBean();
	    
	    ub.setName(req.getParameter("tname"));
	    ub.setAge(req.getParameter("tage"));
        ub.setGender(req.getParameter("gen"));
        ub.setAddress(req.getParameter("taddress"));
        ub.setMarital(req.getParameter("ms"));
        ub.setQualifcation(req.getParameter("qlft"));
        ub.setCourse(req.getParameter("crs"));
        ub.setHobies(req.getParameterValues("hb"));
        
        
       
			req.setAttribute("msg", ub);
			req.getRequestDispatcher("Register.jsp").forward(req, res);
	}
		
	}


