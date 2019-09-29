package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;

public class EditarUsuario extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	private EmpleadoBean empleado, empleado_temp;
	private UsuarioBean usuario, usuario_temp;
	private ArrayList<UsuarioBean> buffer_usuarios;
	private ArrayList<EmpleadoBean> buffer_empleados;
	private Map<String, Object> session_map;
	
	public UsuarioBean getUserTemp() {
		return usuario_temp;
	}
	
	public void setUsuarioTemp(UsuarioBean usuario_temp) {
		this.usuario_temp = usuario_temp;
	}
	
	public UsuarioBean getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	
	public EmpleadoBean getEmpleadoTemp() {
		return empleado_temp;
	}

	public void setEmpleadoTemp(EmpleadoBean empleado_temp) {
		this.empleado_temp = empleado_temp;
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
	
	public String init() {
		return SUCCESS;
	}
	
	public String execute() {
		//1. Recuperamos el ArrayList de Usuarios y el de Empleados accediendo a Map
		this.usuario = getUsuario();
		this.empleado = getEmpleado();
		this.usuario_temp = (UsuarioBean)this.session_map.get("user_temp");
		this.empleado_temp = (EmpleadoBean)this.session_map.get("emp_temp");
		
		System.out.println("ID USUARIO: "+ usuario.getUsuarioID());
		System.out.println("ID EMPLEADO: "+ empleado.getNo_empleado());
		System.out.println("NOMBRE: "+ empleado.getNombre_completo());
		//Recorremos el buffer de empleados y filtramos(Nos quedamos con todos los empleados que no han sido elegidos)
		this.buffer_usuarios = (ArrayList<UsuarioBean>)this.session_map.get(Tabla.TABLA_USUARIO);
		this.buffer_empleados = (ArrayList<EmpleadoBean>)this.session_map.get(Tabla.TABLA_EMPLEADO);
		for(UsuarioBean item : this.buffer_usuarios) 
		{
			if(item.getUsuarioID().equals(usuario_temp.getUsuarioID())) //Si el usuario tiene asociada la clave del empleado
			{
				System.out.println("PASSWORD ANTERIOR: "+ usuario_temp.getPassword());
				System.out.println("PASSWORD NUEVO: "+ usuario.getPassword());
				usuario.setUsuarioID(usuario_temp.getUsuarioID());
				usuario.setGrupo(usuario_temp.getGrupo());
				usuario.setEstado(usuario_temp.getEstado());
				usuario.setId_empleado_FK(usuario_temp.getId_empleado_FK());
				buffer_usuarios.remove(usuario_temp);
				buffer_usuarios.add(usuario);
				this.session_map.put(Tabla.TABLA_USUARIO, buffer_usuarios);
				break;
			}			
		}
		for(EmpleadoBean emp : this.buffer_empleados)
		{
			if(emp.getNo_empleado().equals(empleado_temp.getNo_empleado()))
			{
				System.out.println("NOMBRE ANTERIOR: "+ empleado_temp.getNombre_completo());
				System.out.println("NOMBRE NUEVO: "+ empleado.getNombre_completo());
				empleado.setNo_empleado(empleado_temp.getNo_empleado());
				empleado.setElegido_por_usuario(empleado_temp.isElegido_por_usuario());
				empleado.setEstado(empleado_temp.getEstado());
				buffer_empleados.remove(empleado_temp);
				buffer_empleados.add(empleado);
				this.session_map.put(Tabla.TABLA_EMPLEADO, buffer_empleados);
				break;
			}
		}
		System.out.println("REMOVIDOS");
		return SUCCESS;
	}
}
