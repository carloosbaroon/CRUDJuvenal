<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user/validarIDPaciente.jsp</title>
</head>

<body>


<s:url action="consultaGeneral2" var="consulta2"> <s:param name="owner.id" value="%{owner.id}" /></s:url>
<s:url action="modificarPaciente1" var="modPaciente"/>
<s:url action="bajaPaciente" var="baPaciente"/>
	
	<p><a href="${consulta2}">Consulta General</a></p>
	<p><a href="${modPaciente}">Modificar Paciente</a></p>	
	<p><a href="${baPaciente}">Baja Paciente </a></p>	
</body>
</html>