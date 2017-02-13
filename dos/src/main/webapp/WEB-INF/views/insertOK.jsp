<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
	<meta charset="utf-8">
</head>
<body>
	<h1>Insertar contacto:</h1>
	<c:choose>
		<c:when test="${resultado}==0">Edicion KO</c:when>
		<c:otherwise>Inserción ok.{res}
		</c:otherwise>
	</c:choose>
	<form method="POST" id="formu1" action="/employee">
		<input type="submit" id="send" value="Aceptar">
	</form>
</body>
</html> 
