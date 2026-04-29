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
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		if(session==null)
		{
			throw new RuntimeException("Session Expired");
		}
		else
		{
			String pprice = req.getParameter("pprice");
			String pqty = req.getParameter("pqty");
			String pcode = req.getParameter("pcode");
			
			 ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("productList");
		       Iterator<ProductBean> itr = al.iterator();
		       ProductBean pb = null;
		       while(itr.hasNext()) {
		    	      pb = itr.next();
		    	      if(pcode.equals(pb.getPcode())) {
		    	    	  break;
		    	      }
		       }
		       pb.setPrice(pprice);
		       pb.setQty(pqty);
		       
		       int rowCount = new UpdateProductDAO().updateProduct(pb);
		       
		       if(rowCount > 0) {
		    	   req.setAttribute("msg", "Product Inventory Update Sucessfuly");
		    	   req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		       }
		       else {
		    	   req.setAttribute("msg", "Product Inventory Updation Failed");
		    	   req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		       }
		}
}
	
}
