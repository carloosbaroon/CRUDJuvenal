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
	
		<label><b>Usuario: </b></label><s:property value="usuario.usuarioID"/><br>
		<label><b>No. de empleado: </b></label><s:property value="empleado.no_empleado"/><br>
	
		<s:textfield name="usuario.password" label="Password"/>
		<s:textfield name="usuario.confirmar_password" label="Confirmar Password"/>
		<s:textfield name="empleado.nombre_completo" label="Nombre Completo"/>
		<s:textfield name="empleado.direccion" label="Dirección"/>
		<s:textfield name="empleado.telefono" label="Teléfono"/>
		<s:textfield name="empleado.puesto" label="Puesto"/>
		<s:textfield name="empleado.especialidad" label="Especialidad Médica"/>
		<s:textfield name="empleado.turno" label="Turno"/>
		<s:submit value="Enviar"/>
	</s:form>
</body>
</html>