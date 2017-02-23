
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<body>

	<form action="/show" method='post'>
	 <h1>Contacts</h1>
	 <p>
	  <select name="clave" >
	   <option value="">Selecciona uno</option>
	   <c:forEach items="${contact}" var="contact">
		<option value="${contact}">${contact}</option>
	   </c:forEach>
	  </select>
	 </p>
         <input id="submit" type="submit" tabindex="5" value="show">
   </form>
	<form method="GET" action="/employee">
		<input type="submit" value="Listar">
	</form>
	<form method="POST" action="/eliminar">
		<input type="submit" value="Eliminar">
	</form>
	<form method="POST" action="/add">
		<input type="submit" value="Insertar">
	</form>
	<form method="POST" action="/edit">
		<input type="submit" value="Editar">
	</form>
</body>
</html>
