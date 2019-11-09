<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altas Empleado</title>
</head>
<body>
	<h1>Empleado Registrado</h1>
	<s:url action="goto_alta_empleado_jsp" var="regresar"/>

	<b>Numero de Empleado: </b> <s:property value="empleado.no_empleado"/><br>
	<b>Nombre Completo: </b> <s:property value="empleado.nombre_completo"/><br>
	<b>Direccion: </b> <s:property value="empleado.direccion"/><br>
	<b>Telefono: </b> <s:property value="empleado.telefono"/><br>
	<b>Puesto: </b> <s:property value="empleado.puesto"/><br>
	<b>Especialidad Medica: </b> <s:property value="empleado.especialidad"/><br>
	<b>Estado: </b> <s:property value="empleado.estado"/><br>
	<a href="${regresar}">Regresar</a>

</body>
</html>