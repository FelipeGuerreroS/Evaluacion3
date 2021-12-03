<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Producto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h3>Editar Producto</h3>
	<form:form method="post" action="/producto/update" modelAttribute="editarProducto">
		<form:label path="nombre">Nombre</form:label>
		<form:input type="text" path="nombre"/>
		<br>
		<form:label path="marca">Marca</form:label>
		<form:input type="text" path="marca"/>
		<br>
		<form:label path="descripcion">Descripcion</form:label>
		<form:input type="text" path="descripcion"/>
		<br>
		<form:label path="precio">Precio</form:label>
		<form:input type="text" path="precio"/>
		<br>
		<form:select class="form-select" path="categoria">
				<c:forEach var="categoria" items="${listaCategorias}">
					<form:option value="${categoria.getId()}">${categoria.getNombre()}</form:option>
				</c:forEach>
			</form:select>
		<br>
		<input type="submit" value="Submit">
	</form:form>
	</div>
</body>
</html>