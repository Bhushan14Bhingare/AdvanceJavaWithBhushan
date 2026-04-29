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

@WebServlet("/buyProduct")
public class UpdateBuyProductServlet extends HttpServlet{
	
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
			String pprice = req.getParameter("bprice");
			String pqty = req.getParameter("bqty");
			String requ = req.getParameter("breq");
			String pcode = req.getParameter("bcode");

//			int qty = Integer.parseInt(pqty);
//			int buy = Integer.parseInt(requ);
//			Double amount = Double.parseDouble(pprice);
//			int availableQty = qty - buy;
//            String str = ""+amount * ;
			 ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("productList");
		       Iterator<ProductBean> itr = al.iterator();
		       ProductBean pb = null;
		       
		       
		       while(itr.hasNext()) {
		    	      pb = itr.next();
		    	      if(pcode.equals(pb.getPcode())) {
		    	    	  break;
		    	      }
		       }
		       pb.setPcode(pcode);
		       pb.setQty(requ);
		       
		       int rowCount = new AfterBuyProductDAO().updateData(pb);
		       
		       if(rowCount > 0) {
		    	   req.setAttribute("msg", pprice);
		    	   req.getRequestDispatcher("UpdateProduct1.jsp").forward(req, res);
		       }
		       else {
		    	   req.setAttribute("msg", "Product Inventory Updation Failed");
		    	   req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		       }
      
               
		       
		}
}
}
