<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>altaDueño.jsp</title>
</head>
<body>
	<h1>Alta Dueño Prueba</h1>
	<s:form action="capturar_datos_owner">
	<s:textfield name="owner.id" label="ID" />
		<s:textfield name="owner.nombre" label="Nombre" />
		<s:textfield name="owner.direccion" label="Direccion" />
		<s:textfield name="owner.telefono" label="Telefono"/>
		<s:textfield name="owner.rfc" label="RFC"/>


		<s:submit value="Enviar"/>
	</s:form>
	
</body>
</html>


