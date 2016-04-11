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
<title>Administration Panel</title>
</head>
<body>
<form action="AdminServlet" method="post">
  		<div class="well" id="film">
  			<div align="center" >
				<div class="form-group">
		    		<label for="exampleInputEmail1">Naziv</label>
		    		<input type="text" class="form-control" name="naziv" placeholder="Naziv"></input>
		  		</div>
		  		<div class="form-group">
		    		<label for="exampleInputEmail1">Opis</label>
		    		<input type="text" class="form-control" name="opis" placeholder="Opis"></input>
		  		</div>
		  		<div class="form-group">
		    		<label for="exampleInputEmail1">Slika</label>
		    		<input type="text" class="form-control" name="slika" placeholder="URL"></input>
		  		</div>
		  		<div class="form-group">
		    		<label for="exampleInputEmail1">Trailer</label>
		    		<input type="text" class="form-control" name="trailer" placeholder="URL"></input>
		  		</div>
		  		<div>
					<input type="submit" class="btn btn-success" name="sacuvajF" value="Sacuvaj" style="width: 150px;" /> </br> 
					<button type="button" class="btn btn-info" data-toggle="modal" data-target="#projekcije" data-whatever="@fat">Projekcije</button>
				</div>
			</div>
  		</div>
	</div>
	
	<div class="modal fade" id="projekcije" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="X"><span aria-hidden="true">&times;</span></button>
		        <label class="control-label">Projekcije</label>
		      </div>
		      <div class="modal-body">
		        <form>
		          <div class="form-group">
		            <label class="control-label">Sala</label>
		            <input type="text" class="form-control" name="sala" placeholder="Sala"></input>
		          </div>
		          <div class="form-group">
		            <label class="control-label">Ukupno mesta</label>
		            <input type="text" class="form-control" name="ukupnoMesta" placeholder="Ukupno mesta"></input>
		          </div>
		          <div class="form-group">
		            <label class="control-label">Slobodna mesta</label>
		            <input type="text" class="form-control" name="slobodnaMesta" placeholder="Slobodna mesta"></input>
		          </div>
		          <div class="form-group">
		            <label class="control-label">Datum i vreme</label>
		          </div>
		        </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Zatvori</button>
		        <input type="submit" class="btn btn-success" name="sacuvaj" value="Sacuvaj" style="width: 150;" /></br>
		      </div>
		    </div>
		  </div>
		</div>
		
</form>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>