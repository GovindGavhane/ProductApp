package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDao;
import com.dto.Product;

@WebServlet("/getAllProduct")
public class GetAllProduct extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 
		ProductDao dao = new ProductDao();
		List<Product> products=dao.getAllProduct();
		System.out.println(products.size());
		if(products.size()>0)
		{
			HttpSession session = req.getSession();
			session.setAttribute("products", products);
			RequestDispatcher dispatcher = req.getRequestDispatcher("viewAll.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			PrintWriter writer = resp.getWriter();
			writer.write("<html><body><h1> No Product present </h1></body></html>");
		}
		
	}
}
