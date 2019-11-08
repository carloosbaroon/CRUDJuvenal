<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservar Sala</title>
</head>
<body>
	<h1>Reservar Sala</h1>
	<s:url action="goto_admin_salas" var="regresar"/>
	
	<s:form action="revisar_disponibilidad">
		<s:textfield name="consulta.fecha_consulta" label="Fecha (YYYY/MM/DD)" />
		<s:textfield name="consulta.hora_inicial" label="Hora inicial (hh:mm)" />
		<s:textfield name="consulta.hora_final" label="Hora final (hh:mm)" />
		<s:textfield name="consulta.id_empleado" label="Id del empleado" />
		<s:textfield name="consulta.id_sala" label="Id de la sala" />
		<s:textfield name="consulta.id_paciente" label="Id del paciente" />
		<s:textfield name="consulta.observaciones" label="Observaciones" />

		<s:submit value="Reservar"/>
	</s:form>
	<a href="${regresar}">Regresar</a>
</body>
</html>