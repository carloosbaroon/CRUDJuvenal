package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;

public class BajaUsuario extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private EmpleadoBean empleado;
	private UsuarioBean usuario;
	private ArrayList<UsuarioBean> buffer_usuarios;
	private ArrayList<EmpleadoBean> buffer_empleados;
	private Map<String, Object> session_map;
	
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
	
	public String execute() {
		//1. Recuperamos el ArrayList de Usuarios y el de Empleados accediendo a Map
		this.usuario = (UsuarioBean)this.session_map.get("user_temp");
		this.empleado = (EmpleadoBean)this.session_map.get("emp_temp");
		
		System.out.println("ID USUARIO: "+ usuario.getUsuarioID());
		System.out.println("ID EMPLEADO: "+ empleado.getNo_empleado());
		System.out.println("NOMBRE: "+ empleado.getNombre_completo());
		//Recorremos el buffer de empleados y filtramos(Nos quedamos con todos los empleados que no han sido elegidos)
		this.buffer_usuarios = (ArrayList<UsuarioBean>)this.session_map.get(Tabla.TABLA_USUARIO);
		this.buffer_empleados = (ArrayList<EmpleadoBean>)this.session_map.get(Tabla.TABLA_EMPLEADO);
		for(UsuarioBean item : this.buffer_usuarios) 
		{
			if(item.getUsuarioID().equals(usuario.getUsuarioID())) //Si el usuario tiene asociada la clave del empleado
			{
				buffer_usuarios.remove(usuario);
				break;
			}			
		}
		for(EmpleadoBean emp : this.buffer_empleados)
		{
			if(emp.getNo_empleado().equals(empleado.getNo_empleado()))
			{
				buffer_empleados.remove(empleado);
				break;
			}
		}
		System.out.println("REMOVIDOS");
		return SUCCESS;
	}
	
}
