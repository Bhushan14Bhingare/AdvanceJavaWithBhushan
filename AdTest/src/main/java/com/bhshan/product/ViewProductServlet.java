package com.bhshan.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/View")
public class ViewProductServlet extends HttpServlet {
 
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
			
			ArrayList<ProductBean> al = new ViewProductDAO().retriveProducts();
			req.setAttribute("productList", al);
			req.getRequestDispatcher("ViewProduct1.jsp").forward(req, res);
			
		
		
	}
}
