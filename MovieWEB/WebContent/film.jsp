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
<title>Detalji</title>
</head>
<body>
	<form action="SiteServlet" method="post">
		<div class="row">
			<div class="col-lg-4">
				<div class="input-group">
					<input type="submit" class="btn btn-danger" name="zatvori"
						value="Nazad" />
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<div class="modal-body" align="center">
			<div class="form-group">
				<img src="<c:out value="${film.slikaFilma}"/>" class="img-rounded"
					width="30%" height="30%"></img> <br />
			</div>

			<div class="form-group" align="left">
				<h4>
					<label class="label label-default">Naziv filma</label>
				</h4>
				<h5>
					<label class="control-label"><c:out value="${film.naziv}" /></label><br />
				</h5>
			</div>
			<div class="form-group" align="left">
				<h4>
					<label class="label label-default">Opis radnje</label>
				</h4>
				<h5>
					<label class="control-label"><c:out value="${film.opis}" /></label>
				</h5>
			</div>
			<div class="form-group" align="left">
				<h4>
					<label class="label label-default">Kategorija filma</label>
				</h4>
				<h5>
					<label class="control-label"><c:out
							value="${film.kategorija}" /></label>
				</h5>
			</div>
			<div class="form-group" align="left">
				<h4>
					<label class="label label-default">Spisak glumaca</label>
				</h4>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th>
								<div class="panel-body">
									<p>Ime</p>
								</div>
							</th>
							<th>
								<div class="panel-body">
									<p>Prezime</p>
								</div>
							</th>
							<th>
								<div class="panel-body">
									<p>Slika glumca</p>
								</div>
							</th>
							<th>
								<div class="panel-body">
									<p>Biografija</p>
								</div>
							</th>
						</tr>
					</thead>
					<c:forEach var="g" items="${film.tim8glumacs}">
						<tr>
							<td>
								<div class="panel-body">
									<p>
										<c:out value="${g.ime}" />
									</p>
								</div>
							</td>
							<td>
								<div class="panel-body">
									<p>
										<c:out value="${g.prezime}" />
									</p>
								</div>
							</td>
							<td>
								<div class="panel-body">
									<p>
										<img src="<c:out value="${g.slikaGlumca}"/>	"
											class="img-rounded"></img>
									</p>
								</div>
							</td>
							<td>
								<div class="panel-body">
									<p>
										<c:out value="${g.biografija}" />
									</p>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="modal-footer" align="center">
				<c:if test="${registrovan}">
					<button type="button" class="btn btn-info" data-toggle="modal"
						data-target="#komentar" data-whatever="@fat">Dodaj
						komentar</button>
				</c:if>
				<input type="hidden" name="idFilmaPK"
					value="<c:out value='${film.filmID}'/>" /> <br />
				<table class="table table-condensed" align="center">
					<thead align="center">
						<tr align="center">
							<th align="center">Komentari</th>
							<th align="center">Datum</th>
						</tr>
					</thead>
					<c:forEach var="k" items="${film.tim8komentars}">
						<tr align="center">
							<td align="center"><c:out value="${k.textKomentara}" /></td>
							<td align="center"><c:out value="${k.datumPostavljanja}" />
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</form>

	<form action="SiteServlet" method="post">
		<div class="modal fade" id="komentar" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel1">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="X">
							<span aria-hidden="true">&times;</span>
						</button>
						<label class="control-label">Komentar</label>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label class="control-label">Text Komentara</label> <input
								type="text" class="form-control" name="textKomentara"
								placeholder="Text"></input>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Zatvori</button>
							<input type="submit" class="btn btn-success" name="sacuvajK"
								value="Sacuvaj" style="width: 150;" /></br> <input type="hidden"
								name="idFilmaK" value="<c:out value='${film.filmID}'/>" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>





	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>