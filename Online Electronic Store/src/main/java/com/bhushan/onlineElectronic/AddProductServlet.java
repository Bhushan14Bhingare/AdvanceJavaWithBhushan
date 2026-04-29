package com.bhushan.onlineElectronic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		if(session==null)
		{
			throw new RuntimeException("Session Expired");
		}
		else
		{
			ProductBean pb = new ProductBean();
			pb.setPcode(req.getParameter("pcode"));
			pb.setPname(req.getParameter("pname"));
			pb.setPcomp(req.getParameter("pcomp"));
			pb.setPrice(req.getParameter("pprice"));
			pb.setQty(req.getParameter("qty"));
			
			int rowCount = new AddProductDAO().insertProduct(pb);
			if(rowCount>0)
			{
				req.setAttribute("msg", "Product inserted Successfully");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, resp);
			}
			else
			{
				throw new RuntimeException("Failed");
			}
		}
	}
}
