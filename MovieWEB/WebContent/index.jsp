<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Welcome</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		Username: <input type="text" name="username"/> </br>
		Password: <input type="password" name="password"/> </br> </br>
		<input type="submit" name="login" value="Login" style="width: 220px; "/> </br>
		<input type="submit" name="register" value="Register" style="width: 220px; "/> </br>
		<input type="submit" name="continue" value="Continue as unregistered visitor" style="width: 220px; "/> </br>
	</form>
</body>
</html>