package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.Employee;
import com.service.EmployeeService;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int empId = Integer.parseInt(request.getParameter("empId"));
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String contact = request.getParameter("contact");
	        int deptId = Integer.parseInt(request.getParameter("deptId"));

	        Employee emp = new Employee();
	        emp.setEmpId(empId);
	        emp.setName(name);
	        emp.setEmail(email);
	        emp.setContact(contact);
	        emp.setDeptId(deptId);

	        new EmployeeService().update(emp);

	        response.sendRedirect("viewEmployees");
	    }
	}
