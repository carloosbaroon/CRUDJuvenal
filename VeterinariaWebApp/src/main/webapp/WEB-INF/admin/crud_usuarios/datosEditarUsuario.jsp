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
	
	<s:property value="user_temp.password" var="user_pas"/>
	<s:property value="user_temp.confirmar_password" var="user_conf_pas"/>
	<s:property value="emp_temp.nombre_completo" var="emp_nom"/>
	<s:property value="emp_temp.direccion" var="emp_dir"/>
	<s:property value="emp_temp.telefono" var="emp_tel"/>
	<s:property value="emp_temp.puesto" var="emp_pue"/>
	<s:property value="emp_temp.especialidad" var="emp_esp"/>
	<s:property value="emp_temp.turno" var="emp_tur"/>
	
	<s:form action="dar_baja_usuario">
	
		<label><b>Usuario: </b></label><s:property value="user_temp.usuarioID"/><br>
		<label><b>No. de empleado: </b></label><s:property value="emp_temp.no_empleado"/><br>
	
		<s:textfield name="usuario.password" label="Password" value="${user_pass}"/>
		<s:textfield name="usuario.confirmar_password" label="Confirmar Password" value="${user_conf_pas}"/>
		<s:textfield name="empleado.nombre_completo" label="Nombre Completo" value="${emp_nom}"/>
		<s:textfield name="empleado.direccion" label="Dirección" value="${emp_dir}"/>
		<s:textfield name="empleado.telefono" label="Teléfono" value="${emp_tel}"/>
		<s:textfield name="empleado.puesto" label="Puesto" value="${user_pass}"/>
		<s:textfield name="empleado.especialidad" label="Especialidad Médica" value="${emp_pue}"/>
		<s:textfield name="empleado.turno" label="Turno" value="${emp_esp}"/>
		<s:submit value="Enviar"/>
	</s:form>
</body>
</html>