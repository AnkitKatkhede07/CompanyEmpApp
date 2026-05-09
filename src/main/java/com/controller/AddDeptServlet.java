package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.Department;
import com.service.DepartmentService;


@WebServlet("/addDept")
public class AddDeptServlet extends HttpServlet {

 
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        out.println("<form action='addDept' method='post'>");
//
//        out.println("<div>");
//        out.println("<input type='text' name='deptName' placeholder='Enter Department' class='form-control'/>");
//        out.println("</div>");
//
//        out.println("<div>");
//        out.println("<input type='submit' value='Add Department' class='btn btn-primary'/>");
//        out.println("</div>");
//
//        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

    	String name = request.getParameter("deptName");

        Department d = new Department();
        d.setDeptName(name);

        DepartmentService service = new DepartmentService();

        if (service.save(d)) {
            response.sendRedirect("dashboard.html");
        } else {
            response.getWriter().println("Error");
        }
    }
}