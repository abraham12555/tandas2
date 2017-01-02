<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
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
</head>
<body>

<h2>Alta Nuevo Periodo</h2>
<form:form method="POST" modelAttribute="periodo" action="/Prueba7/agregarperiodo">
         <label for="idperiodo">Id Periodo </label>

<input type="text" name="idperiodo" id="idperiodo">

<br/> <br/>
 
  <label for="periodo">Nombre del Periodo: </label>

        <input type="text" name="periodo"/>

<br/> <br/>
        <input type="Submit" Value="Guardar"/>
        </form:form>
        <table>
        <tr>
        <th>Id Periodo</th>
         <th>Periodo</th>
              <th>Editar</th>  
                 <th>Modificar</th>
        </tr>
   <c:forEach var="per" items="${list}">   
   <tr>  
   <td>${per.idperiodo}</td>  
   <td>${per.periodo}</td>  
     
     <td><a href="<c:url value='/editar/${per.idperiodo}' />" >Edita</a></td>  
 
     <td><a href="<c:url value='/borrar/${per.idperiodo}' />" >Borra</a></td>  
   
   </tr>  
   </c:forEach>  
   </table>
</body>
</html>