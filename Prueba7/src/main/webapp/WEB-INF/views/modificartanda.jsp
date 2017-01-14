<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<html> 
<head> 
<!-- link para el codigo de calendario -->
	<link href="css/tcal.css" type="text/css" rel="stylesheet" />
	<script src="js/tcal.js" type="text/javascript" ></script> 
<style> .blue-button
{ background: #25A6E1; filter: progid: DXImageTransform.Microsoft.gradient
( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0); padding:3px 5px; color:#fff; 
font-family:'Helvetica Neue',sans-serif; font-size:12px; border-radius:2px; -moz-border-radius:2px; 
-webkit-border-radius:4px; border:1px solid #1A87B9 } 
table { font-family: "Helvetica Neue", Helvetica, sans-serif; width: 50%; } 
th { background: SteelBlue; color: white; } 
td,th{ border: 1px solid gray; width: 25%; text-align: left; padding: 5px 10px; } 
</style> 
	  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
    <script>
  $( function() {
    $( "#datepicker2" ).datepicker();
  } );
  </script>
</head>
<body>
<h2>Editar Tanda</h2>


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
	 <a href="<c:url value='/welcome' />" >Menu</a>

<form:form method="POST" modelAttribute="Tanda" action="/Prueba7/actualizartanda">
       <c:forEach var="tan" items="${modelmap.lst}">   

  <label for="idperfil">Id  </label>

<input type="text" name="idtanda" id="idtanda" value="${tan.idtanda }" readonly="readonly">

<br/> <br/>
 
  <label for="monto">Monto: </label>

<input type="text" name="monto" id="monto" value="${tan.monto}"/>
<br/> <br/>
 
  <label for="npagos">Numero de Pagos: </label>

<input type="text" name="npagos" id="npagos" value="${tan.npagos}"/>
<br/> <br/>
 
  <label for="finicio">Fecha de Inicio: </label>

<input type="text" name="finicio" id="datepicker" value="${tan.finicio}" />
<br/> <br/>
 
  <label for="ffinal">Fecha Final: </label>

<input type="text" name="ffinal" id="datepicker2"  value="${tan.ffinal}" />
<br/> <br/>

<label for="estatus">Estatus: </label>
<select name="estatus" id="estatus"  >
    <option value="NONE">${tan.estatus}</option>
       <option value="En proceso">En proceso</option>
       <option value="Pendiente">Pendiente</option>
       <option value="Cancelado">Cancelado</option>
       
       </select>
 
  <!--<label for="estatus">Estatus: </label>

<input type="text" name="estatus" id="estatus" value="${tan.estatus}">-->
<br/> <br/>
 
  <label for="periodo">Periodo: </label>
 <select name="Periodo.idperiodo" id="Periodo.idperiodo">
    <option value="NONE">${tan.periodo.periodo}</option>
   <c:forEach items="${modelmap.comboperiodo}" var="prof">
       <option value="${prof.idperiodo}">${prof.periodo}</option>  
       </c:forEach>
 </select>
   </c:forEach>  
        <input type="Submit" Value="Guardar"/>
</form:form> 
    
</body>
</html>