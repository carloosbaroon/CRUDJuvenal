<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user/validarIDPaciente.jsp</title>
</head>

<body>
<s:form action="modificarPaciente2">
    <s:textfield name="paciente.id" label="Id Paciente" />
    <s:submit value="Enviar" />
</s:form>
</body>
</html>