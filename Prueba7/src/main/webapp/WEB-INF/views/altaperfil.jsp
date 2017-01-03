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

<h2>Alta Nuevo Perfil</h2>
<form:form method="POST" modelAttribute="perfil" action="/Prueba7/agregarperfil">

          <label for="periodo">Nombre del Perfil o Rol: </label>
        
        <input type="text" name="perfil"/>
                        <br/> <br/>
        
        <input type="Submit" Value="Guardar"/>
        </form:form>
        <table>
        <tr>
        <th>Id Perfil</th>
         <th>Perfil</th>
              <th>Editar</th>  
                 <th>Modificar</th>
        </tr>
   <c:forEach var="per" items="${model.list}">   
   <tr>  
   <td>${per.idperfil}</td>  
   <td>${per.perfil}</td>  
     
     <td><a href="<c:url value='/editarperfil/${per.idperfil}' />" >Edita</a></td>  
 
     <td><a href="<c:url value='/borrarperfil/${per.idperfil}' />" >Borra</a></td>  
   
   </tr>  
   </c:forEach>  
   </table>
</body>
</html>