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
<h2>Detalle Calendario de Tanda</h2>
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
 <table>
        <tr>
         <th>idcp</th> 
                 <th>Numero de Pago</th>
              
                  <th>Fecha Inicio de pago</th>
                  <th>Fecha fin de Pago</th>
                  <th>idtanda</th>
              
        </tr>
        
   <c:forEach var="ta" items="${modelmap.list}">   
   <tr>  
   <td>${ta.idcp}</td>  
   <td>${ta.pagon}</td>  
   <td>${ta.fip}</td> 
       <td>${ta.ffp}</td>  
         <td>${ta.tanda.idtanda}</td>  
          
   </tr>  
   </c:forEach>  
   
   </table>
			<br /><label > Nombre y Apellidos</label>
		<select name="idit" id="idit">
			<option value="NONE">--- Seleciona un Nombre---</option>
			 <c:forEach var="t" items="${modelmap.listt}">   
				<option value="${t.idit}">${t.idit} </option>

			</c:forEach>
		</select>
</body>
</html>