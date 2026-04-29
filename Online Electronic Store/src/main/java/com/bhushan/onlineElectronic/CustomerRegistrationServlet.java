package com.bhushan.onlineElectronic;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/creg")
public class CustomerRegistrationServlet extends HttpServlet{
      
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException , ServletException {
		CustomerBean cb = new CustomerBean();
		
		cb.setUsername(req.getParameter("uname"));
		cb.setPassword(req.getParameter("upwd"));
		cb.setFname(req.getParameter("ufname"));
		cb.setLname(req.getParameter("ulname"));
		cb.setAddress(req.getParameter("uladdress"));
		cb.setMail(req.getParameter("umail"));
		cb.setMail(req.getParameter(req.getParameter("uphone")));
		
		int rowCount = new CustomerDAO().insertCustomerData(cb);
		
		if(rowCount == 0) {
			req.setAttribute("msg", "Customer Already register");
			req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);
		}
		else {
			
			req.setAttribute("abean", "Customer registration Sucessfully");
			req.getRequestDispatcher("Customer.jsp").forward(req, res);
		}
	}
}
