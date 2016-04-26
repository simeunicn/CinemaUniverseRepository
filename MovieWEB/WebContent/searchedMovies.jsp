<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<style type="text/css">
	<%@include file="bootstrap-3.3.6-dist/css/bootstrap.css" %>
    <%@include file="bootstrap-3.3.6-dist/css/bootstrap-theme.css" %>
</style>
<title>Searched movies</title>
</head>
<body>
<table class="table table-condensed">
		<thead>
			<tr>
				<th>Naziv filma</th>
				<th>Opis filma</th>
				<th>Kategorija filma</th>
				<th></th>
				<th></th>
			</tr>
			
		</thead>
<c:forEach var="p" items="${filmovi}">
		<form action="SiteServlet" method="post">
	   	<tr>
	   		<td>
	   			<c:out value="${p.naziv}"/>	
	   		</td>
	   		<td>
	   			<c:out value="${p.opis}"/>	
	   		</td>
	   		<td>
	   			<c:out value="${p.kategorija}"/>	
	   		</td>
	   		<td>
		   		<input type="submit" class="btn btn-link" name="pogledajF" value="Detalji" style="width: 150;" /></br>
	   		</td>
	   		<td>
	   			<input type="hidden" id="idFilma" name="idFilma" value="${p.filmID}" style="width: 150;" /></br>
	   		</td>
	   	</tr>
	   	</form>
		</c:forEach>
		</table>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>