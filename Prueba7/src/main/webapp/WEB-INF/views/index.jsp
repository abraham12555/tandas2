<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Spring Page Redirection</title>
</head>
<body>
<h2>Dar de alta Periodo </h2>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
	  <input type="hidden"
		name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	</form>

	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Bienvenido : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>
	
<a href="/Prueba7/perfil"> Perfiles</a>
<a href="/Prueba7/altaperiodo"> Periodo</a>
<a href="/Prueba7/usuario"> Usuarios</a>
<a href="/Prueba7/tanda"> Tandas</a>


</body>
</html>