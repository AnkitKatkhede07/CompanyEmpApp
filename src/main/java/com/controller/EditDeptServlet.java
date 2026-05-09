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
 * Servlet implementation class EditDeptServlet
 */
@WebServlet("/editDept")
public class EditDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<form action='updateDept' method='post'>");

        out.println("<input type='hidden' name='deptId' value='" + id + "'>");
        out.println("<input type='text' name='deptName' placeholder='New Name'>");

        out.println("<button type='submit'>Update</button>");
        out.println("</form>");
        
        
        
        /////
        /// 
        /// 
      id = Integer.parseInt(request.getParameter("id"));
        Employee emp = new EmployeeService().findById(id);
        List<Department> deptList = new DepartmentService().list();

        response.setContentType("text/html");
        PrintWriter out1 = response.getWriter();

        out1.println("<!DOCTYPE html>");
        out1.println("<html lang='en'>");
        out1.println("<head>");
        out1.println("<meta charset='UTF-8'>");
        out1.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out1.println("<title>Update Employee</title>");
        out1.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out1.println("</head>");
        out1.println("<body class='bg-light'>");
        out1.println("<div class='container py-5'>");
        out1.println("<div class='card shadow-sm mx-auto' style='max-width: 500px;'>");
        out1.println("<div class='card-body'>");
        out1.println("<h3 class='text-center mb-4'>Update Employee</h3>");

        out1.println("<form action='updateEmployee' method='post'>");

        out1.println("<input type='hidden' name='empId' value='" + emp.getEmpId() + "'>");

        out1.println("<div class='mb-3'>");
        out1.println("<label class='form-label'>Name</label>");
        out1.println("<input type='text' name='name' class='form-control' value='" + emp.getName() + "'>");
        out1.println("</div>");

        out1.println("<div class='mb-3'>");
        out1.println("<label class='form-label'>Email</label>");
        out1.println("<input type='email' name='email' class='form-control' value='" + emp.getEmail() + "'>");
        out1.println("</div>");

        out1.println("<div class='mb-3'>");
        out1.println("<label class='form-label'>Contact</label>");
        out1.println("<input type='text' name='contact' class='form-control' value='" + emp.getContact() + "'>");
        out1.println("</div>");

        out1.println("<div class='mb-3'>");
        out1.println("<label class='form-label'>Department</label>");
        out1.println("<select name='deptId' class='form-select'>");

        for (Department d : deptList) {
            if (d.getDeptId() == emp.getDeptId()) {
                out1.println("<option value='" + d.getDeptId() + "' selected>" + d.getDeptName() + "</option>");
            } else {
                out1.println("<option value='" + d.getDeptId() + "'>" + d.getDeptName() + "</option>");
            }
        }

        out1.println("</select>");
        out1.println("</div>");

        out1.println("<button type='submit' class='btn btn-primary w-100'>Update</button>");
        out1.println("</form>");

        out1.println("</div>");
        out1.println("</div>");
        out1.println("</div>");
        out1.println("</body>");
        out1.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
