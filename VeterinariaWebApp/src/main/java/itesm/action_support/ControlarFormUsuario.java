package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;

public class ControlarFormUsuario extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private ArrayList<String> list_empleados_fk, list_grupos_privilegios, list_estado;
	private ArrayList<EmpleadoBean> buffer_empleado;
	private Map<String, Object> session_empleados;//Servira para accesar a los registros de los empleados
	
	public void setList_empleados_fk(ArrayList<String> list_empleados_fk) {
		this.list_empleados_fk = list_empleados_fk;
	}

	public ArrayList<String> getList_grupos_privilegios() {
		return list_grupos_privilegios;
	}

	public void setList_grupos_privilegios(ArrayList<String> list_grupos_privilegios) {
		this.list_grupos_privilegios = list_grupos_privilegios;
	}

	public ArrayList<String> getList_empleados_fk() {
		return list_empleados_fk;
	}

	public String execute() throws Exception {
		list_empleados_fk = new ArrayList<String>();
		
		//1. Recuperar el id del empleado(Opcional junto con su Nombre)
		this.buffer_empleado = (ArrayList<EmpleadoBean>)this.session_empleados.get(Tabla.TABLA_EMPLEADO);		
		
		
		//Agregar datos en el list 'grupo' del jsp 'alta usuarios'
		this.list_grupos_privilegios = new ArrayList<String>();
		this.list_grupos_privilegios.add("Administrador");
		this.list_grupos_privilegios.add("Usuario");
		//Agregar datos en el list 'estado' del jsp 'alta usuarios'
		this.list_estado = new ArrayList<String>();
		this.list_estado.add("Activo");
		this.list_estado.add("Bloqueado");
		this.list_estado.add("Inactivo");
		
		return SUCCESS;
	}

	public ArrayList<String> getList_estado() {
		return list_estado;
	}

	public void setList_estado(ArrayList<String> list_estado) {
		this.list_estado = list_estado;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session_empleados = session;
		
	}
}
