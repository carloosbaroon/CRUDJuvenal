package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;

public class ListaEmpleados extends ActionSupport implements SessionAware{
	private Map<String, Object> session_empleados;
	private EmpleadoBean empleado;
	private ArrayList<EmpleadoBean> buffer_empleados;
	private final String TABLA = "empleado";
	
	public String execute() {
		//1. Obtener la tabla empleados con todos sus registros
		this.buffer_empleados = (ArrayList<EmpleadoBean>)this.session_empleados.get(TABLA);
		
		return SUCCESS;
	}
	
	public ArrayList<EmpleadoBean> getBuffer_empleados() {
		return buffer_empleados;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session_empleados = session;	
	}

	


	
	

}
