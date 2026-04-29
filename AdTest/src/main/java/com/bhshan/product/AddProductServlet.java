package com.bhshan.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/pro")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
			ProductBean pb = new ProductBean();
			pb.setId(req.getParameter("id"));
			pb.setName(req.getParameter("name"));
			
			pb.setPrice(req.getParameter("price"));
			pb.setQuantity(req.getParameter("qty"));
			
			int rowCount = new AddProductDAO().add(pb);
			if(rowCount>0)
			{
				req.setAttribute("msg", "Product inserted Successfully");
				req.getRequestDispatcher("AddSucess.jsp").forward(req, resp);
			}
			else
			{
				throw new RuntimeException("Failed");
			}
		}
	}

