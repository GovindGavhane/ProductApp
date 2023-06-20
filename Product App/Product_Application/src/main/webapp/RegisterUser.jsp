<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"> Registation Page</h1><br><br>
 
 
 
   <form action="inserUser" method="post" >
  <div align="center">
 Id :    <input type="number" name="userId"><br><br>
UserName :<input type="text" name="userName"><br><br>
PassWord :<input type="password" name="userPassword"><br><br>
Phone    :<input type="tel" name="userPhone"> <br><br>
Email Id : <input type="email" name="userEmail"><br><br>
<input type="submit" value="RegissterUser">
If already Register?<a href="login.jsp" type="button">Login</a></div>
</form>
 

</body>
</html>