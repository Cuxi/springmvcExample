<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta charset="utf-8">

</head>
<body>
	<h1>Crear contacto:</h1>
	
	<form:form method="POST" action="/insert" commandName="contactInsert">
		<table>

			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="telephone">Telephone</form:label></td>
				<td><form:input path="telephone" /></td>
			</tr>
			<tr>
				<td colspan="2">
				    	<input type="submit" value="Submit"/>
				</td>
				<td colspan="2">
					<input type="submit" id="cancel" value="Cancelar"/>
				</td>
			</tr>
	</form:form>
</body>
</html> 
