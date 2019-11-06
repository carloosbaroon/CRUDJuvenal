<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<s:url action="goto_admin_usuarios_jsp" var="regresar"/>
	<h1>Baja Usuarios</h1>
	<s:form action="detalle_baja_usuario">
		<s:textfield name="usuario.usuarioID" label="ID del usuario" />
		<s:submit value="Buscar"/>
	</s:form>
	<a href="${regresar}">Regresar</a>
</body>
</html>