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

	<h2>Alta Involucrados</h2>
	<form:form method="POST" modelAttribute="involucrado"
		action="/Prueba7/agregarinvo">
	
		<label for="idtanda">Idtanda</label>
		
		<input type="text" name="Tanda.idtanda" value="${idtanda}" readonly="readonly"/>
	<label for="idcp">Usuario</label>
		
		<select name="Usuario.iduser" id="Usuario.iduser">
			<option value="NONE">--- Seleciona un Usuario ---</option>
			<c:forEach items="${modelmap.combousuario}" var="prof">
				<option value="${prof.iduser}">${prof.nombreu} ${prof.apu} ${prof.amu}</option>

			</c:forEach>
		</select>

		<br />
		<br />

		<label for="pagon">Numero de Pago: </label>

		<input type="text" name="numerot" id="numerot">

		<br />
		<br />
		<label for="fip">Aceptacion de pago</label>
		<input type="radio" name="pentregado" id="si" value="True">

		<label for="si">Si </label>


		<input type="radio" name="pentregado" id="no" value="False">

		<label for="no">No </label>
		<br />
		<br />

		<label for="ffp">Adeudo</label>
		<input type="text" name="adeudo" id="adeudo">
		<br />
		<br />


		<input type="Submit" Value="Guardar" />
	</form:form>
	<table>
		<tr>
			<th>Id Involucrado</th>
			<th>Id tanda</th>
			<th>Usuario</th>
			<th>N° Pago</th>
			<th>Aceptación de Pago</th>
			<th>Adeudo</th>
			<th>Editar</th>
			<th>Modificar</th>
		</tr>
		<c:forEach var="per" items="${modelmap.list}">
			<tr>
				<td>${per.idit}</td>
				<td>${per.tanda.idtanda}</td>
				<td>${per.usuario.nombreu} ${per.usuario.apu} ${per.usuario.amu}</td>
				<td>${per.numerot}</td>
				<td>${per.pentregado}</td>
				<td>${per.adeudo}</td>

				<td><a href="<c:url value='/editarinvolu/${per.idit}/${per.tanda.idtanda}' />">Edita</a></td>

				<td><a href="<c:url value='/borrarinvolu/${per.idit}/${per.tanda.idtanda}' />">Borra</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>