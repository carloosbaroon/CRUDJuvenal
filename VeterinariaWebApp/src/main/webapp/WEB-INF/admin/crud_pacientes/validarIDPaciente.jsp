<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user/validarIDPaciente.jsp</title>
</head>

<body>
<s:form action="capturar_datos_paciente">
    <s:textfield name="owner.id" label="Id Dueño" />
    <s:submit value="Enviar" />
</s:form>
</body>
</html>