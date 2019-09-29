package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.OwnerBean;
import itesm.business.UsuarioBean;

public class editarStatusUsuario extends ActionSupport implements SessionAware {
	private UsuarioBean usuario;
	private Map<String, Object> usuarioSession;
	private ArrayList<UsuarioBean> buffer_usuarios;
	private String message;
	
	public UsuarioBean getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	public void setSession(Map<String, Object> session) {
		usuarioSession = session;
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String init() {
		return SUCCESS;
	}
	
	public String execute() {
		this.buffer_usuarios = (ArrayList<UsuarioBean>)this.usuarioSession.get(Tabla.TABLA_USUARIO);
		
		for(UsuarioBean item: buffer_usuarios) {
			if(item.getUsuarioID().equals(usuario.getUsuarioID())){
				return SUCCESS;
			}
		}
			message = "No existe el usuario requerido";
			return ERROR;
		
		
	}
	
	public String show() {
		usuarioSession.put(usuario.getUsuarioID(),usuario.getEstado());
		return SUCCESS;
	}
	

}
