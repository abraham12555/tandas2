<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<form:form method="POST" modelAttribute="ejerce" action="/Prueba7/guardarrol">
       <c:forEach var="per" items="${modelmap.listtanda}">   
        <label for="iduser">Id Tanda</label>

<input type="text" name="iduser" id="iduser" value="${per.idtanda }" readonly="readonly">

<br/> <br/>
 
  <label for="nombreu">Monto de tanda : </label>

<input type="text" name="nombreu"  value="${per.monto }" id="nombreu" readonly="readonly">

<br/> <br/>

<label for="apu">Numero de Pagos: </label>

<input type="text" name="apu" id="apu" value="${per.npagos }" readonly="readonly">

<br/> <br/>

<label for="amu">Fecha de Inicio: </label>

<input type="text" name="amu" id="amu" value="${per.finicio }" readonly="readonly">



<br/> <br/>
<label for="amu">Fecha Final: </label>

<input type="text" name="amu" id="amu" value="${per.ffinal }" readonly="readonly">



<br/> <br/>

<label for="amu">Estatus: </label>

<input type="text" name="amu" id="amu" value="${per.estatus }" readonly="readonly">





<br/> <br/>

<select required name="iduser" >
    <option value="NONE">--- Seleciona un usuario ---</option>
   <c:forEach items="${modelmap.listusuarios}" var="prof">
       <option value="${prof.iduser}">${prof.nombreu}</option>
       
       </c:forEach>
       </select>
       
   
       
        
        <input onclick="return confirmar('¿Está seguro que desea guardar el registro?')" type="Submit" Value="Guardar"/>
        </c:forEach>
        </form:form>


</body>
</html>
<script>
function confirmar ( mensaje ) {
return confirm( mensaje );
}
</script> 