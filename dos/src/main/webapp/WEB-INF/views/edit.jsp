<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta charset="utf-8">
	
</head>
<body>
	<h1>Editar contacto:</h1>
	
	<form:form method="POST" action="/editar/" commandName="contactEdit">
		<table>
			<tr>
				<td style="border: solid 1px"><form:input hidden path="id" value="${contact.id}">
				</input></td>
				<td style="border: solid 1px"><form:input path="name">
				</input></td>
				<td style="border: solid 1px"><form:input path="address">
				</input></td>
				<td style="border: solid 1px"><form:input path="email">
				</input></td>
				<td style="border: solid 1px"><form:input path="telephone">
				</input></td>
			</tr>
		</table>
		<input type="submit" id="send" value="Aceptar">
		<input type="submit" id="cancel" value="Cancelar">
	</form:form>
</body>
</html> 
