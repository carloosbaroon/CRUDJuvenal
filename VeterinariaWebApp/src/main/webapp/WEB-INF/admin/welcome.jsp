<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Bienvenida</title>
</head>
<body>
<h1>Bienvenida</h1>

<s:url action="goto_crear_admin_jsp" var="goto_crear_admin"/>
<s:url action="goto_login_jsp" var="goto_login"/>

<a href="${goto_crear_admin}">Crear Admin</a>
<br>
<a href="${goto_login}">Ir a Login</a>
</body>
</html>