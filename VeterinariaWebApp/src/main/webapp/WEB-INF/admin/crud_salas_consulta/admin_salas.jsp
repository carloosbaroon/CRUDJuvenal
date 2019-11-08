<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administración de salas</title>
</head>
<body>
	<s:url action="goto_alta_sala_jsp" var="alta_sala"/>
	<s:url action="goto_editar_salas_jsp" var="editar_sala"/>
	<s:url action="goto_programar_consulta" var="reservar_sala"/>
	
	<p><a href="${alta_sala}">Alta de Salas</a></p>
	<p><a href="${editar_sala}">Editar Salas</a></p>		
	<p><a href="${reservar_sala}">Reservar Salas</a></p>
</body>
</html>