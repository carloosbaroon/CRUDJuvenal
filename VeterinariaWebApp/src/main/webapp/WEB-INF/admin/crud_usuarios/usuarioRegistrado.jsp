<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<h1>Usuario Registrado</h1>
	<s:url action="goto_alta_usuario_jsp" var="ir_atras"/>
	
	<p>Usuario: </p> <s:property value="usuario.usuarioID"/>
	<p>password: </p> <s:property value="usuario.password"/>
	<p>confirmar_password: </p> <s:property value="usuario.confirmar_password"/>
	<p>id_empleado_FK: </p> <s:property value="usuario.id_empleado_FK"/>
	<p>grupo: </p> <s:property value="usuario.grupo"/>
	<p>estado: </p> <s:property value="usuario.estado"/>
	<br>
	<a href="${ir_atras}">Regresar</a>
</body>
</html>