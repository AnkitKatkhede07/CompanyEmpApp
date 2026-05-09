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
import com.model.Employee;
import com.service.DepartmentService;
import com.service.EmployeeService;

/**
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet("/editEmployee")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        Employee emp = new EmployeeService().findById(id);
        List<Department> deptList = new DepartmentService().list();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Update Employee</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("</head>");
        out.println("<body class='bg-light'>");
        out.println("<div class='container py-5'>");
        out.println("<div class='card shadow-sm mx-auto' style='max-width: 500px;'>");
        out.println("<div class='card-body'>");
        out.println("<h3 class='text-center mb-4'>Update Employee</h3>");

        out.println("<form action='updateEmployee' method='post'>");
        out.println("<input type='hidden' name='empId' value='" + emp.getEmpId() + "'>");

        out.println("<div class='mb-3'>");
        out.println("<label class='form-label'>Name</label>");
        out.println("<input type='text' name='name' class='form-control' value='" + emp.getName() + "'>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<label class='form-label'>Email</label>");
        out.println("<input type='email' name='email' class='form-control' value='" + emp.getEmail() + "'>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<label class='form-label'>Contact</label>");
        out.println("<input type='text' name='contact' class='form-control' value='" + emp.getContact() + "'>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<label class='form-label'>Department</label>");
        out.println("<select name='deptId' class='form-select'>");

        for (Department d : deptList) {
            if (d.getDeptId() == emp.getDeptId()) {
                out.println("<option value='" + d.getDeptId() + "' selected>" + d.getDeptName() + "</option>");
            } else {
                out.println("<option value='" + d.getDeptId() + "'>" + d.getDeptName() + "</option>");
            }
        }

        out.println("</select>");
        out.println("</div>");

        out.println("<button type='submit' class='btn btn-primary w-100'>Update</button>");
        out.println("</form>");

        out.println("</div></div></div></body></html>");
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
