<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<a href="site.jsp">Home</a>
	<p>Naziv: ${film.naziv} </p>
	<p>Opis : ${film.opis}</p>
	<p>Kategorije: 
		<c:forEach items="${film.kategorijas}" var="i" >
				{$i.opisKategorije} 
		</c:forEach>
	</p>
	<p>
		<c:forEach var="g" items="${film.glumacs}">
			{$g.ime} {$g.prezime}
		</c:forEach>
	</p>
	<p>
		<c:forEach var="k" items="${film.komentars}">
			<p>
			{$k.textKomentara} </br>
			{$k.datumPostavljanja}</br>
			</p>
		</c:forEach>
	</p>
</body>
</html>