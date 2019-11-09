<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Eliminar Paciente</h1>
	
	<s:form action="confirmar_baja_paciente">
		<s:textfield name="paciente.id" value="%{paciente.id}" readonly="true"/>
		<s:textfield name="paciente.name" value="%{paciente.name}" readonly="true"/>
		<s:textfield name="paciente.categoria" value="%{paciente.categoria}" readonly="true"/>
		<s:textfield name="paciente.raza" value="%{paciente.raza}" readonly="true"/>
		<s:textfield name="paciente.edad" value="%{paciente.edad}" readonly="true"/>
		<s:submit>Confirmar</s:submit>
	</s:form>

</body>
</html>