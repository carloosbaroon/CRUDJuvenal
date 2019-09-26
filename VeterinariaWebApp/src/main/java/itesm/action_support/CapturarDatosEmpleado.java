package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;

public class CapturarDatosEmpleado extends ActionSupport implements SessionAware{
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
		//Recuperamos los datos del empleado usando la variable de sesión
		
		/*if(buffer_empleados == null)
			System.out.println("No hay datos");
		else
			for(EmpleadoBean item : buffer_empleados) {
				System.out.println(item.getNombre_completo());
			}*/
		//System.out.println("Empleado: " + empleado.getNombre_completo());
		System.out.println("Estado del empleado: " + empleado.getEstado());
		buffer_empleados = new ArrayList<EmpleadoBean>();
		buffer_empleados.add(empleado);
		System.out.println("Empleado: " + empleado.getTelefono());
		System.out.println("buufer_aempleados: " + buffer_empleados.get(0));
		
		if(buffer_empleados == null) {
			System.out.println("Buffer Empleados esta vacio");
		}else {
			System.out.println("Contenido de Buffer Empleados");
			System.out.println("No empleado: " + buffer_empleados.get(0).getNo_empleado());
			System.out.println("Telefono: " + buffer_empleados.get(0).getTelefono());
		}
			
		this.session_empleado.put("empleado1", buffer_empleados);
		System.out.println("Valores Map: " + session_empleado.values());
		boolean existe = session_empleado.containsKey("empleado1");
		
		ArrayList<EmpleadoBean> buffer2 = new ArrayList<EmpleadoBean>();		
		buffer2 = (ArrayList<EmpleadoBean>) this.session_empleado.get("empleado1");
		System.out.println("Buffer2: " + buffer2);
		System.out.println("No empleado(Buffer2): " + buffer2.get(0).getNo_empleado());
		System.out.println("Telefono(Buffer 2): " + buffer2.get(0).getTelefono());
		System.out.println("Sesion Empleado: " + session_empleado.get("empleado1"));
		/*System.out.println("Valores Map: " + session_empleado.values());
		System.out.println("Despues: " + buffer_empleados);*/
		//buffer_empleados = (ArrayList<EmpleadoBean>)this.session_empleado.get("empleado");
		/*for(EmpleadoBean item : buffer_empleados) {
			System.out.println(item.getNombre_completo());
		}*/
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session_empleado = session;
		
	}
}
