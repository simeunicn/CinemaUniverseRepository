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
  			<div class="col-lg-4">
    			<div class="input-group">
    				<input type="submit" class="btn btn-danger" name="logout" value="${nazivKomponente}"/>
    			</div><!-- /input-group -->
  			</div><!-- /.col-lg-4 -->
		</div><!-- /.row -->
		<br /><br />
		
		
		<div align="center" >
			<div class="input-group" style="width: 500px;" >
    			<input type="text" class="form-control" placeholder="Zanr..." name="inputpretraga"/>
    			<div class="input-group-btn">
        			<input type="submit" class="btn btn-info" name="pretraga" value="Pretrazi filmove"/>
        		</div>
  			</div>
		</div>
		<br /><br />
		
		<div align="center" >
			<div class="input-group" style="width: 500px;" >
    			<div class="form-group">
    				<h3><span class="label label-warning">${poruka}</span></h3>
  				</div>
  			</div>
		</div>
		<br /><br />
		
		
		<div class="btn-group">
  			<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width: 150px;" > Filteri <span class="caret"></span></button>
			<ul class="dropdown-menu" style="width: 250px;" >
				<li>
					<a href="#"><input type="submit" class="btn btn-info" name="prikazi" value="Pregledaj sve projekcije" style="width: 220px;"/></a>
				</li>
				<li>
					<a href="#">
						<input type="submit" class="btn btn-info" name="prikazinajbolje" value="Pregledaj najbolje projekcije" style="width: 220px;"/>
					</a>
				</li>
				<li>
					<a href="#">
						<c:if test="${radnik}">
								<button type="button" class="btn btn-info" data-toggle="modal" data-target="#filter" data-whatever="@fat" style="width: 220px;">Ostali filteri</button>
						</c:if>
					</a>
				</li>
			</ul>
		</div>
		<br /><br />
		
		</form>
		<table class="table table-condensed">
		<thead>
			<tr>
				<th>Film</th>
				<th>Sala</th>
				<th>Tip projekcije</th>
				<th>Cena karte</th>
				<th>Vreme projekcije</th>
				<th>Ukupno mesta</th>
				<th>Preostalo mesta</th>
				<c:if test="${registrovan}">
					<th>Broj karata za rezervaciju</th>
				</c:if>
				<c:if test="${radnik}">
					<th>Broj karata za prodaju</th>
				</c:if>
				<th>Prosecna ocena</th>
				<c:if test="${registrovan}">
					<th>Ocena</th>
				</c:if>
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
	   			<c:out value="${p.tipProjekcije}"/>	
	   		</td>
	   		<td>
	   			<c:out value="${p.cena}"/>	
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
	   		<c:if test="${registrovan}">
	   			<td border: 1px>
	   				<input type="text" name="brojkarata"/><input type="submit" class="btn btn-warning" name="reserve" value="Rezervisi karte" style="margin-left: 20px;"/>
	   			</td>
	   		</c:if>
	   		<c:if test="${radnik}">
	   			<td>
	   				<input type="text" name="brojkarata"/><input type="submit" class="btn btn-warning" name="prodaj" value="Prodaj karte" style="margin-left: 20px;"/>
	   			</td>
	   		</c:if>
	   		<td>
   				<fmt:parseNumber var="i" type="number" value="${p.prosecnaOcena}" />
				<p><c:out value="${p.prosecnaOcena}"/></p>
	   		</td>
	   		<c:if test="${registrovan}">
	   			<td>
   					<div class="btn-group" data-toggle="buttons">
	  					<label class="btn btn-primary active">
	    					<input type="radio" name="ocena" id="option1" autocomplete="off" value="1">1</input>
	  					</label>
						<label class="btn btn-primary">
						    <input type="radio" name="ocena" id="option2" autocomplete="off" value="2">2</input>
						</label>
						<label class="btn btn-primary">
						    <input type="radio" name="ocena" id="option3" autocomplete="off" value="3">3</input>
						</label>
						<label class="btn btn-primary">
						    <input type="radio" name="ocena" id="option3" autocomplete="off" value="4">4</input>
						</label>
						<label class="btn btn-primary">
						    <input type="radio" name="ocena" id="option3" autocomplete="off" value="5">5</input>
						</label>
					</div>
	   			</td>
	   			<td>
	   				<input type="submit" class="btn btn-warning" name="sacuvajO" value="Sacuvaj ocenu" style="width: 150;" /></br>
	   			</td>
	   		</c:if>
	   		<td>
		   		<input type="submit" class="btn btn-info" name="pogledajF" value="Detalji" style="width: 150;" /></br>
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
	
	
	
	
	<form action="SiteServlet" method="post">
		<div class="modal fade" id="filter" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="X"><span aria-hidden="true">&times;</span></button>
		        <label class="control-label">Filter</label>
		      </div>
		      <div class="modal-body">
		          <div class="form-group">
		            <label class="control-label">Broj mesta vise od:</label>
		            <input type="text" class="form-control" name="brojMesta" placeholder="Broj mesta..." value="Broj mesta..."></input>
		          </div>
		          <div class="form-group">
		            <label class="control-label">Cena projekcije manje od:</label>
		            <input type="text" class="form-control" name="cenaKarata" placeholder="Cena..." value="Cena..."></input>
		          </div>
		          <div class="modal-footer">
		        	<button type="button" class="btn btn-default" data-dismiss="modal">Zatvori</button>
		        	<input type="submit" class="btn btn-success" name="filtriraj" value="Filtriraj" style="width: 150;" /></br>
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