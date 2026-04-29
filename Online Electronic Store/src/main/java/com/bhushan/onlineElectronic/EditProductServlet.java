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
import javax.tools.ForwardingFileObject;
@WebServlet("/edit")
public class EditProductServlet extends HttpServlet {
     
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
		       ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("productList");
		       Iterator<ProductBean> itr = al.iterator();
		       ProductBean pb = null;
		       while(itr.hasNext()) {
		    	      pb = itr.next();
		    	      if(pcode.equals(pb.getPcode())) {
		    	    	  break;
		    	      }
		       }
		       req.setAttribute("p_bean", pb);
		       req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
		}
}
}
