<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<table>
	<thead>
		<tr>
			<th>Film</th>
			<th>Sala</th>
			<th>Vreme projekcije</th>
			<th>Ukupno mesta</th>
			<th>Preostalo mesta</th>
			
		</tr>
		
	</thead>
	<c:forEach var="i" items="${projectList}">
   	
   	<tr>
   		
   		<td>
   		<c:out value="${i.tim8film.naziv}"/>	
   		</td>
   		<td>
   			<c:out value="${i.sala}"/>	
   		</td>
   		<td>
   			<c:out value="${i.vreme}"/>	
   		</td>
   		<td>
   			<c:out value="${i.ukupanbrmesta}"/>	
   		</td>
   		<td>
   			<c:out value="${i.preostalaMesta}"/>
   		</td>
   		<td>
			<form action="FilmServlet" method="get">
	   			<input type="submit" value="Pogledaj film"/>
	   			<input type="hidden" value="<c:out value='${i.film.filmID}'/>"/>
	   		</form>
   		</td>
   	</tr>
	</c:forEach>
	</table>
</body>
</html>