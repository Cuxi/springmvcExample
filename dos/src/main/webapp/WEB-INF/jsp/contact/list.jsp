<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<body>

	<h1>Contacts</h1>
	
	<c:forEach items="${employeeList}" var="contact">
		<p>
			${contact.name}: $${contact.email}: $${contact.address}: $${contact.telephone}
		</p>
	</c:forEach>

</body>
</html>