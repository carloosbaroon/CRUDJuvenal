<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Datos del empleado</h1>
		<label><b>Usuario</b></label><br>
		<s:property value="usuario.usuarioID"/><br>
		<label><b>Password</b></label><br>
		<s:property value="usuario.password"/><br>
		<label><b>Grupo</b></label><br>
		<s:property value="usuario.privilegios"/><br>
		<label><b>Estado</b></label><br>
		<s:property value="usuario.estado"/><br>
		<label><b>Número de Empleado</b></label><br>
		<s:property value="empleado.id_empleado"/><br>
		<label><b>Nombre Completo</b></label><br>
		<s:property value="empleado.nombre_completo"/><br>
		<label><b>Dirección</b></label><br>
		<s:property value="empleado.direccion"/><br>
		<label><b>Teléfono</b></label><br>
		<s:property value="empleado.telefono"/><br>
		<label><b>Puesto</b></label><br>
		<s:property value="empleado.puesto"/><br>
		<label><b>Especialidad Médica</b></label><br>
		<s:property value="empleado.especialidad"/><br>
		<label><b>Estado</b></label><br>
		<s:property value="empleado.estado"/><br>		
		
		<textarea rows="7" cols="80"></textarea>
		
		<s:url action="dar_baja_usuario" var="url_baja">
       		<s:param name = "qs_user_id">${usuario.usuarioID}</s:param>
      	</s:url>
      	
      	<a href = '<s:property value = "#url_baja"/>'>
      		<s:property value = "#url_baja"/>
    	</a>
	
	
</body>
</html>