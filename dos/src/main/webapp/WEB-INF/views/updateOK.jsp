<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
	<meta charset="utf-8">
</head>
<body>
	<h1>Editar contacto:</h1>
	<c:choose>
		<c:when test="${resultado}==0">Edicion KO</c:when>
		<c:otherwise>Editado ${res}
		</c:otherwise>
	</c:choose>
	<form method="GET" action="/employee">
		<input type="submit" value="Aceptar">
	</form>
</body>
</html> 
