package com.reports;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import com.dao.reportes.*;
import itesm.business.*;

public class ReporteFacturas extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private AtencionBean factura;

	private ArrayList<AtencionBean> buffer_facturas;
	private String mensajeError;
	private String date_start, date_finish;



	
	

	
	public AtencionBean getFactura() {
		return factura;
	}







	public void setFactura(AtencionBean factura) {
		this.factura = factura;
	}







	public ArrayList<AtencionBean> getBuffer_facturas() {
		return buffer_facturas;
	}







	public void setBuffer_facturas(ArrayList<AtencionBean> buffer_facturas) {
		this.buffer_facturas = buffer_facturas;
	}







	public String getMensajeError() {
		return mensajeError;
	}







	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}







	public String getDate_start() {
		return date_start;
	}







	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}







	public String getDate_finish() {
		return date_finish;
	}







	public void setDate_finish(String date_finish) {
		this.date_finish = date_finish;
	}







	public String mostrarListaFacturas() {
		//1. Obtener la tabla empleados con todos sus registros
		FacturaDAO daoFactura = new FacturaDAO();
		try {
			this.buffer_facturas = daoFactura.listaFacturas(date_start, date_finish);
			
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.mensajeError = "Error al mostrar la lista de facturas";
			return ERROR;
		}
	}
	
	

}