<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user/validarID.jsp</title>
</head>

<body>
<s:form action="detalle_editar_owner">
    <s:textfield name="owner.id" label="Id Dueño" />
    <s:submit value="Enviar" />
</s:form>
</body>
</html>
