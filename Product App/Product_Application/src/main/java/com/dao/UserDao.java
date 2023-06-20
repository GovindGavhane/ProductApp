package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.User;

public class UserDao {
	
	
	public Connection getConnection()throws Exception
	{
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_application","root","root");
	    return con;
	}
	
	 public boolean saveUser(User user)throws Exception
	 {
		 int id = user.getUserId();
		 String name = user.getUserName();
		 String password = user.getUserPassword();
		 String phone = user.getUserPhone();
		 String email = user.getUserEmail();
		 PreparedStatement ps = getConnection().prepareStatement("insert into user values(?,?,?,?,?)");
		 ps.setInt(1, id);
		 ps.setString(2, name);
		 ps.setString(3, password);
		 ps.setString(4, email);
		 ps.setString(5, phone);
		 boolean b = ps.execute();
		 return b;
	 }
	 
	 public User verifyUser(String name , String password)
	 {
		 try
		 {
		 PreparedStatement ps = getConnection().prepareStatement("select * from user where name=? and password=?");
		 ps.setString(1, name);
		 ps.setString(2, password);
		 ResultSet r = ps.executeQuery();
		 if(r.next())
		 {
			 User user = new User();
			 user.setUserId(r.getInt(1));
			 user.setUserName(r.getString(2));
			 user.setUserPassword(r.getString(3));
			 user.setUserEmail(r.getString(4));
			 user.setUserPhone(r.getString(5));
			 return user;
		 }
		  
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return null;
	 }

}
