<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<body>
	<h1>Contactos almacenados.</h1>
	<p>Acción correcta, eliminado ${filas} resultado.</p>
	<p>Eliminado:</p>
	 <p>${contact.name}</p>
	 <p>${contact.email}</p>
	 <p>${contact.address}</p>
	 <p>${contact.telephone}</p>

	<form method="GET" action="/employee">
		<input type="submit" value="Listar">
	</form>
</body>
</html>
