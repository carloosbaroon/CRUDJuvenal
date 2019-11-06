<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>altaPaciente.jsp</title>
</head>
<body>
	<h1>Alta Paciente</h1>
	<s:form action="finalPaciente">
		<s:textfield name="paciente.idOwner" label="ID Dueño" value="%{owner.id}" readonly="true"/>
		<s:textfield name="paciente.id" label="ID Paciente" />
		<s:textfield name="paciente.name" label="Nombre" />
		<s:textfield name="paciente.categoria" label="Categoria" />
		<s:textfield name="paciente.raza" label="Raza"/>
		<s:textfield name="paciente.edad" label="Edad"/>
		<s:hidden name="owner.id"></s:hidden>

		<s:submit value="Enviar"/>
	</s:form>
	
</body>
</html>