package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.dto.Product;

@WebServlet("/insertProduct")
public class SaveProduct extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		int id = Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		String description = req.getParameter("description");
	    Product product = new Product();
	    product.setProductId(id);
	    product.setProductName(name);
	    product.setProductPrice(price);
	    product.setProductDescription(description);
	    ProductDao dao = new ProductDao();
	    try
	    {
	      boolean b= dao.saveProduct(product);
	      if(b)
			 { 
				 PrintWriter writer = resp.getWriter();
				 writer.write("<html><body><h1> Something went wrong </h1></body></html>"); 
			
			 }
			 else
			 {
				     PrintWriter writer = resp.getWriter();
					writer.write("<html><body><h1> Product Inserted Successfully </h1></body></html>"); 
			 }
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	
	
	

}
