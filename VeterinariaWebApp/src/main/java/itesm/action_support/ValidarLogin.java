package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.AdminBean;
import itesm.business.UsuarioBean;

public class ValidarLogin extends ActionSupport implements SessionAware{
	private Map<String, Object> session_var;
	private ArrayList<UsuarioBean> buffer_usuarios;
	private UsuarioBean usuario;
	public UsuarioBean getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	private String mensajeError = "El usuario no existe/Escribio mal usuario o password";
	public String execute() {
		//1. Recuperar Tablas de variables de sesion (Usuario y Admin)
		this.buffer_usuarios = (ArrayList<UsuarioBean>)this.session_var.get(Tabla.TABLA_USUARIO);
		if(this.buffer_usuarios == null) {
			return ERROR;
		}else {		
			//2. Recorrremos el buffer y buscamos el usuario y contraseña que coincidan
			for(UsuarioBean item: this.buffer_usuarios) {
				System.out.println("Item: " + item.getUsuarioID());
				System.out.println("Usuario: " + usuario.getUsuarioID());
				if(item.getUsuarioID().equals(usuario.getUsuarioID()) && item.getPassword().equals(usuario.getPassword())) {
					//Decidimos a que jsp reeenviaremos depeniendo del rol
					if(item.getGrupo().equals("Administrador"))
						return "admin";
					else
					{	
						if(item.getEstado().equals("Activo"))
							return "user";
						else
							return ERROR;
							
					}	
				}
			}
		}
		return ERROR;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session_var = session;		
	}
	public String getMensajeError() {
		return mensajeError;
	}
}
