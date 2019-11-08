package itesm.action_support;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.ConsultaBean;

public class ConsultaAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private ConsultaBean consulta;
	private ArrayList<String> list_estado_sala;
	private ArrayList<ConsultaBean> buffer_salas;
	private String mensajeError;
	
	public ConsultaBean getConsulta() {return consulta;}
	public void setConsulta(ConsultaBean consulta) {this.consulta = consulta;}
	public ArrayList<ConsultaBean> getBuffer_salas() {return buffer_salas;}
	public void setBuffer_salas(ArrayList<ConsultaBean> buffer_salas) {this.buffer_salas = buffer_salas;}

}
