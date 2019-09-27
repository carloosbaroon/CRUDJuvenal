package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import itesm.business.UsuarioBean;

public class ListaUsuarios extends ActionSupport implements SessionAware {
	private Map<String, Object> session_usuarios;
	private UsuarioBean usuario;
	private ArrayList<UsuarioBean> buffer_usuarios;
	private final String TABLA = "usuario";
	
	public String execute() {
		//1. Obtener la tabla empleados con todos sus registros
		this.buffer_usuarios = (ArrayList<UsuarioBean>)this.session_usuarios.get(TABLA);
		System.err.println("Bufer users: "+ this.buffer_usuarios);
		
		return SUCCESS;
	}
	
	public ArrayList<UsuarioBean> getBuffer_usuarios() {
		return buffer_usuarios;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session_usuarios = session;
		
	}
}
