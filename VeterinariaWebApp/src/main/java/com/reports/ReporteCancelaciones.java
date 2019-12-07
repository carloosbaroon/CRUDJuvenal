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
import itesm.business.CancelacionBean;
import com.dao.reportes.CancelacionDAO;


public class ReporteCancelaciones extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String message;
	private List<CancelacionBean> listCancelaciones;
	private InputStream inputStream;
	private String filename;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<CancelacionBean> getListCancelaciones() {
		return listCancelaciones;
	}
	
	public void setListCancelaciones(List<CancelacionBean> listCancelaciones) {
		this.listCancelaciones = listCancelaciones;
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

		CancelacionDAO cancelacionDao = new CancelacionDAO();
		CancelacionBean cancelacion = new CancelacionBean();
		cancelacionDao.setCancelacion(cancelacion);
		try {
			listCancelaciones = cancelacionDao.listaCancelaciones();
			
			JasperReport jasperReport = null;
		    JasperDesign jasperDesign = null;
		    Map parameters = new HashMap();  
		    parameters.put("Title", "Lista Cancelaciones");
		    jasperDesign = JRXmlLoader.load("/Users/luzcatzoli/Documents/WEB/ReporteCancelaciones.jrxml");
		    jasperReport = JasperCompileManager.compileReport(jasperDesign);
		    
			byte[] bytes = JasperRunManager.runReportToPdf(jasperReport, parameters, new JRBeanCollectionDataSource(listCancelaciones)); 
			
			inputStream = new ByteArrayInputStream(bytes);
			String fileNme = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			filename = "Reporte"+fileNme+".pdf";
			
		} catch (SQLException e) {
			e.printStackTrace();
			this.message = "ERROR (REP0001) Ocurrió un error al consultar el reporte de cancelacions. Detalle:"+e.getMessage()  ;
			return ERROR;
		}
		
		return result;		
	}
}


