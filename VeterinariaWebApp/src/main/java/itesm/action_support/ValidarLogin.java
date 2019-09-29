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
	private int intentos = 0;
	public UsuarioBean getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	private String mensajeError = "El usuario no existe, escribio mal el password o no esta activo";
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
				if(item.getEstado().equals("Bloqueado"))
				{
					mensajeError = "USUARIO BLOQUEADO. Consulte a un administrador";
					return ERROR;
				}
				if(item.getUsuarioID().equals(usuario.getUsuarioID())){
					
					if(item.getIntentos() == null)
					{
						intentos = 3;
					}
					else
					{
						intentos = Integer.parseInt(item.getIntentos());
					}
					
					
					if(item.getPassword().equals(usuario.getPassword())) {
						item.setIntentos("0");
						//Decidimos a que jsp reeenviaremos depeniendo del rol
						if(item.getGrupo().equals("Administrador"))
							return "admin";
						else
							return "user";
					}

					else
					{
						intentos = intentos + 1;
						System.out.println("Numero de intentos: " + intentos);
						if(intentos >= 4)
						{
							item.setEstado("Bloqueado");
							return ERROR;
						}
						else
						{
							item.setIntentos(""+intentos);
						}
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
