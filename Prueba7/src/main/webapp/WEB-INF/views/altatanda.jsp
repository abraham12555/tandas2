<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html> 
<head> 
<style> .blue-button
{ background: #25A6E1; filter: progid: DXImageTransform.Microsoft.gradient
( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0); padding:3px 5px; color:#fff; 
font-family:'Helvetica Neue',sans-serif; font-size:12px; border-radius:2px; -moz-border-radius:2px; 
-webkit-border-radius:4px; border:1px solid #1A87B9 } 
table { font-family: "Helvetica Neue", Helvetica, sans-serif; width: 50%; } 
th { background: SteelBlue; color: white; } 
td,th{ border: 1px solid gray; width: 25%; text-align: left; padding: 5px 10px; } 
</style> 
<!-- link para el codigo de calendario -->
	<link rel="stylesheet" type="text/css" href="css/tcal.css" />
	<script type="text/javascript" src="js/tcal.js"></script> 
	
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

<h2>Alta Nueva Tanda</h2>

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
<form:form method="POST" modelAttribute="tanda" action="/Prueba7/agregartanda">

  <label for="monto">Monto: </label>

<input type="text" name="monto" id="monto">

<br/> <br/>

<label for="npago">Número de Pagos: </label>

<input type="text" name="npagos" id="npagos">

<br/> <br/>
<label for="finicio">Fecha de Inicio</label>
 <input type="text" name="finicio" id="datepicker">

 <br/> <br/>
 
 <label for="ffinal">Fecha Final</label>
 <input type="text" name="ffinal" id="datepicker2">
 <br/> <br/>
 
 <select name="estatus" id="estatus">
    <option value="NONE">--- Seleciona Estatus ---</option>
       <option value="Enproceso">En proceso</option>
       <option value="Pendiente">Pendiente</option>
       <option value="Cancelado">Cancelado</option>
       
       </select>
       
 <br/> <br/>
 
 <select name="Periodo.idperiodo" id="Periodo.idperiodo">
    <option value="NONE">--- Seleciona un Periodo ---</option>
   <c:forEach items="${modelmap.comboperiodo}" var="prof">
       <option value="${prof.idperiodo}">${prof.periodo}</option>
       
       </c:forEach>
       </select>
  <br/> <br/>
        <input type="Submit" Value="Guardar"/>
        </form:form>
        
 <br/><br/>
 <table>
        <tr>
         <th>Tanda</th> 
                 <th>Numero de Pagos</th>
                  <th>Monto</th> 
                  <th>Fecha Inicio</th>
                  <th>Fecha Fin</th>
                  <th>Estatus</th>
                  <th>Periodo</th> 
                  <th>Editar</th> 
                  <th>Borrar</th>  
                  <th>Generar Calendario</th>  
                     <th>Ver Calendario</th>   
                      <th>Borrar Calendario</th> 
                       <th>Realizar Pago</th> 
                           <th>Agregar Involucrados</th> 
        </tr>
        
   <c:forEach var="ta" items="${modelmap.list}">   
   <tr>  
   <td>${ta.idtanda}</td>  
   <td>${ta.npagos}</td>  
   <td>${ta.monto}</td> 
       <td>${ta.finicio}</td>  
         <td>${ta.ffinal}</td>  
           <td>${ta.estatus}</td>  
           <td>${ta.periodo.periodo}</td>
             
     <td><a href="<c:url value='/editartanda/${ta.idtanda}' />" >Edita</a></td>  
 
     <td><a href="<c:url value='/borrartanda/${ta.idtanda}' />" >Borra</a></td>    
        <td><a href="<c:url value='/generarcalendario/${ta.idtanda}' />" >Generar calendario</a></td>  
          <td><a href="<c:url value='/vercalendario/${ta.idtanda}' />" >Ver calendario</a></td>  
            <td><a href="<c:url value='/borrarcalendario/${ta.idtanda}' />" >Borrar calendario</a></td>    
                        <td><a href="<c:url value='/pago/${ta.idtanda}' />" >Realizar Pago</a></td> 
                          <td><a href="<c:url value='/involucrado/${ta.idtanda}' />" >Agregar Involucrados</a></td>     
            
   </tr>  
   </c:forEach>  
   </table>
   
       
</body>
</html>