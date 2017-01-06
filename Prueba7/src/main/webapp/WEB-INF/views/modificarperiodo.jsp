<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
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
<form:form method="POST" modelAttribute="Periodo" action="/Prueba7/actualizar">
       <c:forEach var="per" items="${lst}">   

  <label for="idperiodo">Id Periodo </label>

<input type="text" name="idperiodo" id="idperiodo" value="${per.idperiodo }"readonly="readonly">

<br/> <br/>
 
  <label for="periodo">Periodo: </label>

<input type="text" name="periodo" id="periodo" value="${per.periodo }" required="required">
<br/> <br/>
  <label for="intervalo">Intervalo de dias : </label>

<input type="text" name="intervalo" id="intervalo" value="${per.intervalo }" required="required">
<br/> <br/>
   </c:forEach>  


        <input onclick="return confirmar('¿Está seguro que desea guardar el registro?')" type="Submit" Value="Guardar"/>

</form:form>


      
</body>
</html>

<script>
function confirmar ( mensaje ) {
return confirm( mensaje );
}
</script> 