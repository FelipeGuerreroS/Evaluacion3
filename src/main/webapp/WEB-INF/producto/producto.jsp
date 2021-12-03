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
	<h3>Agregar Producto</h3>
	<form:form method="post" action="/producto/crear" modelAttribute="producto">
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
		<form:label path="categoria">Categoria
		<form:select class="form-select" path="categoria">
				<c:forEach var="categoria" items="${listaCategorias}">
					<form:option value="${categoria.getId()}">${categoria.getNombre()}</form:option>
				</c:forEach>
			</form:select>
			</form:label>
		<input type="submit" value="Submit">
	</form:form>
	
	<br>
	<hr>
	
	<table class="table">
		<thead>
		  <tr>
			<th scope="col">#</th>
			<th scope="col">Nombre</th>
			<th scope="col">Marca</th>
			<th scope="col">Descripcion</th>
			<th scope="col">Precio</th>
			<th scope="col">Categoria</th>
		  </tr>
		</thead>
		<tbody>
				<c:forEach items="${listaProductos}" var="producto" >
				  <tr>
					<th scope="row">${producto.getId()}</th>
					<td>${producto.getNombre()}</td>
					<td>${producto.getMarca()}</td>
					<td>${producto.getDescripcion()}</td>
					<td>${producto.getPrecio()}</td>
					<td>${producto.getCategoria().getNombre()}</td>
					<td>
						<form action="/producto/eliminar" method="get">
						<input type="hidden" name="id" value="${producto.getId()}">
						<input type="submit" value="X">
						</form>
						<form action="/producto/editar" method="get">
							<input type="hidden" name="id" value="${producto.getId()}">
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