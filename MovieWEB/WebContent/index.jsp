<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
	<%@include file="bootstrap-3.3.6-dist/css/bootstrap.css" %>
    <%@include file="bootstrap-3.3.6-dist/css/bootstrap-theme.css" %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Welcome</title>
</head>
<body>
	<form action="LoginServlet" method="post">
	<br /><br /><br /><br /><br />
		<div align="center" >
			<div class="form-group" style="width: 300px;" >
    			<label class="sr-only" for="exampleInputEmail3">Username</label>
   				<input type="text" class="form-control" name="username" placeholder="Username"></input>
  			</div>
		  	<div class="form-group" style="width: 300px;" >
		    	<label class="sr-only" for="exampleInputPassword3">Password</label>
		    	<input type="password" class="form-control" name="password" placeholder="Password"></input>
		  	</div>
		  	<div>
				<input type="submit" class="btn btn-primary" name="login" value="Login" style="width: 150px;" /> </br> 
				<input type="submit" class="btn btn-info" name="register" value="Registracija" style="width: 150;" /></br> 
				<input type="submit" class="btn btn-link" name="continue" value="Nastavi" style="width: 150;" /></br>
			</div>
		</div>
	</form>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>