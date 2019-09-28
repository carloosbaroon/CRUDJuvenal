<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>users/finUsuario</title>
</head>

<body>
<h2><p>Cambio exitoso</p></h2>
<h2>Id: <s:property value="owner.id"/></h2>
<h2>Nombre: <s:property value="owner.nombre"/></h2>
<h2>Direccion: <s:property value="owner.direccion"/></h2>
<h2>Telefono: <s:property value="owner.telefono"/></h2>
<h2>RFC: <s:property value="owner.rfc"/></h2>
</body>
</html>
