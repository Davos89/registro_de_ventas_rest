<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de clientes</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/estilos.css " />
</head>
<body>
	<h1>Lista de Clientes</h1>
	<table border="1">
		<tr>

			<th>Nombre</th>



		</tr>

		<c:forEach var="clienteTemp" items="${clientes}">

			<c:url var="linkActualizar"
				value="/cliente/muestraFormularioActualizar">

				<c:param name="clienteId" value="${clienteTemp.id }"></c:param>

			</c:url>
			<c:url var="linkEliminar" value="/cliente/muestraFormularioEliminar">

				<c:param name="clienteId" value="${clienteTemp.id }"></c:param>

			</c:url>

			<tr>
				<td>${clienteTemp.nombre }</td>

				<th><a href="${linkActualizar}"><input type="button"
						value="Modificar"></a></th>
				<th><a href="${linkEliminar}"><input type="button"
						value="Eliminar"
						onclick="if(!confirm('¿Eliminar Registro de cliente ${clienteTemp.nombre} ${clienteTemp.nombre}')) return false"></a></th>

			</tr>

		</c:forEach>


	</table>

	<br>
	<input type="button" value="Agregar Cliente"
		onclick="window.location.href='muestraFormularioAgregar'; return false;" />

</body>
</html>