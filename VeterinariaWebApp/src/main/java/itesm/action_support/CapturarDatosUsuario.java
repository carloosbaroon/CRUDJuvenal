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
	private String mensajeError = "Los passwords no coinciden";
	
	public String execute() {
		
		//Verificamos que el password y el password reeescrito sean iguales
		if(usuario.getPassword().contentEquals(usuario.getConfirmar_password())){
				DAOUsuario daoUsuario = new DAOUsuarioImpl();
				try {
					daoUsuario.insertarUsuario(usuario);
				} catch (Exception e) {
					e.printStackTrace();
				}			
			return SUCCESS;
		}else { 
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
