<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>

</head>
<body>

	<table>
		<tr>
			<th>Numero de Pago</th>
			<th>Fecha de inicio</th>
			<th>Fecha Final</th>
			<th>Nombre del Pagador</th>
			<th>Fecha en que pago</th>
			<th>Se atraso el Pago ?  </th>
		
		</tr>

				
  <c:forEach items="${modelmap.lista2}" var="per" varStatus="loop">
    <c:set var="barCode" value="${modelmap.lista3[loop.index]}" />
    <tr>
                <td>${per.calendariopagos.pagon}</td>
				<td>${per.calendariopagos.fip}</td>
				<td>${per.calendariopagos.ffp}</td>
				<td>${per.involucrado.usuario.nombreu} ${per.involucrado.usuario.apu} ${per.involucrado.usuario.amu}</td>
                <td>${per.fpago}</td>
    
      <c:if test="${barCode <0}">
      <td><c:out value="Atraso ${barCode}" /></td>
      </c:if>
       <c:if test="${barCode >=0}">
      <td><c:out value="Al corriente ${barCode}" /></td>
      </c:if>
    </tr>
  </c:forEach>
</table>
</body>
</html>