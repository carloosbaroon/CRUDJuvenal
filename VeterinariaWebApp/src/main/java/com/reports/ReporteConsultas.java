package com.reports;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import com.dao.reportes.*;
import itesm.business.*;

public class ReporteConsultas extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ConsultaBean consulta;

	private ArrayList<ConsultaBean> buffer_consultas;
	private String mensajeError;
	private String date_start, date_finish, paciente_id;


	public ConsultaBean getConsulta() {
		return consulta;
	}
	public void setConsulta(ConsultaBean consulta) {
		this.consulta = consulta;
	}
	public ArrayList<ConsultaBean> getBuffer_consultas() {
		return buffer_consultas;
	}
	public void setBuffer_consultas(ArrayList<ConsultaBean> buffer_consultas) {
		this.buffer_consultas = buffer_consultas;
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
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	public String getPaciente_id() {
		return paciente_id;
	}
	public void setPaciente_id(String paciente_id) {
		this.paciente_id = paciente_id;
	}
	
	

	
	public String mostrarListaConsultas() {
		//1. Obtener la tabla empleados con todos sus registros
		ConsultaDAO daoConsulta = new ConsultaDAO();
		try {
			this.buffer_consultas = daoConsulta.listaConsultas(paciente_id, date_start, date_finish);
			
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.mensajeError = "Error al mostrar la lista de Pacientes";
			return ERROR;
		}
	}
	
	

}