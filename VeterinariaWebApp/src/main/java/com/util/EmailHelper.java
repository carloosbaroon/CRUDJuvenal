package com.util;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.naming.InitialContext;

public class EmailHelper {

  private String header = "<!DOCTYPE html><html><head><style>"+
		  "/* Font Definitions */"+
		  " @font-face"+
		  " 	{font-family:'Cambria Math';"+
		  " 	panose-1:2 4 5 3 5 4 6 3 2 4;}"+
		  " @font-face"+
		  " 	{font-family:Calibri;"+
		  " 	panose-1:2 15 5 2 2 2 4 3 2 4;}"+
		  " /* Style Definitions */"+
		  " p.MsoNormal, li.MsoNormal, div.MsoNormal"+
		  " 	{margin:0cm;"+
		  " 	margin-bottom:.0001pt;"+
		  " 	font-size:12.0pt;"+
		  " 	font-family:'Times New Roman',serif;}"+
		  " h2"+
		  " 	{mso-style-priority:9;"+
		  " 	mso-style-link:'Título 2 Car';"+
		  " 	mso-margin-top-alt:auto;"+
		  " 	margin-right:0cm;"+
		  " 	mso-margin-bottom-alt:auto;"+
		  " 	margin-left:0cm;"+
		  " 	font-size:18.0pt;"+
		  " 	font-family:'Times New Roman',serif;"+
		  " 	font-weight:bold;}"+
		  " a:link, span.MsoHyperlink"+
		  " 	{mso-style-priority:99;"+
		  " 	color:blue;"+
		  " 	text-decoration:underline;}"+
		  " a:visited, span.MsoHyperlinkFollowed"+
		  " 	{mso-style-priority:99;"+
		  " 	color:purple;"+
		  " 	text-decoration:underline;}"+
		  " p"+
		  " 	{mso-style-priority:99;"+
		  " 	mso-margin-top-alt:auto;"+
		  " 	margin-right:0cm;"+
		  " 	mso-margin-bottom-alt:auto;"+
		  " 	margin-left:0cm;"+
		  " 	font-size:12.0pt;"+
		  " 	font-family:'Times New Roman',serif;}"+
		  " span.Ttulo2Car"+
		  " 	{mso-style-name:'Título 2 Car';"+
		  " 	mso-style-priority:9;"+
		  " 	mso-style-link:'Título 2';"+
		  " 	font-family:'Calibri Light',sans-serif;"+
		  " 	color:#2E74B5;}"+
		  " span.EstiloCorreo19"+
		  " 	{mso-style-type:personal-reply;"+
		  " 	font-family:'Calibri',sans-serif;"+
		  " 	color:#1F497D;}"+
		  " .MsoChpDefault"+
		  " 	{mso-style-type:export-only;"+
		  " 	font-family:'Calibri',sans-serif;}"+
		  " </style></head> <body> ";

   /** 
	 * Method to send Email with html format
	 * @param to recipient(s) separated by ;
	 * @param subject subject to show on the e-mail
	 * @param body information to send on HTML format
	 * @return continue=If everything works as planned, error=In case of any issue
	 */
   public String sendHtmlMail(String to, String subject, String body) throws Exception {
//	   String fileAttachment = "C:/TMP/Test.jsp";
	   body = header + body;
	   String estatus = "continue";
	   System.out.println("Como se envia to:" + to);
	   to = "carlostectol@gmail.com";
	   String[] recipient = to.split(";");
	   
	   
	    	InitialContext initContext = new InitialContext(); 
	    	Session session = (Session) initContext.lookup("java:comp/env/mail/gmailSession");
	    	MimeMessage message = new MimeMessage(session);
     
           message.setFrom(new InternetAddress("no-reply@gmail.com"));
           InternetAddress[] toAddress = new InternetAddress[recipient.length];

           // To get the array of addresses
           for( int i = 0; i < recipient.length; i++ ) {
               toAddress[i] = new InternetAddress(recipient[i]);
           }

           for( int i = 0; i < toAddress.length; i++) {
               message.addRecipient(Message.RecipientType.TO, toAddress[i]);
           }

           message.setSubject(subject);
           // create the message part 
   	    MimeBodyPart messageBodyPart = 
   	      new MimeBodyPart();

   	    //fill message
   	    messageBodyPart.setContent(body, "text/html");

   	    Multipart multipart = new MimeMultipart();
   	    multipart.addBodyPart(messageBodyPart);

   	    // Part two is attachment
//   	    messageBodyPart = new MimeBodyPart();
//   	    DataSource source = 
//   	      new FileDataSource(fileAttachment);
//   	    messageBodyPart.setDataHandler(
//   	      new DataHandler(source));
//   	    messageBodyPart.setFileName(fileAttachment);
//   	    multipart.addBodyPart(messageBodyPart);

   	    // Put parts in message
   	    message.setContent(multipart);
           
           Transport.send(message);
       
	
	return estatus;
   }
}