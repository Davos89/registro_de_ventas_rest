<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form:form action="insertaCliente" modelAttribute="cliente" method="post">
		
		<table>



			<tr>

				<td>nombre:</td>
				<td><form:input path="nombre" /></td>
				<form:errors path="nombre" style="color:red"></form:errors>

			</tr>
			

			<tr>

				<td colspan="2"><input type="submit" value="Agregar Cliente"></td>

			</tr>


		</table>

	</form:form>
</body>
</html>