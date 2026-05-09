package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.DepartmentService;
import com.service.EmployeeService;

/**
 * Servlet implementation class DeleteDeptServlet
 */
@WebServlet("/deleteDept")
public class DeleteDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		 int id = Integer.parseInt(request.getParameter("id"));
	        new DepartmentService().remove(id);

	        response.sendRedirect("viewDepartments");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
	       new DepartmentService().remove(id);
	       response.sendRedirect("Add.html");

	}

}
