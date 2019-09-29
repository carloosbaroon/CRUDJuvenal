<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>users/finPaciente</title>
</head>

<body>
<h2><p>Cambio exitoso</p></h2>
<h2>Id: <s:property value="paciente.id"/></h2>
<h2>Nombre: <s:property value="paciente.name"/></h2>
<h2>Categoria: <s:property value="paciente.categoria"/></h2>
<h2>Raza: <s:property value="paciente.raza"/></h2>
<h2>Edad: <s:property value="paciente.edad"/></h2>

<s:url action="regresar" var="regresar2"> </s:url>

	<p><a href="${regresar2}"> Regresar </a></p>
</body>
</html>