package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import itesm.business.UsuarioBean;
import itesm.database.DAOUsuario;
import itesm.database.DAOUsuarioImpl;

public class ListaUsuarios extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session_usuarios;
	private ArrayList<UsuarioBean> buffer_usuarios;
	private UsuarioBean usuario = new UsuarioBean();
	
	//Getter and Setter 'UsuarioBean usuario'
	public UsuarioBean getUsuario() {return usuario;}
	//Getter 'ArrayList<UsuarioBean> buffer_usuarios'
	public ArrayList<UsuarioBean> getBuffer_usuarios() {return buffer_usuarios;}
	
	public String execute() {
		//1. Obtener la tabla empleados con todos sus registros
		DAOUsuario daoUsuario = new DAOUsuarioImpl();
		try {
			this.buffer_usuarios = daoUsuario.consultarUsuarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session_usuarios = session;
		
	}
}
