<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<body>

	<h1>Contacts</h1>
	<p>
	<select name="clave" onChange="window.location.href=this.value">
	<option value="">Selecciona uno</option>
	<c:forEach items="${employeeList}" var="contact">
		<option value="/show/${contact}">${contact}</option>
	</c:forEach>
	</select>
	</p>
</body>
</html>
