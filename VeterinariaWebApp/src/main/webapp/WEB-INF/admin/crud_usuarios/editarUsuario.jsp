<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Editar Usuarios</h1>
	<s:form action="buscar_usuario_editar">
		<s:textfield name="usuario.usuarioID" label="ID del usuario" />
		<s:submit value="Buscar"/>
	</s:form>
</body>
</html>