package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.UsuarioBean;

public class ValidarFormUsuario extends ActionSupport implements SessionAware{
	private UsuarioBean usuario;
	private Map<String, Object> session_usuario;
	private ArrayList<UsuarioBean> buffer_usuarios;
	private String TABLA = "usuario";
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session_usuario = session;
	}
	
	public String execute() {
		//Debug
		System.out.println(usuario.getUsuarioID());
		System.out.println(usuario.getPassword());
		System.out.println(usuario.getConfirmar_password());
		System.out.println(usuario.getId_empleado_FK());
		//System.out.println(usuario.getGrupo());
		System.out.println(usuario.getEstado());
		
		//1. Recuperamos el ArrayList de Usuarios obtenido de Map
		this.buffer_usuarios = (ArrayList<UsuarioBean>)this.session_usuario.get(TABLA);
		
		if(this.buffer_usuarios == null) {
			ArrayList<UsuarioBean> buffer_usuarios_aux = new ArrayList<UsuarioBean>();
			buffer_usuarios_aux.add(usuario);
			this.session_usuario.put(TABLA, buffer_usuarios_aux);
		}else {
			//2. Agregamos el objeto/datos del formulario obtenido a la cola del ArrayList
			buffer_usuarios.add(usuario);
			//3. Actualizamos la variable de sesión con los nuevos datos
			this.session_usuario.put(TABLA, buffer_usuarios);
		}
		
		return SUCCESS;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}
}
