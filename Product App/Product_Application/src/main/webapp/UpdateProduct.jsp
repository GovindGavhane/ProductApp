<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Update the Existing Product</h1>
<form action="updateProduct" method="post">
<div align="center">
Enter the Id For Update Product : <input type="number" name="id"><br><br>
ProductName : <input type="text" name="name"><br><br>
ProductPrice :<input type="number" name="price"><br><br>
ProductDescription :<br><textarea rows="4" cols="50" name="description"></textarea><br><br>
<input type="submit" value="Update Product"></div>
</form>

</body>
</html>