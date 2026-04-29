package com.bhshan.product;

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
public class UpdateProductServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
			String price = req.getParameter("price");
			String pqty = req.getParameter("qty");
			String pcode = req.getParameter("id");
			
			
		       
		       
		      
		       
		       int rowCount = new UpdateProductDAO().updateProduct(price,pqty,pcode);
		       
		       if(rowCount > 0) {
		    	   req.setAttribute("msg", "Product Inventory Update Sucessfuly");
		    	   req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		       }
		       else {
		    	   req.setAttribute("msg", "Product Inventory Updation sucee");
		    	   req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		       }
		}
}
