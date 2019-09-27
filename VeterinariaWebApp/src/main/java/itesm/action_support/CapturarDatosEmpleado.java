package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;

public class CapturarDatosEmpleado extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private EmpleadoBean empleado;
	private Map<String, Object> session_empleado;
	private ArrayList<EmpleadoBean> buffer_empleados;
	
	public EmpleadoBean getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoBean empleado) {
		this.empleado = empleado;
	}

	public String execute() throws Exception {
			//1. Obtenemos la tabla y los registros que se encuentran en la variable de sesión
			buffer_empleados = (ArrayList<EmpleadoBean>)this.session_empleado.get(Tabla.TABLA_EMPLEADO);
			
			//En caso de que la variable de sesión no tenga el conjunto de datos solicitado
			//se creara una instancia ArrayList que guardara los datos del Empleado
			if(buffer_empleados == null) {
				ArrayList<EmpleadoBean> buffer_empleados_aux = new ArrayList<EmpleadoBean>();
				buffer_empleados_aux.add(empleado);
				this.session_empleado.put("empleado", buffer_empleados_aux);
			} else {
				//2. Agregamos el objeto o datos del formulario obtenido a la cola del ArrayList
				buffer_empleados.add(empleado);
				//3. Actualizamos la variable de sesión con los nuevos datos
				this.session_empleado.put(Tabla.TABLA_EMPLEADO, buffer_empleados);
			}	
			
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session_empleado = session;
		
	}
}
