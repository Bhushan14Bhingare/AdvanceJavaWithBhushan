package com.bhushan.employee;

import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fs")
public class AddEmpServlet extends HttpServlet{

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		EmpBean eb = new EmpBean();
		
		eb.setEmp_id(req.getParameter("eid"));
		eb.setEmp_first(req.getParameter("efirst"));
		eb.setEmp_last(req.getParameter("elast"));
		eb.setEmp_sal(Integer.parseInt(req.getParameter("esal")));
		eb.setEmp_add(req.getParameter("eaddr"));
		
		AddEmpDao add = new AddEmpDao();
		
		int rowCount = add.insertempData(eb);
		
		if(rowCount>0) {
			req.setAttribute("msg","Employee Record Inserted Successfully");
			req.getRequestDispatcher("AddEmployee.jsp").forward(req, res);
		}
		else {
			throw new RuntimeException("Employee record is not inserted");
		}
	}
}
