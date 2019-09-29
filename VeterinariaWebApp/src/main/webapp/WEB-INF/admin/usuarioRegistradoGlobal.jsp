<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<h1>Usuario Registrado Global</h1>
	<s:url action="goto_crear_admin_jsp" var="ir_atras"/>
	
	<b>Usuario: </b><s:property value="usuario.usuarioID"/><br>
	<b>password: </b><s:property value="usuario.password"/><br>
	<b>confirmar_password: </b> <s:property value="usuario.confirmar_password"/><br>
	<b>id_empleado_FK: </b> <s:property value="usuario.id_empleado_FK"/><br>
	<b>grupo: </b><s:property value="usuario.grupo"/><br>
	<b>estado: </b><s:property value="usuario.estado"/><br>
	<a href="${ir_atras}">Regresar</a>
</body>
</html>