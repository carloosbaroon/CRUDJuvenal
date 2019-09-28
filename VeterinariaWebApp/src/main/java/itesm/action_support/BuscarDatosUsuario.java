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
	private ArrayList<EmpleadoBean> buffer_empleados, buffer_empleados_aux;
	
	public UsuarioBean getUser() {
		return usuario;
	}
	
	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
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
		System.out.println(usuario.getUsuarioID());
		usuario = (UsuarioBean)session_map.get(usuario.getUsuarioID());
		System.out.println(usuario);
		
		//1. Recuperamos el ArrayList de Usuarios y el de Empleados accediendo a Map
		this.buffer_usuarios = (ArrayList<UsuarioBean>)this.session_map.get(Tabla.TABLA_USUARIO);
		this.buffer_empleados = (ArrayList<EmpleadoBean>)this.session_map.get(Tabla.TABLA_EMPLEADO);
		//Recorremos el buffer de empleados y filtramos(Nos quedamos con todos los empleados que no han sido elegidos)
		//buffer_empleados_aux = new ArrayList<EmpleadoBean>();
		for(UsuarioBean item : this.buffer_usuarios) {
			if(item.getUsuarioID() == (usuario.getUsuarioID())) //Si el usuario tiene asociada la clave del empleado
			{
				
					session_map.remove(usuario.getUsuarioID());
					System.out.println("ENCONTRADA");
					return SUCCESS;
				}else
					
				{
					//message = "No existe el usuario requerido";
					System.out.println("NO ENCONTRADA");
					return ERROR;
				}
			
				//item.setElegido_por_usuario(true);//Activamos el flag para indicar que el empleado a sido elegido
		}
		return ERROR;
	}
		
		
		/*if(usuario != null)
		{
			session_map.remove(usuario.getUsuarioID());
			System.out.println("ENCONTRADA");
			return SUCCESS;
		}else
		{
			//message = "No existe el usuario requerido";
			System.out.println("NO ENCONTRADA");
			return ERROR;
		}
			
	}
	
	public String show() {
		session_map.put(usuario.getUsuarioID(),usuario);
		return SUCCESS;
	}*/

}
