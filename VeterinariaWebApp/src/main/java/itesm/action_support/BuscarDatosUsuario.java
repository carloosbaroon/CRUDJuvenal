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
	private ArrayList<EmpleadoBean> buffer_empleados, buffer_empleados_aux;
	private ArrayList<UsuarioBean> buffer_usuarios, buffer_usuarios_aux;
	
	public UsuarioBean getUser() {
		return usuario;
	}
	//private String message;
	
	public String execute() {
		
		//1. Recuperamos el ArrayList de Usuarios y el de Empleados accediendo a Map
		this.buffer_usuarios = (ArrayList<UsuarioBean>)this.session_map.get(Tabla.TABLA_USUARIO);
		this.buffer_empleados = (ArrayList<EmpleadoBean>)this.session_map.get(Tabla.TABLA_EMPLEADO);
		//Recorremos el buffer de empleados y filtramos(Nos quedamos con todos los empleados que no han sido elegidos)
		buffer_usuarios_aux = new ArrayList<UsuarioBean>();
		for(EmpleadoBean item : this.buffer_empleados) {
			if(item.getNo_empleado().equals(usuario.getUsuarioID()))//Si el usuario tiene asociada la clave del empleado
			{
				
			}
		}
		
		return SUCCESS;
	}
	
	public ArrayList<EmpleadoBean> getBuffer_empleados() {
		return buffer_empleados;
	}

	public ArrayList<UsuarioBean> getBuffer_usuarios() {
		return buffer_usuarios;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session_map = session;	
	}

}
