
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
         <input id="submit" type="submit" tabindex="5" value="Show">
        </form>
</body>
</html>
