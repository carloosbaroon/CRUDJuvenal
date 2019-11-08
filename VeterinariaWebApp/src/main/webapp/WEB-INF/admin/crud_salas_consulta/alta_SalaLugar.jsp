<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Sala</title>
</head>
<body>
	<h1>Alta Sala</h1>
	<s:url action="goto_admin_salas" var="regresar"/>
	
	<s:form action="validar_campos_sala">
		<s:textfield name="sala.id_sala" label="Id de la Sala" />
		<s:textfield name="sala.nombre_sala" label="Nombre de la Sala" />
       <s:select label="Estado de la Sala" 
		headerKey="-1" headerValue="Selecciona un estado"
		list="list_estado_sala"
		name="sala.estado"/>

		<s:submit value="Enviar"/>
	</s:form>
	<a href="${regresar}">Regresar</a>
</body>
</html>