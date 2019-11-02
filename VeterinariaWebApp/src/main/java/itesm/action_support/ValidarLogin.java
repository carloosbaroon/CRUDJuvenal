package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.AdminBean;
import itesm.business.UsuarioBean;
import itesm.database.DAOUsuario;
import itesm.database.DAOUsuarioImpl;

public class ValidarLogin extends ActionSupport implements SessionAware{
	private Map<String, Object> session_var;
	private ArrayList<UsuarioBean> buffer_usuarios;
	private UsuarioBean usuario;
	private int intentos = 0;
	public UsuarioBean getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	private String mensajeError = "El usuario no existe, escribio mal el password o no esta activo";
	public String execute() {
		String respuesta = ERROR;
		//1. Recuperar Tablas de variables de sesion (Usuario y Admin)
		DAOUsuario daoUsuario = new DAOUsuarioImpl();
		try {
			System.out.println("Pude Entrar");
			respuesta = daoUsuario.consultarUsuario(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("La respuesta es: " + respuesta);
		
		return respuesta;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session_var = session;		
	}
	public String getMensajeError() {
		return mensajeError;
	}
}
