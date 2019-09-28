<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dueñoRegistrado.jsp</title>
</head>
<body>
	<h1>Dueño Registrado</h1>
	<label>ID: </label><s:property value="owner.id"/><br>
	<label>Nombre: </label><s:property value="owner.nombre"/><br>
	<label>Direccion: </label><s:property value="owner.direccion"/><br>
	<label>Telefeno: </label><s:property value="owner.telefono"/><br>
	<label>RFC: </label><s:property value="owner.rfc"/>
</body>
</html>

