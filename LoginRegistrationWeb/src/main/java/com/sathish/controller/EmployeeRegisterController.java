package com.sathish.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sathish.dao.EmployeeDAO;
import com.sathish.model.EmployeeRegistration;
@WebServlet("/EmployeeRegister")
public class EmployeeRegisterController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		EmployeeRegistration reg=new EmployeeRegistration();
	
		reg.setEmployeeName(name);
		reg.setEmailId(email);
		reg.setPassword(password);
		EmployeeDAO dao=new EmployeeDAO();
		dao.save(reg);
		response.sendRedirect("login.jsp");
	}

}
