<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<h1>Lista de Usuarios</h1>
<s:url action="goto_consulta_usuarios_jsp" var="consultar_usuarios"/>

<s:form action="validar_campos_usuario">
	<s:textfield name="usuario.usuarioID" label="Usuario"/>
	<s:textfield name="usuario.password" label="Password"/>
	<s:textfield name="usuario.confirmar_password" label="Confirmar Password"/>
	<s:textfield name="usuario.id_empleado_FK" label="Id del Empleado FK"/>
	<s:textfield name="usuario.grupo" label="Grupo"/>
	<s:textfield name="usuario.estado" label="Estado"/>
	<s:submit value="enviar"/>
	<a href="${consultar_usuarios}">Consultar Usuarios</a>
</s:form>
</body>
</html>