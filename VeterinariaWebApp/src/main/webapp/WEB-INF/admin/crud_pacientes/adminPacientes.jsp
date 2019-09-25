<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Administraci�n de Pacientes</h1>
	
	<s:url action="goto_alta_owner_jsp" var="alta_owner"/>
	<s:url action="goto_alta_paciente_jsp" var="alta_paciente"/>
	<s:url action="goto_modificar_owner_jsp" var="modificar_owner"/>
	<s:url action="goto_modificar_paciente_jsp" var="modificar_paciente"/>
	
	<p><a href="${alta_owner}">Dar de Alta Due�o</a></p>	
	<p><a href="${alta_paciente}">Dar de Alta Paciente</a></p>	
	<p><a href="${modificar_owner}">Modificar Due�o</a></p>
	<p><a href="${modificar_paciente}">Modificar Paciente</a></p>
</body>
</html>