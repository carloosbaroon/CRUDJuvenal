package com.quartz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.InitialContext;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import itesm.business.ConsultaBean;
import itesm.business.SalaBean;
import itesm.database.DAO_Implementation.DAOConsultaImpl;
import itesm.database.DAO_Implementation.DAOSalasImpl;
import itesm.database.DAO_Interfaces.DAOSalas;

public class SchedulerJob implements Job {
	private ArrayList<ConsultaBean> bufferConsultas;
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			buscarConsultas();
			//sendHtmlMail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ConsultaBean> buscarConsultas() throws Exception{
		DAOConsultaImpl daoConsulta = new DAOConsultaImpl();
		
		this.bufferConsultas = daoConsulta.consultaGeneral();	
		
		for(ConsultaBean bean: bufferConsultas) {
	    	  String idConsulta = bean.getId_consulta();
	    	  String fechaConsulta = bean.getFecha_consulta();
	    	  String horaInicial = bean.getHora_inicial();
	    	  String horaFinal = bean.getHora_final();
	    	  String idEmpleado = bean.getId_empleado();
	    	  String idSala = bean.getId_sala();
	    	  String idPaciente = bean.getId_consulta();
	    	  String observacion = bean.getObservaciones();
	    	  String estado = bean.getEstado_consulta();
	    	  String correo = bean.getCorreo();
	    	  
	    	  System.out.println(" " + bean.getId_paciente());
	    	  System.out.println(" " + bean.getHora_inicial());
	    	  sendHtmlMail(idConsulta, fechaConsulta, horaInicial, horaFinal, idEmpleado, idSala, idPaciente, observacion, estado, correo);
	      }
		
		
		return bufferConsultas;
	
		
	}
	
	public void sendHtmlMail(String idConsulta, String fechaConsulta, String horaInicial, String horaFinal, String idEmpleado, String idSala, String idPaciente, String observacion, String estado, String correo) throws Exception{
		//System.out.println("Struts 2 + Quartz 2");
				String header = "<!DOCTYPE html><html><head><style>"+
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
				
				
				
				String body = "Su consulta No: " + idConsulta + "\nCon la fecha: " + fechaConsulta + "\nA la hora: "+ horaInicial + "\nY finaliza a las: " + horaFinal + "\nEn la sala No: " + idSala + "\nCon el paciente: " + idPaciente + "\nCon las siguientes observaciones: " + observacion;
				String to = correo;
				String subject = "test";
				body = header + body;
				   String estatus = "continue";
				   System.out.println("Como se envia to:" + to);
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
//			   	    messageBodyPart = new MimeBodyPart();
//			   	    DataSource source = 
//			   	      new FileDataSource(fileAttachment);
//			   	    messageBodyPart.setDataHandler(
//			   	      new DataHandler(source));
//			   	    messageBodyPart.setFileName(fileAttachment);
//			   	    multipart.addBodyPart(messageBodyPart);

			   	    // Put parts in message
			   	    message.setContent(multipart);
			           
			        Transport.send(message);      
	}
}