<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página Principal</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/estilosPrincipal.css " />
</head>
<body>

<div>
	<h1>Página Principal</h1><br><br><br>
	
	<c:url var="linkAgregarCliente" value="/registro/agregarCliente"></c:url>
	<c:url var="linkVerClientes" value="/registro/verClientes"></c:url>
	
	<c:url var="linkAgregarMercaderia" value="/registro/agregarMercaderia"></c:url>
	
	<c:url var="linkAgregarVentas" value="/registro/agregarVentas"></c:url>
	<c:url var="linkVerVentas" value="/registro/verVentas"></c:url>
	
	<a href="${linkAgregarCliente }">-Agregar un Cliente</a>			<a href="${linkVerClientes }">-Ver los Clientes</a><br>
	<a href="${linkAgregarMercaderia }">-Agregar una Mercadería</a><br>
	<a href="${linkAgregarVentas }">-Agregar Ventas</a>					<a href="${linkVerVentas }">-Ver Ventas</a><br><br>
	
</div>

</body>
</html>