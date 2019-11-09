<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Datos del Paciente</h1>

	
	<s:form action="actualizar_paciente">		
		<s:textfield name="paciente.id" label="ID Paciente" value="%{paciente.id}" readonly="true"/>
		<s:textfield name="paciente.name" label="Nombre" value="%{paciente.name}"/>
		<s:textfield name="paciente.categoria" label="Categoria" value="%{paciente.categoria}"/>
		<s:textfield name="paciente.raza" label="Raza" value="%{paciente.raza}"/>
		<s:textfield name="paciente.edad" label="Edad" value="%{paciente.edad}"/>
		<s:submit value="Enviar"/>
	</s:form>
</body>
</html>