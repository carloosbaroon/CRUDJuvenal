<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Datos de la sala</h1>

	<s:form action="actualizar_sala">		
		<s:textfield name="sala.id_sala" label="ID sala" value="%{sala.id_sala}" readonly="true"/>
		<s:textfield name="sala.nombre_sala" label="Nombre sala" value="%{sala.nombre_sala}"/>
		<s:textfield name="sala.estado_sala" label="Estado sala" value="%{sala.estado_sala}"/>
		<s:submit value="Enviar"/>
	</s:form>
</body>
</html>