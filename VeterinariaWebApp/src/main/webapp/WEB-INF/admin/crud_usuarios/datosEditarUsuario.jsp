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

	
	<s:form action="actualizar_usuario">		
		<s:textfield name="usuario.usuarioID" label="Usuario" value="%{usuario.usuarioID}" readonly="true"/>
		<s:textfield name="empleado.id_empleado" label="ID Empleado" value="%{empleado.id_empleado}" readonly="true"/>
		<s:textfield name="usuario.password" label="Password" value="%{usuario.password}"/>
		<s:textfield name="usuario.confirmar_password" label="Confirmar Password" value="%{usuario.confirmar_password}"/>
		<s:textfield name="empleado.nombre_completo" label="Nombre Completo" value="%{empleado.nombre_completo}"/>
		<s:textfield name="empleado.direccion" label="Dirección" value="%{empleado.direccion}"/>
		<s:textfield name="empleado.telefono" label="Teléfono" value="%{empleado.telefono}"/>
		<s:textfield name="empleado.puesto" label="Puesto" value="%{empleado.puesto}"/>
		<s:textfield name="empleado.especialidad" label="Especialidad Médica" value="%{empleado.especialidad}"/>
		<s:textfield name="empleado.turno" label="Turno" value="%{empleado.turno}"/>
		<s:submit value="Enviar"/>
	</s:form>
</body>
</html>