<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<body>
	<h1>Contactos almacenados.</h1>
	<p>Name: ${contact.name}</p>
	<p>Mail: ${contact.email}</p>
	<p>Address: ${contact.address}</p>
	<p>Phone: ${contact.telephone}</p>

	<form method="GET" action="/employee">
		<input type="submit" value="Aceptar">
	</form>
</body>
</html> 
