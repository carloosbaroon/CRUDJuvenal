<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<h1>Alta de Usuarios</h1>
<s:url action="goto_consulta_usuario_jsp" var="consultar_usuarios"/>
<s:url action="goto_admin_usuarios_jsp" var="regresar"/>
<a href="${consultar_usuarios}">Consultar Usuarios</a>

<s:form action="validar_campos_usuario">
	<s:textfield name="usuario.password" label="Password"/>
	<s:textfield name="usuario.confirmar_password" label="Confirmar Password"/>
	<s:select label="Empleados Disponibles"
	headerValue="Selecciona un empleado" 
	headerKey="-1"
	list="list_empleados_fk"
	name="usuario.id_empleado_FK"
	/>
	<s:select label="Grupo/Privilegios"
	headerValue="Elige un grupo" 
	headerKey="-1"
	list="list_grupos_privilegios"
	name="usuario.grupo"
	/>
	<s:select label="Estado"
	headerValue="Elige un estado" 
	headerKey="-1"
	list="list_estado"
	name="usuario.estado"
	/>
	<s:submit value="enviar"/>
</s:form>
<a href="${regresar}">Regresar</a>
</body>
</html>