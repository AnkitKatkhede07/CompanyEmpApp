package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.service.EmployeeService;

@WebServlet("/viewEmployees")
public class ViewEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        EmployeeService service = new EmployeeService();
        List<String[]> list;

        if (keyword != null && !keyword.trim().isEmpty()) {
            list = service.search(keyword.trim());
        } else {
            list = service.getAll();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>View Employees</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("</head>");
        out.println("<body class='bg-light'>");

        out.println("<div class='container py-5'>");
        out.println("<div class='card shadow-sm mb-4'>");
        out.println("<div class='card-body'>");
        out.println("<h3 class='text-center mb-4'>Employee List</h3>");

        out.println("<form action='viewEmployees' method='get' class='row g-2 mb-4'>");
        out.println("<div class='col-md-10'>");
        out.println("<input type='text' name='keyword' class='form-control' placeholder='Search employee by name, email, contact or department...'>");
        out.println("</div>");
        out.println("<div class='col-md-2 d-grid'>");
        out.println("<button type='submit' class='btn btn-primary'>Search</button>");
        out.println("</div>");
        out.println("</form>");

        out.println("<table class='table table-bordered table-striped table-hover'>");
        out.println("<thead class='table-dark'>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Email</th>");
        out.println("<th>Contact</th>");
        out.println("<th>Department</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        if (list.isEmpty()) {
            out.println("<tr><td colspan='6' class='text-center'>No employees found</td></tr>");
        } else {
            for (String[] e : list) {
                out.println("<tr>");
                out.println("<td>" + e[0] + "</td>");
                out.println("<td>" + e[1] + "</td>");
                out.println("<td>" + e[2] + "</td>");
                out.println("<td>" + e[3] + "</td>");
                out.println("<td>" + e[4] + "</td>");
                out.println("<td>");
                out.println("<a href='editEmployee?id=" + e[0] + "' class='btn btn-warning btn-sm me-2'>Update</a>");
                out.println("<a href='deleteEmployee?id=" + e[0] + "' class='btn btn-danger btn-sm' onclick=\"return confirm('Delete this employee?')\">Delete</a>");
                out.println("</td>");
                out.println("</tr>");
            }
        }

        out.println("</tbody>");
        out.println("</table>");

        out.println("<a href='dashboard.html' class='btn btn-secondary'>Back to Dashboard</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}