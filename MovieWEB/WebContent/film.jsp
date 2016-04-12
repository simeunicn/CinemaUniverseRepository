<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
	<%@include file="bootstrap-3.3.6-dist/css/bootstrap.css" %>
    <%@include file="bootstrap-3.3.6-dist/css/bootstrap-theme.css" %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Detalji</title>
</head>
<body>
<form action="SiteServlet" method="post">
		      <div class="modal-body">
		      	  <div class="modal-footer">
		        	<input type="submit" class="btn btn-danger" name="zatvori" value="Zatvori" style="width: 150;" /></br>
		      	  </div>
		      	  <div class="form-group">
		          	<label class="label label-info">Slika</label><br /><br />
	  				<img src="<c:out value="${film.slikaFilma}"/>" class="img-rounded" width="300" height="400"></img> <br />
		          </div>
		          <div class="form-group">
		            <label class="label label-info">Naziv</label>
		            <label class="control-label"><c:out value="${film.naziv}"/></label>
		          </div>
		          <div class="form-group">
		            <label class="label label-info">Opis</label>
		            <label class="control-label"><c:out value="${film.opis}"/></label>
		          </div>
		          <div class="form-group">
		            <label class="label label-info">Kategorija</label>
		            <label class="control-label"><c:out value="${film.kategorija}"/></label>
		          </div>
		          <div class="form-group">
		            <label class="label label-info">Glumci</label>
		            <table class="table table-condensed">
			      	  	<thead>
						<tr>
							<th>Ime</th>
							<th>Prezime</th>
							<th>Slika</th>
						</tr>
						</thead>
						<c:forEach var="g" items="${film.tim8glumacs}">
	   					<tr>
	   						<td>
	   						<c:out value="${g.ime}"/>	
	   						</td>
	   						<td>
	   						<c:out value="${g.prezime}"/>	
	   						</td>
	   						<td>
	   						<img src="<c:out value="${g.slikaGlumca}"/>	" class="img-rounded" width="100" height="120"></img> <br />
	   						</td>
	   					</tr>
						</c:forEach>
					</table>
		          </div>
		          <div class="modal-footer">
		          	<button type="button" class="btn btn-info" data-toggle="modal" data-target="#komentar" data-whatever="@fat">Dodaj komentar</button>
		      	  	<input type="hidden" name="idFilmaPK" value="<c:out value='${film.filmID}'/>"/>
		      	  	<br />
		      	  	<table class="table table-condensed">
			      	  	<thead>
						<tr>
							<th>Komentar</th>
							<th>Datum</th>
						</tr>
						</thead>
						<c:forEach var="k" items="${film.tim8komentars}">
	   					<tr>
	   						<td>
	   						<c:out value="${k.textKomentara}"/>	
	   						</td>
	   						<td>
	   						<c:out value="${k.datumPostavljanja}"/>	
	   						</td>
	   					</tr>
						</c:forEach>
					</table>
		      	  </div>
		      </div> 
</form>

<form action="SiteServlet" method="post">
		<div class="modal fade" id="komentar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="X"><span aria-hidden="true">&times;</span></button>
		        <label class="control-label">Komentar</label>
		      </div>
		      <div class="modal-body">
		          <div class="form-group">
		            <label class="control-label">Text Komentara</label>
		            <input type="text" class="form-control" name="textKomentara" placeholder="Text"></input>
		          </div><div class="form-group">
		            <label class="control-label">Datum i vreme</label>
		            <input type="text" class="form-control" name="datumKomentara" placeholder="00/00/00-00:00"></input>
		          </div>
		          <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Zatvori</button>
			        <input type="submit" class="btn btn-success" name="sacuvajK" value="Sacuvaj" style="width: 150;" /></br>
			        <input type="hidden" name="idFilmaK" value="<c:out value='${film.filmID}'/>"/>
			      </div>
		      </div> 
		    </div>
		  </div>
		 </div>
</form>





	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>