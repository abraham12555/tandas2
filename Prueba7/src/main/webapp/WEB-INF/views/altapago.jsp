<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

	<h2>Alta Pago</h2>
	<form:form method="POST" modelAttribute="pago"
		action="/Prueba7/agregarpago">
	
		<br />
		<br />
		<label for="fpago">Fecha de Pago: </label>

		<input type="text" name="fpago" id="fpago">

		<br />
		<br />
				<br /><label >Id Calendario </label>
		<select name="Calendariopagos.idcp" id="Calendariopagos.idcp">
			<option value="NONE">--- Seleciona el id calendario---</option>
			<c:forEach items="${modelmap.combocp}" var="prof">
				<option value="${prof.idcp}">${prof.idcp}</option>

			</c:forEach>
		</select>

		<br />
		<br />
		<br />
		<br />
					<br /><label >Id Involucrado</label>
		<select name="Involucrado.idit" id="Involucrado.idit">
			<option value="NONE">--- Seleciona un Involucrado---</option>
			<c:forEach items="${modelmap.comboinv}" var="prof">
				<option value="${prof.idit}">${prof.usuario.nombreu}</option>

			</c:forEach>
		</select>

		<br />
		<br />

			

		<input type="Submit" Value="Guardar" />
	</form:form>
	<table>
		<tr>
			<th>Id Pago</th>
			<th>Id calendario</th>
			<th>Id Involucrado</th>
			<th>Fecha Pago</th>
			<th>Editar</th>
			<th>Modificar</th>
		</tr>
		<c:forEach var="per" items="${modelmap.list}">
			<tr>
				<td>${per.idpago}</td>
				<td>${per.calendariopagos.idcp}</td>
				<td>${per.involucrado.idit}</td>
				<td>${per.fpago}</td>
				<td><a href="<c:url value='/editarpago/${per.idpago}' />">Edita</a></td>

				<td><a href="<c:url value='/borrarpago/${per.idpago}' />">Borra</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>