package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.database.DAOEmpleado;
import itesm.database.DAOEmpleadoImpl;

public class ControlarFormUsuario extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private ArrayList<String> lista_empleados_frontend, list_grupos_privilegios_frontend, list_estado_frontend;
	private ArrayList<EmpleadoBean> buffer_empleado;

	

	public ArrayList<String> getLista_empleados_frontend() {
		return lista_empleados_frontend;
	}



	public void setLista_empleados_frontend(ArrayList<String> lista_empleados_frontend) {
		this.lista_empleados_frontend = lista_empleados_frontend;
	}



	public ArrayList<String> getList_grupos_privilegios_frontend() {
		return list_grupos_privilegios_frontend;
	}



	public void setList_grupos_privilegios_frontend(ArrayList<String> list_grupos_privilegios_frontend) {
		this.list_grupos_privilegios_frontend = list_grupos_privilegios_frontend;
	}



	public ArrayList<String> getList_estado_frontend() {
		return list_estado_frontend;
	}



	public void setList_estado_frontend(ArrayList<String> list_estado_frontend) {
		this.list_estado_frontend = list_estado_frontend;
	}



	public String execute() throws Exception {
		buffer_empleado = new ArrayList<EmpleadoBean>();
		
		//1. Recuperar el id del empleado(Opcional junto con su Nombre)
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		buffer_empleado= daoEmpleado.consultarEmpleados();
		
		this.lista_empleados_frontend = new ArrayList<String>();
		for(EmpleadoBean item : buffer_empleado) {
			lista_empleados_frontend.add(item.getId_empleado());
		}
		
		
		//Agregar datos en el list 'grupo' del jsp 'alta usuarios'
		this.list_grupos_privilegios_frontend = new ArrayList<String>();
		this.list_grupos_privilegios_frontend.add("Administrador");
		this.list_grupos_privilegios_frontend.add("Usuario");
		//Agregar datos en el list 'estado' del jsp 'alta usuarios'
		this.list_estado_frontend = new ArrayList<String>();
		this.list_estado_frontend.add("Activo");
		this.list_estado_frontend.add("Bloqueado");
		this.list_estado_frontend.add("Inactivo");
		
		return SUCCESS;
	}
}
