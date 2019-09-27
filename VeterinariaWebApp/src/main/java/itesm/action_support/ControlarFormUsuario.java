package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;

public class ControlarFormUsuario extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private ArrayList<String> list_empleados_fk;
	private ArrayList<EmpleadoBean> buffer_empleado;
	private Map<String, Object> session_empleados;//Servira para accesar a los registros de los empleados
	
	public void setList_empleados_fk(ArrayList<String> list_empleados_fk) {
		this.list_empleados_fk = list_empleados_fk;
	}

	public ArrayList<String> getList_empleados_fk() {
		return list_empleados_fk;
	}

	public String execute() throws Exception {
		list_empleados_fk = new ArrayList<String>();
		
		//1. Recuperar el id del empleado(Opcional junto con su Nombre)
		this.buffer_empleado = (ArrayList<EmpleadoBean>)this.session_empleados.get(Tabla.TABLA_EMPLEADO);
		
		if(this.buffer_empleado == null) 
			list_empleados_fk.add("Dummy Data");
		else {
			//2. Recorremos y Ffltramos los datos del array de empleados y nos quedamos con los campos 'ID' y 'Nombre'
			for(EmpleadoBean item : this.buffer_empleado)
				list_empleados_fk.add("ID: " + item.getNo_empleado() + " | Nombre: " + item.getNombre_completo());
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session_empleados = session;
		
	}
}
