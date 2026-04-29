package com.bhushan.employee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/view")
public class ViewEmployeeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ViewEmpDAO obj = new ViewEmpDAO();
		
		ArrayList<EmpBean> al = obj.retrive_EMPData(); 		 
		req.setAttribute("list", al);
		
		req.getRequestDispatcher("ViewEmployee.jsp").forward(req, res);
	}

}