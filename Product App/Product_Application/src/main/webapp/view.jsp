<%@page import="com.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Product product = (Product) session.getAttribute("product"); %>
<% if(product!=null)
	{%>
	 <h1> Id :<%= product.getProductId() %></h1>
	 <h1> Name :<%= product.getProductName() %></h1>
	 <h1> Price :<%= product.getProductPrice() %></h1>
	 <h1> Description : <%= product.getProductDescription() %></h1>
	 <%} %>
</body>
</html>