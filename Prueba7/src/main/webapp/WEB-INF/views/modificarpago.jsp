<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Involucrado</title>
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
	<form:form method="POST" modelAttribute="pago"
		action="/Prueba7/actualizarpa">
		<c:forEach var="per" items="${modelmap.list}">
			<label for="idpago">Id Pago </label>

			<input type="text" name="idpago" id="idpago" value="${per.idpago }"
				readonly="readonly">


			<br />
			<br />

			<br />
			<label>Id Calendario </label>
			<select name="Calendariopagos.idcp" id="Calendariopagos.idcp">
				<option value="${per.calendariopagos.idcp}">${per.calendariopagos.idcp}</option>
				<c:forEach items="${modelmap.combocp}" var="prof">
					<option value="${prof.idcp}">${prof.idcp}</option>

				</c:forEach>
			</select>

			<br />
			<br />
			<br />
			<br />
			<label>Involucrado</label>
			<select name="Involucrado.idit" id="Involucrado.idit">
				<option value="${per.involucrado.idit}">${per.involucrado.idit}</option>
				<c:forEach items="${modelmap.comboinv}" var="prof1">
					<option value="${prof1.idit}">${prof1.idit}</option>

				</c:forEach>
			</select>

			<br />
			<br />

			<label for="fpago">Fecha Pago: </label>

			<input type="text" name="fpago" id="fpago" value="${per.fpago }">


			<br />
			<br />


			<input type="Submit" Value="Guardar" />
		</c:forEach>
	</form:form>


</body>
</html>