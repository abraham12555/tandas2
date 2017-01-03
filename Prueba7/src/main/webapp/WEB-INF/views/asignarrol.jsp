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
 <c:forEach var="siguiente " items="${modelmap.siguiente}">   
<input type="text" name="idejerce" id="idejerce" value="${modelmap.siguiente}" readonly="readonly">
        </c:forEach>
       <c:forEach var="per" items="${modelmap.list}">   
        <label for="iduser">Id Usuario </label>

<input type="text" name="iduser" id="iduser" value="${per.iduser }" readonly="readonly">

<br/> <br/>
 
  <label for="nombreu">Nombre: </label>

<input type="text" name="nombreu"  value="${per.nombreu }" id="nombreu" readonly="readonly">

<br/> <br/>

<label for="apu">Apellido Paterno: </label>

<input type="text" name="apu" id="apu" value="${per.apu }" readonly="readonly">

<br/> <br/>

<label for="amu">Apellido Materno: </label>

<input type="text" name="amu" id="amu" value="${per.amu }" readonly="readonly">



<br/> <br/>
<select name="idperfil">
    <option value="NONE">--- Seleciona un Perfil ---</option>
   <c:forEach items="${modelmap.comboperfil}" var="prof">
       <option value="${prof.idperfil}">${prof.perfil}</option>
       
       </c:forEach>
       </select>
       
   
       
        
        <input type="Submit" Value="Guardar"/>
        </c:forEach>
        </form:form>


</body>
</html>