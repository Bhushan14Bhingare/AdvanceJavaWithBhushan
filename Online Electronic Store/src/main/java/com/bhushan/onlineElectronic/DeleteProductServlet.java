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
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		if(session==null)
		{
			throw new RuntimeException("Session Expired");
		}
		else
		{
		       String pcode = req.getParameter("pcode");
		      int rowCount = new DeleteProductDAO().deleteProduct(pcode);
		      
		      if(rowCount > 0) {
		    	  req.setAttribute("msg", "Product Delete Sucessfully");
			       req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
		      }
		}
}

}
