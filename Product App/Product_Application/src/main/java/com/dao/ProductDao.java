package com.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.dto.Product;

public class ProductDao extends HttpServlet{
	
	public boolean saveProduct(Product product)throws Exception
	{
		 
		UserDao dao = new UserDao();
		PreparedStatement ps = dao.getConnection().prepareStatement("insert into product values(?,?,?,?)");
		ps.setInt(1, product.getProductId());
		ps.setString(2, product.getProductName());
		ps.setDouble(3, product.getProductPrice());
		ps.setString(4, product.getProductDescription());
		boolean b = ps.execute();
		return b;		
	}
	
	public int updateProduct(Product product)throws Exception {
		UserDao dao = new UserDao();
		PreparedStatement ps = dao.getConnection().prepareStatement("update product set name=?,price=?,description=? where id=?");
		ps.setString(1, product.getProductName());
		ps.setDouble(2, product.getProductPrice());
		ps.setString(3, product.getProductDescription());
		ps.setInt(4, product.getProductId());
		int a = ps.executeUpdate();
		return a;
	}
	public int deleteProduct(int id)throws Exception
	{
		UserDao dao = new UserDao();
		PreparedStatement sp = dao.getConnection().prepareStatement("delete from product where id=?");
		 sp.setInt(1, id);
		int a= sp.executeUpdate();
		return a;
	}
	
	public Product getProduct(int id)
	{
		try
		{
		UserDao dao = new UserDao();
		PreparedStatement ps = dao.getConnection().prepareStatement("select * from product where id=?");
		ps.setInt(1, id);
		ResultSet r = ps.executeQuery();
		Product product = new Product();
		while(r.next())
		{
			
			product.setProductId(r.getInt(1));
			product.setProductName(r.getString(2));
			product.setProductPrice(r.getDouble(3));
			product.setProductDescription(r.getString(4));
		}
		return product;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
   public List<Product> getAllProduct()
   {
	   try
	   {
	   UserDao dao = new UserDao();
	   PreparedStatement ps = dao.getConnection().prepareStatement("select * from Product");
	   ResultSet s = ps.executeQuery();
	   ArrayList<Product> list = new ArrayList<Product>();
	   ResultSetMetaData rsmd = s.getMetaData();
	   while(s.next())
	   {
		    Product product = new Product();
		    product.setProductId(s.getInt(1));
		    product.setProductName(s.getString(2));
		    product.setProductPrice(s.getDouble(3));
		    product.setProductDescription(s.getString(4));
		    list.add(product);
	   }
	   return list;
	   }catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return null;
   }
   
}
