<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"> Enter the Product Details</h1><br><br>
  <form action="insertProduct" method="post">
  <div align="center">
Product Id : <input type="number" name="id"><br><br>
Product Name : <input type="text" name="name"><br><br>
 Product Price : <input type="number" name="price"><br><br>
  Product Description : <br><textarea rows="4" cols="50" name="description"></textarea><br><br>
  <input type="submit" value="Save Product">
  </div>
  </form>
</body>
</html>