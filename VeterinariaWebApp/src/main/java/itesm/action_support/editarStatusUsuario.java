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
	private ArrayList<String> list_estado;
	public ArrayList<String> getList_estado() {
		return list_estado;
	}
	public void setList_estado(ArrayList<String> list_estado) {
		this.list_estado = list_estado;
	}

	private String message = "No existe el usuario requerido";
	
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
		if(this.buffer_usuarios == null) 
			return ERROR;
		else {
			for(UsuarioBean item: buffer_usuarios) {
				if(item.getUsuarioID().equals(usuario.getUsuarioID())){
					this.list_estado = new ArrayList<String>();
					this.list_estado.add("Activo");
					this.list_estado.add("Bloqueado");
					this.list_estado.add("Inactivo");
					//Guardamos en la variable de sesión el ID de Usuario para que más adelante lo ocupemos
					this.usuarioSession.put("user_id", usuario.getUsuarioID());//Se guarda de forma ineficiente
					return SUCCESS;
				}
			}
			
			
		}			
			return ERROR;
		
		
	}
	
	public String show() {
		String num = (String)this.usuarioSession.get("user_id");
		System.out.println("Numero de Sesion: " + num);//Se obtiene de forma ineficiente
		this.buffer_usuarios = (ArrayList<UsuarioBean>)this.usuarioSession.get(Tabla.TABLA_USUARIO);
		for(UsuarioBean item : this.buffer_usuarios) {
			if(item.getUsuarioID().equals(this.usuarioSession.get("user_id"))) {
				//Obtenemos el usuario que queremos actulizarle el estado y lo actualizamos
				item.setEstado(usuario.getEstado());
			}
		}
		
		this.usuarioSession.put(Tabla.TABLA_USUARIO, this.buffer_usuarios);
		
		return SUCCESS;
	}
	

}
