<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<s:url action="goto_programar_consulta_jsp" var="regresar"/>
	<!-- <h1><s:property value="mensajeError"/></h1> -->
	<h1>No hay salas disponibles</h1>
	<h2>Por favor regresar y modificar los parametros de busqueda</h2>
	<a href="${regresar}">Regresar</a>
	
</body>
</html>