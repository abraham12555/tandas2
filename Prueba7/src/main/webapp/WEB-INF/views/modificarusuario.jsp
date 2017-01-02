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
<form:form method="POST" modelAttribute="Usuario" action="/Prueba7/actualizarusuario">
       <c:forEach var="per" items="${lst}">   
        <label for="iduser">Id Usuario </label>

<input type="text" name="iduser" id="iduser" value="${per.iduser }" readonly="readonly">

<br/> <br/>
 
  <label for="nombreu">Nombre: </label>

<input type="text" name="nombreu"  value="${per.nombreu }" id="nombreu">

<br/> <br/>

<label for="apu">Apellido Paterno: </label>

<input type="text" name="apu" id="apu" value="${per.apu }">

<br/> <br/>

<label for="amu">Apellido Materno: </label>

<input type="text" name="amu" id="amu" value="${per.amu }">

<br/> <br/>
<label for="login">Login: </label>

<input type="text" name="login" id="login" value="${per.login }">

<br/> <br/>
<label for="amu">Password: </label>

<input type="password" name="password" id="password" value="${per.password }">

<br/> <br/>
<label >Activo </label>
 <c:if test="${per.activou == true}">
<input type="radio" name="activou" id="si" value="True" checked="checked" >

<label for="si">Si </label>
<input type="radio" name="activou" id="no" value="False">

<label for="no">No </label>
        </c:if>

 <c:if test="${per.activou == false}">
<input type="radio" name="activou" id="si" value="True" >
<label for="si">Si </label>

<input type="radio" name="activou" id="no" value="False"  checked="checked">

<label for="no">No </label>
        </c:if>



<br/> <br/>

        
        <input type="Submit" Value="Guardar"/>
        </c:forEach>
        </form:form>


</body>
</html>