<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<jsp:include page='../template/navbar.jsp'/>
	<div class="container">
	<h3>Agregar Categoria</h3>
	<form:form method="post" action="/categoria/registrar" modelAttribute="categoria">
		<form:label path="nombre">Nombre</form:label>
		<form:input type="text" path="nombre"/>
		<br>
		<form:label path="descripcion">Descripcion</form:label>
		<form:input type="text" path="descripcion"/>
		<br>
		<input type="submit" value="Submit">
	</form:form>
	
	<br>
	<hr>

	<table class="table">
		<thead>
		  <tr>
			<th scope="col">#</th>
			<th scope="col">Nombre</th>
			<th scope="col">Descripcion</th>
		  </tr>
		</thead>
		<tbody>
				<c:forEach items="${listaCategorias}" var="categoria" >
				  <tr>
					<th scope="row">${categoria.getId()}</th>
					<td>${categoria.getNombre()}</td>
					<td>${categoria.getDescripcion()}</td>
					<td>
						<form action="/categoria/eliminar" method="get">
						<input type="hidden" name="id" value="${categoria.getId()}">
						<input type="submit" value="X">
						</form>
						<form action="/categoria/editar" method="get">
							<input type="hidden" name="id" value="${categoria.getId()}">
							<input type="submit" value="Editar">
							</form>
						</td>
				  </tr>
		  </c:forEach>
		</tbody>
	  </table>
	</div>
</body>
</html>