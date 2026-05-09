package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.Department;
import com.model.Employee;
import com.service.DepartmentService;
import com.service.EmployeeService;


@WebServlet("/updateDept")
public class UpdateDeptServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

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


