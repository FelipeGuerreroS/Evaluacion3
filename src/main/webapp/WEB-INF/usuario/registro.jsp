<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h3>Registrar Usuario</h3>
	<form:form method="post" action="/usuario/registrar" modelAttribute="usuario">
		<form:label path="nombre">Nombre</form:label>
		<form:input type="text" path="nombre"/>
		<br>
		<form:label path="apellido">Apellido</form:label>
		<form:input type="text" path="apellido"/>
		<br>
		<form:label path="email">Email</form:label>
		<form:input type="email" path="email"/>
		<br>
		<form:label path="nUsuario">Nombre de Usuario</form:label>
		<form:input type="text" path="nUsuario"/>
		<br>
		<form:label path="password">Password</form:label>
		<form:input type="text" path="password"/>
		<br>
		<input type="submit" value="Submit">
	</form:form>
	</div>
</body>
</html>