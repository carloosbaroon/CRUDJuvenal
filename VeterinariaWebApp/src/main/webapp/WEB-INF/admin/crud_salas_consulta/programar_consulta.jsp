<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Programar Consulta</title>
</head>
<body>
	<h1>Programar Consulta</h1>
	<s:url action="goto_admin_salas" var="regresar"/>
	
	<s:form action="revisar_disponibilidad">
		<s:textfield name="consulta.fecha_consulta" label="Fecha (YYYY/MM/DD)" />
		<s:textfield name="consulta.hora_inicial" label="Hora inicial (hh:mm)" />
		<s:textfield name="consulta.hora_final" label="Hora final (hh:mm)" />

		<s:submit value="Buscar"/>
	</s:form>
	<a href="${regresar}">Regresar</a>
</body>
</html>