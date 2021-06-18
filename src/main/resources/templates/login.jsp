<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/estilos.css " />
</head>
<body>

	<form:form action="principal" modelAttribute="usuario" method="post">
		
		<table>



			<tr>

				<td>nombre:</td>
				<td><form:input path="nombre" /></td>

			</tr>
			<tr>

				<td>password:</td>
				<td><form:input path="password" /></td>

			</tr>

			<tr>

				<td colspan="2"><input type="submit" value="Ingresar"></td>

			</tr>


		</table>

	</form:form>

</body>
</html>