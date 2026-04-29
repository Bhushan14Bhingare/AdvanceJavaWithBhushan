package com.bhushan.pack01;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/dis")
public class ControllerServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
		ServletContext context = this.getServletContext();
		HttpSession session = req.getSession();
		
		context.setAttribute("a", 100);
		session.setAttribute("b",200);
		req.setAttribute("c", 300);
		
		req.getRequestDispatcher("Display.jsp").forward(req, res);
	}

}
