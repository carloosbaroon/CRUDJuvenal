package itesm.action_support;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;
import itesm.database.DAO_Implementation.DAOEmpleadoImpl;
import itesm.database.DAO_Implementation.DAOUsuarioImpl;
import itesm.database.DAO_Interfaces.DAOEmpleado;
import itesm.database.DAO_Interfaces.DAOUsuario;

public class UsuarioAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private UsuarioBean usuario;
	private EmpleadoBean empleadoBean;
	private String mensajeError, qs_user_id, empleado_id;//Query String to get the url from the previous action
	private ArrayList<String> list_estado_usuario_frontend;
	
	public ArrayList<String> getList_estado_usuario_frontend() {return list_estado_usuario_frontend;}
	public void setList_estado_usuario_frontend(ArrayList<String> list_estado_usuario_frontend) {this.list_estado_usuario_frontend = list_estado_usuario_frontend;}

	public String getEmpleado_id() {return empleado_id;}

	public void setEmpleado_id(String empleado_id) {this.empleado_id = empleado_id;}
	
	private ArrayList<UsuarioBean> buffer_usuarios;
	
	public void setUsuario(UsuarioBean usuario) {this.usuario = usuario;}

	public UsuarioBean getUsuario() {return usuario;}
	
	public EmpleadoBean getEmpleadoBean() {return empleadoBean;}
		
	public ArrayList<UsuarioBean> getBuffer_usuarios() {return buffer_usuarios;}

	public void setBuffer_usuarios(ArrayList<UsuarioBean> buffer_usuarios) {this.buffer_usuarios = buffer_usuarios;}

	public String getMensajeError() {return mensajeError;}
	
	public void setQs_user_id(String qs_user_id) {this.qs_user_id = qs_user_id;}
	
	
	public String validarLogin() {
		String respuesta;
		//1. Recuperar Tablas de variables de sesion (Usuario y Admin)
		DAOUsuario daoUsuario = new DAOUsuarioImpl();
		try {
			//1. Verificamos que el usuario que quiera autenticarse exista
			boolean idExiste = daoUsuario.confirmarExistenciaID(usuario.getUsuarioID());		
			//2. En caso de que el usuario exista y empiece a autenticarse con un password incorrecto, restaremos sus intentos
			if(idExiste) 
			{
				UsuarioBean usuarioAux;
				usuarioAux = daoUsuario.verificarUsuario(usuario);
				//En caso de que no se reciba un usuario por que el password es incorrecto, restamos un intento a ese usuario
				if(usuarioAux  == null) 
				{
					//Buscamos el numero de intentos del usuario y actualizamos su numero de intentos
					this.usuario = daoUsuario.buscar(usuario.getUsuarioID());
					if(Integer.parseInt(this.usuario.getIntentos()) > 0) {//Si el número de intentos del usuario es mayor a cero se puede seguir restando intentos al usuario 
						daoUsuario.actualizarIntentos(this.usuario);						
						if(Integer.parseInt(this.usuario.getIntentos()) == 1) {//Aqui se bloquea al usuario
							mensajeError = "Usuario Bloqueado";
							this.usuario.setEstado("Bloqueado");
							daoUsuario.actualizarEstado(this.usuario);
						}
					}
					else
						mensajeError = "Acude con un admiministrador para que pueda darte acceso a tu cuenta";
					return ERROR;
				}else {
					if(usuarioAux.getEstado().equals("Bloqueado")) {
						mensajeError = "Acude con un admiministrador para que pueda darte acceso a tu cuenta";
						return ERROR;
					} else {
						//En caso de que el usuario haya ingresado correctamente su password tras varios intentos fallidos(Máximo 4)
						//El contador de número de intentos se establece a 4
						usuarioAux.setIntentos(Integer.toString(5));//Aqui hay algo raro, tengo que ponerle 5 para que el no_intentos se establezca en 4
						daoUsuario.actualizarIntentos(usuarioAux);
						return usuarioAux.getPrivilegios();
					}
				}				
			}else {
				UsuarioBean usuarioAux;
				usuarioAux = daoUsuario.verificarUsuario(usuario);
				if(usuarioAux == null) {
					mensajeError = "Usuario o Password Incorrectos";
					return ERROR;
				} else
					return usuarioAux.getPrivilegios();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String crearUsuario() {
		
		//Verificamos que el password y el password reescrito sean iguales
		if(usuario.getPassword().contentEquals(usuario.getConfirmar_password()) && (!usuario.getPassword().equals("") || !usuario.getConfirmar_password().equals(""))){
				DAOUsuario daoUsuario = new DAOUsuarioImpl();
				try {
					daoUsuario.insertar(usuario);
				} catch (Exception e) {
					e.printStackTrace();
					mensajeError = "Error al insertar el registro a la BD";
					return ERROR;
				}			
			return SUCCESS;
		}else if(usuario.getPassword().equals("") || usuario.getConfirmar_password().equals("")) {
			mensajeError = "Llena todos los campos";
			return ERROR;
		}
		else { 
			mensajeError = "Los passwords no coinciden";
			return ERROR;
		}
	}
	
	public String eliminarUsuario() {
		//1. Verificamos que el usuario que nos estan pidiendo eliminar existe
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		DAOUsuario daoUsuario = new DAOUsuarioImpl();
		UsuarioBean usuario = new UsuarioBean();
		usuario.setUsuarioID(this.qs_user_id);
		
		try {
			daoEmpleado.editarDisponibilidad(this.empleado_id, 0);
			daoUsuario.eliminarUsuario(usuario);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			//En caso de que no encuentre el registro que se va eliminar se reedirige
			//a un jsp indicando al usuario el error
			return ERROR;
		}
	}
	
	public String listarUsuarios() {
		//1. Obtener la tabla empleados con todos sus registros
		DAOUsuario daoUsuario = new DAOUsuarioImpl();
		try {
			this.setBuffer_usuarios(daoUsuario.consultar());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String buscarUsuario() {
		DAOUsuario daoUsuario = new DAOUsuarioImpl();
		//Implemenatación Pesima pero ya no habia tiempo
		this.list_estado_usuario_frontend = new ArrayList<String>();		
		this.list_estado_usuario_frontend.add("Activo");
		this.list_estado_usuario_frontend.add("Bloqueado");
		this.list_estado_usuario_frontend.add("Inactivo");
		//************//
		
		try {
			UsuarioBean usuarioAux = daoUsuario.buscar(usuario.getUsuarioID());
			if(usuarioAux != null)
				return SUCCESS;
			else
				return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			mensajeError = "Usuario no encontrado";
			return ERROR;
		}
	}
	public String actualizarEstado() {
		DAOUsuario daoUsuario = new DAOUsuarioImpl();
		
		try {
			if(usuario.getEstado().equals("Activo")) {
				daoUsuario.actualizarEstado(usuario);
				usuario.setIntentos(Integer.toString(5));
				daoUsuario.actualizarIntentos(usuario);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
