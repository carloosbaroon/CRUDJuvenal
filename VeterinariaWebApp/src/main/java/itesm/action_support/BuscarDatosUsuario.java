package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;

public class BuscarDatosUsuario extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private EmpleadoBean empleado;
	private UsuarioBean usuario;
	private Map<String, Object> session_map;
	private ArrayList<UsuarioBean> buffer_usuarios;
	private ArrayList<EmpleadoBean> buffer_empleados;
	
	public UsuarioBean getUser() {
		return usuario;
	}
	
	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	
	public EmpleadoBean getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoBean empleado) {
		this.empleado = empleado;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session_map = session;	
	}
	//private String message;
	
	public String init() {
		return SUCCESS;
	}
	
	public String execute() {
		//System.out.println(usuario.getUsuarioID());
		//usuario = (UsuarioBean)session_map.get(usuario.getUsuarioID());
		//System.out.println(usuario);
		
		//1. Recuperamos el ArrayList de Usuarios y el de Empleados accediendo a Map
		this.buffer_usuarios = (ArrayList<UsuarioBean>)this.session_map.get(Tabla.TABLA_USUARIO);
		this.buffer_empleados = (ArrayList<EmpleadoBean>)this.session_map.get(Tabla.TABLA_EMPLEADO);
		//Recorremos el buffer de empleados y filtramos(Nos quedamos con todos los empleados que no han sido elegidos)
		//buffer_empleados_aux = new ArrayList<EmpleadoBean>();
		for(UsuarioBean item : this.buffer_usuarios) {
			/*System.out.println(usuario.getUsuarioID());
			System.out.println(item.getUsuarioID());
			System.out.println(item.getPassword());*/
			if(item.getUsuarioID().equals(usuario.getUsuarioID())) //Si el usuario tiene asociada la clave del empleado
			{
				this.usuario = item;
				System.out.println("ENCONTRADA");
				
				for(EmpleadoBean emp : this.buffer_empleados)
				{
					if(emp.getNo_empleado().equals(usuario.getId_empleado_FK()))
					{
						//System.out.println(emp.getNo_empleado());
						//System.out.println(emp.getNombre_completo());
						this.empleado = emp;
						break;
					}
				}
				//session_map.remove(usuario.getUsuarioID());
				this.session_map.put("user_temp", usuario);
				this.session_map.put("emp_temp", empleado);
				return SUCCESS;
			}
			
		}
		System.out.println("NO ENCONTRADA");
		return ERROR;
	}

}
