package com.bhushan.onlineElectronic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/clog")
public class CustomerLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	      
    	    CustomerBean cb = new CustomerLoginDAO().checkValid(req.getParameter("user"), req.getParameter("pass"));
    	    
    	    if(cb == null) {
    	    	   req.setAttribute("msg","Invalid Credintial");
    	    	   req.getRequestDispatcher("CustomerLogin.html").forward(req, res);
    	    }
    	    else {
    	    	   HttpSession session = req.getSession();
    	    	   session.setAttribute("cbean", cb);
    	    	   req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
    	    }
    	    
    }
}
