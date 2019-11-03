package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.database.DAOEmpleado;
import itesm.database.DAOEmpleadoImpl;
import itesm.database.DAOUsuario;
import itesm.database.DAOUsuarioImpl;

public class CapturarDatosEmpleado extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private EmpleadoBean empleado;
	private Map<String, Object> session_empleado;
	private ArrayList<EmpleadoBean> buffer_empleados;
	private int empleadoCount;
	
	public EmpleadoBean getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoBean empleado) {
		this.empleado = empleado;
	}

	public String execute() throws Exception {
		String respuesta = ERROR;
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		try {
			daoEmpleado.insertarEmpleado(empleado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}
}
