package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;
import itesm.database.DAOUsuario;
import itesm.database.DAOUsuarioImpl;

public class CapturarDatosUsuario extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private UsuarioBean usuario;
	private String mensajeError;
	
	public String execute() {
		
		//Verificamos que el password y el password reescrito sean iguales
		if(usuario.getPassword().contentEquals(usuario.getConfirmar_password())){
				DAOUsuario daoUsuario = new DAOUsuarioImpl();
				try {
					daoUsuario.insertarUsuario(usuario);
				} catch (Exception e) {
					e.printStackTrace();
					mensajeError = "Error al insertar el registro a la BD";
					return ERROR;
				}			
			return SUCCESS;
		}else { 
			mensajeError = "Los passwords no coinciden";
			return ERROR;
		}
	}
	
	public String eliminarUsuario() {
		//1. Verificamos que el usuario que nos estan pidiendo eliminar existe
		DAOUsuario daoUsuario = new DAOUsuarioImpl();
		try {
			daoUsuario.eliminarUsuario(usuario);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			//En caso de que no encuentre el registro que se va eliminar se reedirige
			//a un jsp indicando al usuario el error
			return ERROR;
		}
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public String getMensajeError() {
		return mensajeError;
	}
	
	
}
