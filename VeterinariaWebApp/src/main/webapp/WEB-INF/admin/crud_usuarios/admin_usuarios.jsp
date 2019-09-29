<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administración de usuarios</title>
</head>
<body>
	<s:url action="goto_alta_usuario_jsp" var="alta_usuarios"/>
	<s:url action="goto_alta_empleado_jsp" var="alta_empleados"/>
	<s:url action="goto_baja_jsp" var="baja_usuarios"/>
	<s:url action="goto_editar_usuario_jsp" var="cambios_usuarios"/>
	<s:url action="goto_bloqueo_desbloqueo_jsp" var="bloqueo_desbloqueo_usuarios"/>
	
	<p><a href="${alta_usuarios}">Alta de Usuarios</a></p>
	<p><a href="${alta_empleados}">Alta de Empleados</a></p>		
	<p><a href="${baja_usuarios}">Baja de Usuarios</a></p>	
	<p><a href="${cambios_usuarios}">Editar Usuarios (Bloqueo/Desbloqueo)</a></p>
	<p><a href="${bloqueo_desbloqueo_usuarios}">Bloquear/Desbloquear Usuarios</a></p>
</body>
</html>