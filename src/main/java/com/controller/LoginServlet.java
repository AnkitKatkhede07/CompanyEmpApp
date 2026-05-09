package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        if(username.equals("admin") && password.equals("123")) {
//            RequestDispatcher r=request.getRequestDispatcher("dashboard.html");
//            r.forward(request, response);
//            response.getWriter().println("valid Login");
//
//        } else {
//            response.getWriter().println("Invalid Login");
//        }

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        if(username.equals(username) && password.equals(password)) {

	            response.sendRedirect(request.getContextPath() + "/dashboard.html");

	        } else {
	            response.getWriter().println("Invalid Login");
	        }
	}

}
