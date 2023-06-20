<%@page import="com.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<Product> product = (List) session.getAttribute("products"); %>
  <% if(product.size()>0)
	  {%>
	<%  
	for(int i=0;i<product.size();i++)
	{
	Product p = product.get(i);
	   { %> 
	<h1> ID : <%= p.getProductId() %></h1>
	<h1> Name : <%= p.getProductName() %></h1>
	<h1> Price : <%= p.getProductPrice() %></h1>
	<h1> Description : <%= p.getProductDescription() %></h1><br><br>  
	 
	 <%} %>  
	   <% }%>
	   <%} %>
</body>
</html>