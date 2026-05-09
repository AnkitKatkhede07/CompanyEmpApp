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


@WebServlet("/addEmployee")
public class EmployeeServlet extends HttpServlet {
	
       
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Department> list = new DepartmentService().list();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");

        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css' rel='stylesheet'>");

        out.println("<style>");
        out.println("body{background:#eef2f7;}");
        out.println(".box{width:420px;margin:80px auto;padding:30px;background:white;border-radius:10px;box-shadow:0 5px 15px gray;}");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='box'>");

        out.println("<h3 class='text-center mb-4'>Add Employee</h3>");

        out.println("<form action='addEmployee' method='post'>");

        out.println("<div class='mb-3'>");
        out.println("<input type='text' name='name' class='form-control' placeholder='Enter Name'>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<input type='email' name='email' class='form-control' placeholder='Enter Email'>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<input type='text' name='contact' class='form-control' placeholder='Enter Contact'>");
        out.println("</div>");

        out.println("<div class='mb-3'>");

        out.println("<select name='deptId' class='form-select'>");


        for(Department d : list) {

            out.println("<option value='" + d.getDeptId() + "'>");
            out.println(d.getDeptName());
            out.println("</option>");
        }

        out.println("</select>");
        out.println("</div>");

        out.println("<button type='submit' class='btn btn-primary w-100'>Add Employee</button>");

        out.println("</form>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");

        int deptId =
        Integer.parseInt(request.getParameter("deptId"));

        Employee emp = new Employee();

        emp.setName(name);
        emp.setEmail(email);
        emp.setContact(contact);
        emp.setDeptId(deptId);

        EmployeeService service = new EmployeeService();

        if(service.saveEmployee(emp)) {

            response.sendRedirect("viewEmployees");

        } else {

            response.getWriter().println("Error");
        }
    }
}

