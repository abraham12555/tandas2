<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<html xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org"> 
<head> 
<style> .blue-button
{ background: #25A6E1; filter: progid: DXImageTransform.Microsoft.gradient
( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0); padding:3px 5px; color:#fff; 
font-family:'Helvetica Neue',sans-serif; font-size:12px; border-radius:2px; -moz-border-radius:2px; 
-webkit-border-radius:4px; border:1px solid #1A87B9 } 
table { font-family: "Helvetica Neue", Helvetica, sans-serif; width: 50%; } 
th { background: SteelBlue; color: white; } 
td,th{ border: 1px solid gray; width: 25%; text-align: left; padding: 5px 10px; } 
.errores{
    -webkit-boxshadow: 0 0 10px rgba(0, 0, 0, 0.3);
    -moz-box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
    -o-box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
    border-radius:10px;
    -webkit-border-radius: 10px;
    background: red;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
    color: #fff;
    display: none;
    font-size: 12px;
    margin-top: -40px;
    margin-left: 250px;
    padding: 10px;
    position: absolute;
}
.errores:before{ /* Este es un truco para crear una flechita */
    content: '';
    border-top: 8px solid transparent;
    border-bottom: 8px solid transparent;
    border-right: 8px solid #BC1010;
    border-left: 8px solid transparent;
    left: -16px;
    position: absolute;
    top: 5px;
}



</style> 
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/validation.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/livevalidation_standalone.js"></script>
        
        <link rel="stylesheet" href="../../../../../resources/css/validation.css" />
    <script type="text/javascript" src="../../../../../resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="../../../../../resources/js/livevalidation_standalone.js"></script>
       
       <link rel="stylesheet" href="../../resources/css/validation.css" />
        <script type="text/javascript" src="../../resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="../../resources/js/livevalidation_standalone.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/validation.css"/>
        <link rel="stylesheet" href="../../../resources/css/validation.css" />
    <script type="text/javascript" src="../../../resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="../../../resources/js/livevalidation_standalone.js"></script>
            <script src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js'></script>
</head>
<body>

<h2>Alta Nueva Tanda</h2>
<div sec:authorize="hasRole('ROLE_ADMIN')">
  Este contenido es solo para administradores-
</div>

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
	
<form:form method="GET" modelAttribute="tanda" action="/Prueba7/agregartanda">

  <label for="monto">Monto de tanda: </label>

<input type="text" name="monto" id="monto" required="required" class="LV_valid_field" >
<div id="mensaje1" class="errores"> Ingresa solo caracteres</div>
<br/> <br/>


<label for="npagos">Numero de pagos : </label>

<input type="text" name="npagos" id="npagos" required="required">

<br/> <br/>

<label for="finicio">Fecha de Inicio: </label>

<input type="date" name="finicio" id="finicio" required="required">

<br/> <br/>
<label for="ffinal">Fecha Final: </label>

<input type="date" name="ffinal" id="ffinal" required="required">

<br/> <br/>
<select name="estatus">
    <option value="NONE">--- Seleciona un estatus ---</option>
       <option value="En Proceso">En Proceso</option>
              <option value="Pendiente">Pendiente</option>
              <option value="Cancelada">Cancelada</option>
       
       </select>
       

<br/> <br/>


       <select name="idperiodo">
    <option value="NONE">--- Seleciona un Periodo---</option>
   <c:forEach items="${modelmap.listperiodo}" var="pro">
       <option value="${pro.idperiodo}">${pro.periodo}</option>
       
       </c:forEach>
       </select>
       
       
<br/> <br/>

        <input type="Submit" Value="Guardar"/>
        </form:form>
        <table>
        <tr>
        <th>Id Tanda</th>
         <th> $ Monto </th>
         <th>Numero de Pagos</th>
                 <th>Fecha de Inicio </th>
                  <th>Fecha Final</th>
                  <th>Estatus</th>
                  <th>Periodo</th>
                  <th>Editar</th>  
                 <th>Modificar</th>
                                  <th>Agregar Involucrados</th>
                 
        </tr>
   <c:forEach var="per" items="${modelmap.list}">
<tr>
<td>${per.idtanda}</td>
<td>${per.monto}</td>
<td>${per.npagos}</td>
<td>${per.finicio}</td>
<td>${per.ffinal}</td>
<td>${per.estatus}</td>
<td>${per.periodo.periodo}</td>

<td><a href="<c:url value='/tanda/editartanda/${per.idtanda}' />" >Editar</a></td>

<td><a onclick="return confirmar('¿Está seguro que desea eliminar el registro?')" href="<c:url value='/borrartanda/${per.idtanda}' />" >Borrar</a></td>
<td><a href="<c:url value='/agregarinvolucrados/${per.idtanda}' />" >Agregar involucrados</a></td>

</tr>
</c:forEach>
   </table>
</body>
</html>
<script>
function confirmar ( mensaje ) {
return confirm( mensaje );
}
</script> 