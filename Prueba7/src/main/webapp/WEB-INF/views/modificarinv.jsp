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
	<form:form method="POST" modelAttribute="Involucrado"
		action="/Prueba7/actualizarinv">
		<c:forEach var="per" items="${modelmap.list}">
			<label for="idit">Id Involucrado </label>

			<input type="text" name="idit" id="idit" value="${per.idit }"
				readonly="readonly">


			<br />
			<br />

			<br />
				<label for="idtanda">Idtanda</label>
		
		<input type="text" name="Tanda.idtanda" value="${idtanda}" readonly="readonly"/>

			<br />
			<br />
			<br />
			<br />
			<label>Usuario</label>
					<input type="text" name="Usuario.iduser" value="${per.usuario.iduser}" readonly="readonly"/>
			
		<input type="text" name="nombre" id="idit" value="${per.usuario.nombreu} ${per.usuario.apu} ${per.usuario.amu}"readonly="readonly">


			<br />
			<br />

			<label for="numerot">Numero de Pago: </label>

			<input type="text" name="numerot" id="numerot"
				value="${per.numerot }">

			<br />
			<br />
			<label for="adeudo">adeudo: </label>

			<input type="text" name="adeudo" id="adeudo" value="${per.adeudo }">

			<br />
			<br />
			<label>Aceptacion de Pago </label>
			<c:if test="${per.pentregado == true}">
				<input type="radio" name="pentregado" id="si" value="True"
					checked="checked">

				<label for="si">Si </label>
				<input type="radio" name="pentregado" id="no" value="False">

				<label for="no">No </label>
			</c:if>



			<br />
			<br />


			<input type="Submit" Value="Guardar" />
		</c:forEach>
	</form:form>


</body>
</html>