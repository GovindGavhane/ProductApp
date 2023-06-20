package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dto.User;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String username = req.getParameter("name");
		String password = req.getParameter("password");
		UserDao dao = new UserDao();
		User user = dao.verifyUser(username, password);
		if(user!=null)
		{
			 RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			 dispatcher.forward(req, resp);
		}else
		{
			PrintWriter writer = resp.getWriter();
			writer.write("<html><body><h4 align=center bgcolor=red> Please Enter the valid Username and Password</h4></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			 dispatcher.include(req, resp);
		}
	}
	
	

}
