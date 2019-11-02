package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;
import itesm.database.DAOUsuario;
import itesm.database.DAOUsuarioImpl;

public class ValidarFormUsuario extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private UsuarioBean usuario;
	private Map<String, Object> session_var;
	private ArrayList<UsuarioBean> buffer_usuarios;
	private ArrayList<EmpleadoBean> buffer_empleados, buffer_empleados_aux;
	private int usuarioCount;
	private String mensajeError = "Los passwords no coinciden";
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session_var = session;
	}
	
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
	
	private void updateIdCounter(Map<String, Object> session_var,String idCounter, int contador_local) {
		if(!session_var.containsKey(idCounter))
			session_var.put(idCounter, contador_local);
					
		contador_local = (Integer) session_var.get(idCounter);
		
		contador_local++;
		session_var.put(idCounter, contador_local);
		this.usuario.setUsuarioID((((String.valueOf(contador_local)))));//Agregamos el id incremental al nuevo empleado
	}

	public String getMensajeError() {
		return mensajeError;
	}
	
	
}
