package com.reports;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import itesm.business.AtencionBean;
import com.dao.reportes.ReciboDAO;


public class ReporteRecibos extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String message;
	private List<AtencionBean> listRecibos;
	private InputStream inputStream;
	private String filename;
	private String id_atencion;
	
	public List<AtencionBean> getListRecibos() {
		return listRecibos;
	}

	public void setListRecibos(List<AtencionBean> listRecibos) {
		this.listRecibos = listRecibos;
	}

	

	public String getId_atencion() {
		return id_atencion;
	}

	public void setId_atencion(String id_atencion) {
		this.id_atencion = id_atencion;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String execute() throws Exception
	{
		String result = SUCCESS;

		ReciboDAO reciboDao = new ReciboDAO();
		AtencionBean recibo = new AtencionBean();
		reciboDao.setRecibo(recibo);
		try {
			listRecibos = reciboDao.listaRecibos(id_atencion);
			
			JasperReport jasperReport = null;
		    JasperDesign jasperDesign = null;
		    Map parameters = new HashMap();  
		    parameters.put("Title", "Recibos");
		    jasperDesign = JRXmlLoader.load("/Users/luzcatzoli/Documents/WEB/Recibo.jrxml");
		    jasperReport = JasperCompileManager.compileReport(jasperDesign);
		    
			byte[] bytes = JasperRunManager.runReportToPdf(jasperReport, parameters, new JRBeanCollectionDataSource(listRecibos)); 
			
			inputStream = new ByteArrayInputStream(bytes);
			String fileNme = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			filename = "Reporte"+fileNme+".pdf";
			
		} catch (SQLException e) {
			e.printStackTrace();
			this.message = "ERROR (REP0001) Ocurrió un error al consultar el reporte de recibos. Detalle:"+e.getMessage()  ;
			return ERROR;
		}
		
		return result;		
	}
}


