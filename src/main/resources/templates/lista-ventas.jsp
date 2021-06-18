<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de ventas</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/estilos.css " />
<link type=""/>

<script type="text/javascript">

function clientes() {
	var x = document.getElementById("mySelect").value;
	
	window.location.href='buscarPorCliente?idCliente='+x; 
	return false;
}

function buscarPorFecha() {
	var x = document.getElementById("myDateSelect").value;
	
	window.location.href='buscarPorFecha?fecha='+x; 
	return false;
}

</script>
</head>
<body>
	<h1>Ventas</h1>




	<aside>
	<!-- buscador de ventas por cliente -->
		<blockquote>Buscar por Cliente:</blockquote>
		<blockquote>
			<select id="mySelect" name="clientes" onchange="clientes()">
				<c:forEach var="clienteTemp" items="${clientes}">
					<option value="${clienteTemp.id }" label="${clienteTemp.nombre }"></option>
				</c:forEach>
			</select>
			
		</blockquote>
		
		<!-- buscador de ventas por fecha -->
		<blockquote>Buscar por fecha</blockquote>
		<blockquote><input id="myDateSelect" type="date" name="fecha" onchange="buscarPorFecha()"/></blockquote>
		<input type="button" value="Agregar venta"
			onclick="window.location.href='registro/agregarVentas'; return false;" />
	</aside>


	<table border="1">
		<tr>

			<th>Cliente</th>
			<th>Mercadería</th>
			<th>Unidades</th>
			<th>Precio Unitario</th>
			<th>Vendedor</th>
			<th>Fecha</th>



		</tr>

		
		<c:forEach var="ventaTemp" items="${ventas}">

			<c:url var="linkActualizar"
				value="/venta/muestraFormularioActualizar">

				<c:param name="ventaId" value="${ventaTemp.id }"></c:param>

			</c:url>
			<c:url var="linkEliminar" value="/venta/muestraFormularioEliminar">

				<c:param name="ventaId" value="${ventaTemp.id }"></c:param>

			</c:url>
			<tr>
				<td>${ventaTemp.cliente.nombre }</td>
				<td>${ventaTemp.mercaderia.nombre }</td>
				<td>${ventaTemp.unidades }</td>
				<td>${ventaTemp.precioUnitario }</td>
				<td>${ventaTemp.vendedor.nombre }</td>
				<td>${ventaTemp.fecha.getDayOfMonth()}-${ventaTemp.fecha.getMonth()}-${ventaTemp.fecha.getYear()}</td>

				<th><a href="${linkActualizar}"><input type="button"
						value="Modificar"></a></th>
				<th><a href="${linkEliminar}"><input type="button"
						value="Eliminar"
						onclick="if(!confirm('¿Eliminar Registro de cliente')) return false"></a></th>

			</tr>

		</c:forEach>
		
		
		
		

	</table>

	<br>



</body>
</html>