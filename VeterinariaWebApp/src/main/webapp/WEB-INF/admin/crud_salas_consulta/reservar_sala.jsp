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
	
	<s:form action="terminar_reservacion">
		<s:textfield name="consulta.fecha_consulta" label="Fecha (YYYY/MM/DD)" value="%{consulta.fecha_consulta}"/>
		<s:textfield name="consulta.hora_inicial" label="Hora inicial (hh:mm)" value="%{consulta.hora_inicial}"/>
		<s:textfield name="consulta.hora_final" label="Hora final (hh:mm)" value="%{consulta.hora_final}"/>
		<s:textfield name="consulta.id_empleado" label="Id del empleado" />
		<s:textfield name="consulta.id_sala" label="Id de la sala"/>
		<s:textfield name="consulta.id_paciente" label="Id del paciente" />
		<s:textfield name="consulta.observaciones" label="Observaciones" />
		<s:textfield name="consulta.estado_consulta" label="Estado" value="Programado"/>

		<s:submit value="Reservar"/>
	</s:form>
	<a href="${regresar}">Regresar</a>
</body>
</html>