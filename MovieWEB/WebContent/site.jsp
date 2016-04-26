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
      				<input type="submit" class="btn btn-info" name="prikazinajbolje" value="Pregledaj najbolje projekcije"/>
      				</span>
    			</div><!-- /input-group -->
  			</div><!-- /.col-lg-6 -->
  			<div class="col-lg-6">
    			<div class="input-group">
      				<input type="text" class="form-control" placeholder="Pretrazi..." name="inputpretraga">
      				<span class="input-group-btn">
        				<input type="submit" class="btn btn-info" name="pretraga" value="Pretrazi"/>
      				</span>
    			</div><!-- /input-group -->
  			</div><!-- /.col-lg-6 -->
  			
		</div><!-- /.row -->
	
		<br /><br /><br />
		</form>
		<table class="table table-condensed">
		<thead>
			<tr>
				<th>Film</th>
				<th>Sala</th>
				<th>Vreme projekcije</th>
				<th>Ukupno mesta</th>
				<th>Preostalo mesta</th>
				<th>Ocena</th>
				<th>Prosecna ocena</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			
		</thead>
		<c:forEach var="p" items="${projekcije}">
		<form action="SiteServlet" method="post">
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
	   			<div class="btn-group" data-toggle="buttons">
  					<label class="btn btn-primary active">
    					<input type="radio" name="ocena" id="option1" autocomplete="off" value="1">1
  					</label>
					<label class="btn btn-primary">
					    <input type="radio" name="ocena" id="option2" autocomplete="off" value="2">2
					</label>
					<label class="btn btn-primary">
					    <input type="radio" name="ocena" id="option3" autocomplete="off" value="3">3
					</label>
					<label class="btn btn-primary">
					    <input type="radio" name="ocena" id="option3" autocomplete="off" value="4">4
					</label>
					<label class="btn btn-primary">
					    <input type="radio" name="ocena" id="option3" autocomplete="off" value="5">5
					</label>
				</div>
	   		</td>
	   		<td>
	   			<fmt:parseNumber var="i" type="number" value="${p.prosecnaOcena}" />
				<p><c:out value="${p.prosecnaOcena}"/></p>
	   			
	   		</td>
	   		<td>
	   			<input type="submit" class="btn btn-link" name="sacuvajO" value="Sacuvaj ocenu" style="width: 150;" /></br>
	   		</td>
	   		<td>
		   		<input type="submit" class="btn btn-link" name="pogledajF" value="Detalji" style="width: 150;" /></br>
	   		</td>
	   		<td>
	   			<input type="hidden" id="idProjekcije" name="idProjekcije" value="${p.projekcijaID}" style="width: 150;" /></br>
	   		</td>
	   		<td>
	   			<input type="hidden" id="idFilma" name="idFilma" value="${p.tim8film.filmID}" style="width: 150;" /></br>
	   		</td>
	   	</tr>
	   	</form>
		</c:forEach>
		</table>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>