<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nueva Mercadería</title>
</head>
<body>

<c:url var="linkBack" value="/registro/principal"></c:url>
		
		<a href="${linkBack }">Página Principal</a>

 <form:form action="insertaMercaderia" modelAttribute="mercaderia" method="post">
		
		<table>



			<tr>

				<td>nombre:</td>
				<td><form:input path="nombre" /></td>

			</tr>
			

			<tr>

				<td colspan="2"><input type="submit" value="Agregar Mercadería"></td>

			</tr>


		</table>

	</form:form>
</body>
</html>