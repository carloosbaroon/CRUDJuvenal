<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
   <head>
      <title>Email Error</title>
   </head>
   
   <body>
      Ocurrió un problema al enviar el correo a: <s:property value = "to"/>.
      Error: <s:property value = "message"/>.
   </body>
</html>