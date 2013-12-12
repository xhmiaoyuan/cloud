<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LoginController" method="post">
  <p>EmailAddress: 
    <input type="text" name="email"/>
</p>
  <p>Password:
    <input type="text" name="password"/>
  </p>
  <p>
    <input type="reset" name="Reset" value="Reset"/>
    <input type="submit" name="Login" value="Submit"/>
    
  </p>
  <p>
  <a href="register.jsp" name="Register" >Register</a></p>
</form>
</body>
</html>