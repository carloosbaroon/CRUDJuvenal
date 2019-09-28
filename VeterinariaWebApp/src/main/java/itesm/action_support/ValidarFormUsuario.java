package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;

public class ValidarFormUsuario extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private UsuarioBean usuario;
	private Map<String, Object> session_var;
	private ArrayList<UsuarioBean> buffer_usuarios;
	private ArrayList<EmpleadoBean> buffer_empleados, buffer_empleados_aux;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session_var = session;
	}
	
	public String execute() {		
		//1. Recuperamos el ArrayList de Usuarios y el de Empleados accediendo a Map
		this.buffer_usuarios = (ArrayList<UsuarioBean>)this.session_var.get(Tabla.TABLA_USUARIO);
		this.buffer_empleados = (ArrayList<EmpleadoBean>)this.session_var.get(Tabla.TABLA_EMPLEADO);
		//Recorremos el buffer de empleados y filtramos(Nos quedamos con todos los empleados que no han sido elegidos)
		buffer_empleados_aux = new ArrayList<EmpleadoBean>();
		for(EmpleadoBean item : this.buffer_empleados) {
			if(item.getNo_empleado().equals(usuario.getId_empleado_FK()))//Si el usuario tiene asociada la clave del empleado
				item.setElegido_por_usuario(true);//Activamos el flag para indicar que el empleado a sido elegido
		}	
		
		if(this.buffer_usuarios == null) {
			ArrayList<UsuarioBean> buffer_usuarios_aux = new ArrayList<UsuarioBean>();
			buffer_usuarios_aux.add(usuario);//Agregamos los datos del usuario al buffer de usuarios
			this.session_var.put(Tabla.TABLA_USUARIO, buffer_usuarios_aux);
		}else {
			//2. Agregamos el objeto/datos del formulario obtenido a la cola del ArrayList
			buffer_usuarios.add(usuario);
			//3. Actualizamos la variable de sesión con los nuevos datos
			this.session_var.put(Tabla.TABLA_USUARIO, buffer_usuarios);
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
