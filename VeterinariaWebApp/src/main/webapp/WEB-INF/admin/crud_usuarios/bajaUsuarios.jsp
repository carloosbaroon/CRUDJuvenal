<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Baja Usuarios</h1>
	<s:form action="buscar_usuario_baja">
		<s:textfield name="empleado.no_empleado" label="No de Empleado" />
		<s:submit value="Enviar"/>
	</s:form>
</body>
</html>