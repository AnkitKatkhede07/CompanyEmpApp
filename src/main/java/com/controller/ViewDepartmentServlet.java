package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.model.Department;
import com.service.DepartmentService;

/**
 * Servlet implementation class ViewDepartmentServlet
 */
@WebServlet("/viewDepartments")
public class ViewDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Department> list = new DepartmentService().list();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2 style='font-family:Arial; text-align:center;'>Department List</h2>");

        out.println("<table style='border-collapse:collapse; margin:auto; font-family:Arial;'>");

        out.println("<tr style='background:#f2f2f2;'>");
        out.println("<th style='padding:6px; border:1px solid #ccc;'>ID</th>");
        out.println("<th style='padding:6px; border:1px solid #ccc;'>Name</th>");
        out.println("<th style='padding:6px; border:1px solid #ccc;'>Action</th>");
        out.println("</tr>");
	
        for (Department d : list) {

            out.println("<tr>");

            out.println("<td style='padding:6px; border:1px solid #ccc;'>" + d.getDeptId() + "</td>");
            out.println("<td style='padding:6px; border:1px solid #ccc;'>" + d.getDeptName() + "</td>");

            out.println("<td style='padding:6px; border:1px solid #ccc;'>");

            out.println("<a href='deleteDept?id=" + d.getDeptId() + "' style='color:red;'>Delete</a> | ");
            out.println("<a href='editDept?id=" + d.getDeptId() + "' style='color:blue;'>Update</a>");

            out.println("</td>");

            out.println("</tr>");
        }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
