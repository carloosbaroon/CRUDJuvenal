package com.util;

import com.opensymphony.xwork2.ActionSupport;

public class Emailer extends ActionSupport {

   public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

private static final long serialVersionUID = 1L;
   private String to;
   private String subject;
   private String body;
   private String message;
   
   public String getTo() {
	   return to;
   }

   public void setTo(String to) {
	   this.to = to;
   }

   public String getSubject() {
	   return subject;
   }

   public void setSubject(String subject) {
	   this.subject = subject;
   }

  

   public String getMessage() {
	   return message;
   }

   public void setMessage(String message) {
	   this.message = message;
   }

   public String execute() {
	   String ret = SUCCESS;
	   try{
		   EmailHelper email = new EmailHelper();
		   email.sendHtmlMail(to, subject, body);
	   }catch (Exception e){
		   message = " Ocurrio un error al enviar el correo121:"+e.getMessage();
		   return ERROR;
	   }
	   return ret;
   }

}