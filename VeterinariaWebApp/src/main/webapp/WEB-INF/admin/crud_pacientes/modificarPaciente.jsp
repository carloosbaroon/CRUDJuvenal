<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user/editarPaciente.jsp</title>
</head>

<body>
<s:form action="">
	<s:textfield name="paciente.id" label="ID" />
    <s:textfield name="paciente.name" label="Nombre" />
    <s:textfield name="paciente.categoria" label="Categoria" />
    <s:textfield name="paciente.raza" label="Raza" /> 
	<s:textfield name="paciente.edad" label="Edad" />
	<s:hidden name="owner.id"></s:hidden>
    <s:submit value="Confirmar cambios" />
</s:form>
</body>
</html>