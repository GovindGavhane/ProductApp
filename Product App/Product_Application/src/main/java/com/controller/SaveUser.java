package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dto.User;

@WebServlet("/inserUser")
public class SaveUser extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id =  Integer.parseInt(req.getParameter("userId"));
		 String name = req.getParameter("userName");
		 String password = req.getParameter("userPassword");
		 double phone = Double.parseDouble(req.getParameter("userPhone"));
		 String email = req.getParameter("userEmail");
		 User user = new User();
		 user.setUserId(id);
		 user.setUserName(name);
		 user.setUserPassword(password);
		 user.setUserEmail(email);
		 user.setUserPhone(email);
		 UserDao dao = new UserDao();
		 
		 try
		 {
			 boolean  b = dao.saveUser(user);
			 if(b)
			 { 
				 PrintWriter writer = resp.getWriter();
				 writer.write("<html><body><h1> Something went wrong </h1></body></html>"); 
			
			 }
			 else
			 {
				     PrintWriter writer = resp.getWriter();
					writer.write("<html><body><h1> User Inserted Successfully </h1></body></html>"); 
			 }
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
 
	}

}
