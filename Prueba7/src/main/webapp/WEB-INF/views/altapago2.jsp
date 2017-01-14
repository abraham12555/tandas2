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
	  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
    <script>
  $( function() {
    $( "#datepicker2" ).datepicker();
  } );
  </script>
</head>
<body>

	<h2>Alta Pago</h2>
	<form:form method="POST" modelAttribute="pago"
		action="/Prueba7/agregarpago">
	
		<br />
		<br />
		<label for="fpago">Fecha en que se esta Pagando : </label>

		<input type="text" name="fpago" id="datepicker">

		<br />
		<br />
				<br /><label >Numero de pago y rango de fechas </label>
		<select name="Calendariopagos.idcp" id="idcp">
			<option value="NONE">--- Seleciona una fecha---</option>
			 <c:forEach var="ta" items="${modelmap.list}">   
				<option value="${ta.idcp}">No.Pago :${ta.pagon} De: ${ta.fip} a : ${ta.ffp}</option>

			</c:forEach>
		</select>
		


		<br />
			<br />
		<br />
				<br /><label > Nombre y Apellidos</label>
		<select name="idit" id="idit">
			<option value="NONE">--- Seleciona un Nombre---</option>
			 <c:forEach var="t" items="${modelmap.listt}">   
				<option value="${t.idit}">${t.idit} </option>

			</c:forEach>
		</select>

		<br />
		<br />

			

		<input type="Submit" Value="Guardar" />
	</form:form>
	
</body>
</html>