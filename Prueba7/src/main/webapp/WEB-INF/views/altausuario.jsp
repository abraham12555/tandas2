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

<h2>Alta Nuevo Usuario</h2>
<form:form method="POST" modelAttribute="usuario" action="/Prueba7/agregarusuario">
  <label for="iduser">Id Usuario </label>

<input type="text" name="iduser" id="iduser">

<br/> <br/>
 
  <label for="nombreu">Nombre: </label>

<input type="text" name="nombreu" id="nombreu">

<br/> <br/>

<label for="apu">Apellido Paterno: </label>

<input type="text" name="apu" id="apu">

<br/> <br/>

<label for="amu">Apellido Materno: </label>

<input type="text" name="amu" id="amu">

<br/> <br/>
<label for="login">Login: </label>

<input type="text" name="login" id="login">

<br/> <br/>
<label for="amu">Password: </label>

<input type="password" name="password" id="password">

<br/> <br/>
<label >Activo </label>
<input type="radio" name="activou" id="si" value="True">

<label for="si">Si </label>


<input type="radio" name="activou" id="no" value="False">

<label for="no">No </label>

<br/> <br/>
<select name="idperfil">
    <option value="NONE">--- Seleciona un Perfil ---</option>
   <c:forEach items="${modelmap.comboperfil}" var="prof">
       <option value="${prof.idperfil}">${prof.perfil}</option>
       
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
                  <th>Editar</th>  
                 <th>Modificar</th>
        </tr>
   <c:forEach var="per" items="${modelmap.list}">   
   <tr>  
   <td>${per.iduser}</td>  
   <td>${per.nombreu}</td>  
       <td>${per.apu}</td>  
         <td>${per.amu}</td>  
           <td>${per.login}</td>  
             <td>${per.password}</td>  
                          <td>${per.activou}</td>  
             
     <td><a href="<c:url value='/editarusuario/${per.iduser}' />" >Edita</a></td>  
 
     <td><a href="<c:url value='/borrarusuario/${per.iduser}' />" >Borra</a></td>  
        <td><a href="<c:url value='/asignarrolusuario/${per.iduser}' />" >Asignar rol</a></td>  
   
   </tr>  
   </c:forEach>  
   </table>
</body>
</html>