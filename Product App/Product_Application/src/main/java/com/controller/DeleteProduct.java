package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		this.doDelete(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id = Integer.parseInt(req.getParameter("id"));
		 ProductDao dao = new ProductDao();
		 try {
		   int i = dao.deleteProduct(id);
		   PrintWriter writer = resp.getWriter();
			 writer.write("<html><body><h1> Product Deleted Successfully </h1></body></html>");
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}
	
	

}
