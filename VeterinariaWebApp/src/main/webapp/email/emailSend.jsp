<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
   <head>
   <title>Email Form</title>
   </head>
   
   <body>
      <em>La forma utiliza el SMTP de Google SMTP. 
         Por favor introduzca su usuario y password de gmail.
      </em>
      
      <form action = "emailer" method = "post">
         <label for = "to">To</label><br/>
         <input type = "text" name = "to"/><br/>
         <label for = "subject">Subject</label><br/>
         <input type = "text" name = "subject"/><br/>
         <label for = "body">Body</label><br/>
		 <textarea name="body" rows="10" cols="30"></textarea><br/>
         <input type = "submit" value = "Send Email"/>
      </form>
   </body>
</html>