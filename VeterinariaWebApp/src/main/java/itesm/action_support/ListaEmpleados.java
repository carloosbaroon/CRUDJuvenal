package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.database.DAOEmpleado;
import itesm.database.DAOEmpleadoImpl;

public class ListaEmpleados extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session_empleados;
	private ArrayList<EmpleadoBean> buffer_empleados;
	
	public String execute() {
		//1. Obtener la tabla empleados con todos sus registros
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		try {
			this.buffer_empleados = daoEmpleado.consultarEmpleados(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public ArrayList<EmpleadoBean> getBuffer_empleados() {
		return buffer_empleados;
	}
}
