<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<body>
	<h1>Menu</h1>
	
	<s:url action="goto_admin_pacientes_jsp" var="admin_pacientes"/>
	<s:url action="goto_admin_salas_jsp" var="admin_salas"/>
	
	<p><a href="${admin_pacientes}">Administración de Pacientes</a></p>
	<p><a href="${admin_salas}">Administración de Salas</a></p>
</body>
</html>