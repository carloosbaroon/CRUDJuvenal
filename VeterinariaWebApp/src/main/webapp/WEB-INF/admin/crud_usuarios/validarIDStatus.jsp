<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user/validarID.jsp</title>
</head>

<body>
<s:form action="modificarStatus">
    <s:textfield name="usuario.usuarioID" label="Id Usuario" />
    <s:submit value="Enviar" />
</s:form>
</body>
</html>
