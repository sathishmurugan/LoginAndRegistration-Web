package com.sathish.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sathish.dao.LoginDAO;
import com.sathish.model.EmployeeRegistration;

@WebServlet("/login")
public class EmployeeLoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		EmployeeRegistration reg = new EmployeeRegistration();
		reg.setEmailId(email);
		reg.setPassword(password);
		LoginDAO dao = new LoginDAO();
		try {
			Boolean result = dao.validateUser(email, password);

			if (result) {
				response.sendRedirect("sucess.jsp");

			} else {
				response.sendRedirect("login.jsp");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
