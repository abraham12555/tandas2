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

<h2>Alta Nuevo Usuario</h2>
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
	
<form:form method="POST" modelAttribute="usuario" action="/Prueba7/agregarusuario">

  <label for="nombreu">Nombre: </label>

<input type="text" name="nombreu" id="nombreu" required="required" class="LV_valid_field" >
<div id="mensaje1" class="errores"> Ingresa solo caracteres</div>
<br/> <br/>


<label for="apu">Apellido Paterno: </label>

<input type="text" name="apu" id="apu" required="required">

<br/> <br/>

<label for="amu">Apellido Materno: </label>

<input type="text" name="amu" id="amu" required="required">

<br/> <br/>
<label for="login">Login: </label>

<input type="text" name="login" id="login" required="required">

<br/> <br/>
<label for="amu">Password: </label>

<input type="password" name="password" id="password" required="required">

<br/> <br/>
<label >Activo </label>
<input type="radio" name="activou" id="si" value="True" >

<label for="si">Si </label>


<input type="radio" name="activou" id="no" value="False">

<label for="no">No </label>

<br/> <br/>
 <img src="<%=request.getContextPath()%>/resources/css/icon.png"> 

       <select name="idperfil">
    <option value="NONE">--- Seleciona un Perfil ---</option>
   <c:forEach items="${modelmap.comboperfil}" var="pro">
       <option value="${pro.idperfil}">${pro.perfil}</option>
       
       </c:forEach>
       </select>
       
       
     
 

        
        <input type="Submit" Value="Guardar"/>
        </form:form>
        <table>
        <tr>
        <th>Id usuario</th>
         <th>Nombre</th>
              <th>Apellido Paterno</th>  
                 <th>Apellido Materno</th>
                  <th>Login</th>
                  <th>Password</th>
                  <th>Activo</th>
                   <th>Perfil</th>  
                  <th>Editar</th>  
                 <th>Modificar</th>
                 <th>Asignar rol</th>
                 
        </tr>
   <c:forEach var="per" items="${modelmap.list}">
<tr>
<td>${per.usuario.iduser}</td>
<td>${per.usuario.nombreu}</td>
<td>${per.usuario.apu}</td>
<td>${per.usuario.amu}</td>
<td>${per.usuario.login}</td>
<td>${per.usuario.password}</td>
<td>${per.usuario.activou}</td>
<td>${per.perfil.perfil}</td>

<td><a href="<c:url value='/usuario/editarusuario/${per.usuario.iduser}' />" >Edita</a></td>

<td><a onclick="return confirmar('¿Está seguro que desea eliminar el registro?')" href="<c:url value='/borrarusuario/${per.idejerce}' />" >Borra</a></td>
<td><a href="<c:url value='/asignarrolusuario/${per.usuario.iduser}' />" >Asignar rol</a></td>
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
