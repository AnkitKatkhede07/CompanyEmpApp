package com.controller;

import jakarta.servlet.ServletException;
import com.model.Users;
import com.service.UserService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Reg")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Users user = new Users();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setContact(contact);
        user.setUsername(username);
        user.setPassword(password);
System.out.println(user);
        UserService service = new UserService();

        if (service.register(user)) {
            response.sendRedirect("login.html");
        } else {
            response.getWriter().println("Registration Failed");
        }
    }
	      
	}


