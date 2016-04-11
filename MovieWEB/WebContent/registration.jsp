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
<title>Registration</title>
</head>
<body>
	<form action="RegisterServlet" method="post">
	<div align="center" >
		<div class="form-group">
    		<label for="exampleInputEmail1">Username</label>
    		<input type="text" class="form-control" name="username" placeholder="Username">
  		</div>
  		<div class="form-group">
    		<label for="exampleInputPassword1">Password</label>
    		<input type="password" class="form-control" name="password" placeholder="Password">
  		</div>
  		<div class="form-group">
    		<label for="exampleInputEmail1">Ime</label>
    		<input type="text" class="form-control" name="ime" placeholder="Ime">
  		</div>
  		<div class="form-group">
    		<label for="exampleInputEmail1">Prezime</label>
    		<input type="text" class="form-control" name="prezime" placeholder="Prezime">
  		</div>
  		<div class="form-group">
    		<label for="exampleInputEmail1">Email</label>
    		<input type="text" class="form-control" name="email" placeholder="Email">
  		</div>
  		<div>
			<input type="submit" class="btn btn-success" name="register" value="Registracija" style="width: 150;" /></br> 
			<input type="submit" class="btn btn-danger" name="cancel" value="Odustani" style="width: 150;" /></br>
		</div>
	</div>
	</form>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>