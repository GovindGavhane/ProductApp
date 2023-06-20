package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDao;
import com.dto.Product;

@WebServlet("/getProduct")
public class GetProduct extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		int id = Integer.parseInt(req.getParameter("id"));
		ProductDao dao = new ProductDao();
		 Product product =dao.getProduct(id);
		 if(product!=null)
		 {
			 HttpSession session = req.getSession();
			 session.setAttribute("product", product);
			 RequestDispatcher dispatcher = req.getRequestDispatcher("view.jsp");
			 dispatcher.forward(req, resp);
		 }
		 else
		 {
			 PrintWriter writer = resp.getWriter();
			 writer.write("<html><body><h1>with Id product does not Exist</h1></body></html>");
		 }
		 
		
	}

}
