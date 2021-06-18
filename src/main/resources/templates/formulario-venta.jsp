<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar ventas</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/estilos.css " />
</head>
<body>



	<form:form action="insertaVenta" modelAttribute="venta" method="post">

		<table border="1">

			<tr>

				<th id="clienteCell">Cliente</th>
				<th id="mercaderiaCell">Mercadería</th>
				<th id="unidadesCell">Unidades</th>
				<th id="precioCell">Precio Unitario</th>
				<th id="vendedorCell">Vendedor</th>
				<th id="fechaCell">Fecha</th>

			</tr>

			<tr>
				<td><form:select path="idCliente">

						<form:options items="${clientes}" itemValue="id"
							itemLabel="nombre" />
					</form:select></td>

				<td><form:select path="idMercaderia">

						<form:options items="${mercaderias}" itemValue="id"
							itemLabel="nombre" />
					</form:select></td>

				<td><form:select path="unidades">
						<form:option value="0" label="Unidades" />

						<form:option value="1" label="1" />
						<form:option value="2" label="2" />
						<form:option value="3" label="3" />
						<form:option value="4" label="4" />
						<form:option value="5" label="5" />

					</form:select></td>

				<td><form:input path="precioUnitario" title="$ por Unidad" /></td>

				<td><form:select path="idVendedor">

						<form:options items="${vendedores}" itemValue="id"
							itemLabel="nombre" />
					</form:select></td>

				<td><form:input type="date" name="fecha" path="fecha" /></td>
			</tr>
			<tr>

				<td colspan="2"><input type="submit" value="Agregar Ventas"></td>

			</tr>

		</table>

	</form:form>







</body>
</html>