<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pacienteRegistrado.jsp</title>
</head>
<body>
	<h1>Paciente Registrado</h1>
	<label>ID: </label><s:property value="paciente.id"/><br>
	<label>Nombre: </label><s:property value="paciente.name"/><br>
	<label>Categoría: </label><s:property value="paciente.categoria"/><br>
	<label>Raza: </label><s:property value="paciente.raza"/><br>
	<label>Edad: </label><s:property value="paciente.edad"/><br>
	<label>ID Dueño: </label><s:property value="paciente.idOwner"/>
</body>
</html>