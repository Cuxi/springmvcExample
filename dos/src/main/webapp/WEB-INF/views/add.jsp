<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
	<meta charset="utf-8">
	<script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/resources/events2.js"></script>

</head>
<body>
	<h1>Crear contacto:</h1>
	
	<form method="POST" id="formu1" action="/insert/">
		<table>
			<tr>
				<td style="border: solid 1px">Name</td>
				<td style="border: solid 1px">Address</td>
				<td style="border: solid 1px">Email</td>
				<td style="border: solid 1px">Phone</td>
			</tr>
			<tr>
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
