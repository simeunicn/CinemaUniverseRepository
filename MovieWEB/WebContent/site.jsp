<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
	<%@include file="bootstrap-3.3.6-dist/css/bootstrap.css" %>
    <%@include file="bootstrap-3.3.6-dist/css/bootstrap-theme.css" %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Movie site</title>
</head>
<body>
	<form action="SiteServlet" method="post">
		<div class="row">
  			<div class="col-lg-6">
    			<div class="input-group">
    			<input type="submit" class="btn btn-danger" name="logout" value="${nazivKomponente}"/>
      				<span class="input-group-btn">
        			<input type="submit" class="btn btn-info" name="prikazi" value="Pregledaj sve"/>
      				</span>
    			</div><!-- /input-group -->
  			</div><!-- /.col-lg-6 -->
  			<div class="col-lg-6">
    			<div class="input-group">
      				<input type="text" class="form-control" placeholder="Pretrazi...">
      				<span class="input-group-btn">
        				<input type="submit" class="btn btn-info" name="pretraga" value="Pretrazi"/>
      				</span>
    			</div><!-- /input-group -->
  			</div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
	
		<br /><br /><br />
	
		<table class="table table-condensed">
		<thead>
			<tr>
				<th>Film</th>
				<th>Sala</th>
				<th>Vreme projekcije</th>
				<th>Ukupno mesta</th>
				<th>Preostalo mesta</th>
				<th></th>
				<th></th>
			</tr>
			
		</thead>
		<c:forEach var="p" items="${projekcije}">
	   	<tr>
	   		<td>
	   			<c:out value="${p.tim8film.naziv}"/>	
	   		</td>
	   		<td>
	   			<c:out value="${p.sala}"/>	
	   		</td>
	   		<td>
	   			<c:out value="${p.vreme}"/>	
	   		</td>
	   		<td>
	   			<c:out value="${p.ukupanbrmesta}"/>	
	   		</td>
	   		<td>
	   			<c:out value="${p.preostalaMesta}"/>
	   		</td>
	   		<td>
		   		<input type="submit" class="btn btn-link" name="pogledajF" value="Detalji" style="width: 150;" /></br>
	   		</td>
	   		<td>
	   			<input type="hidden" id="idFilma" name="idFilma" value="${p.tim8film.filmID}" style="width: 150;" /></br>
	   		</td>
	   	</tr>
		</c:forEach>
		</table>
	</form>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>