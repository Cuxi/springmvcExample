<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
<head>
	<meta charset="utf-8">
	
</head>
<body>
	<h1>Editar contacto:</h1>
	
	<form method="POST" action="/editar" >
		<table>
			<tr>
				<td style="border: solid 1px"><input hidden name="id" value="${contact.id}">
				</input></td>
				<td style="border: solid 1px"><input name="name">
				</input></td>
				<td style="border: solid 1px"><input name="address">
				</input></td>
				<td style="border: solid 1px"><input name="email">
				</input></td>
				<td style="border: solid 1px"><input name="telephone">
				</input></td>
			</tr>
		</table>
		<input type="submit" id="send" value="Aceptar">
		<input type="submit" id="cancel" value="Cancelar">
	</form>
</body>
</html> 
