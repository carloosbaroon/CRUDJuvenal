package itesm.action_support;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;
import itesm.database.DAO_Implementation.DAOEmpleadoImpl;
import itesm.database.DAO_Implementation.DAOUsuarioImpl;
import itesm.database.DAO_Interfaces.DAOEmpleado;
import itesm.database.DAO_Interfaces.DAOUsuario;

public class UsuarioEmpleadoAction extends ActionSupport{
	private UsuarioBean usuario;
	private EmpleadoBean empleado;
	String mensajeError;
	public UsuarioBean getUsuario() {return usuario;}
	public void setUsuario(UsuarioBean usuario) {this.usuario = usuario;}
	
	public EmpleadoBean getEmpleado() {return empleado;}
	public void setEmpleado(EmpleadoBean empleado) {this.empleado = empleado;}



	public String buscarUsuario_Empleado() {
		DAOUsuario daoUsuario = new DAOUsuarioImpl();
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		
		try {
			System.out.println("ID Usuario: " + usuario.getUsuarioID());
			this.usuario = daoUsuario.buscar(usuario.getUsuarioID());
			this.empleado = daoEmpleado.buscar(usuario.getId_empleado_FK());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			mensajeError = "Error al mostrar la lista de Empleados";
			return ERROR;
		}
	}
	
	public String actualizarUsuarioEmpleado() {
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		DAOUsuario daoUsuario = new DAOUsuarioImpl();
		
		try {
			daoUsuario.editar(usuario);
			daoEmpleado.editar(empleado);
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			mensajeError = "Error al actualizar usuario";
			return ERROR;
		}	
	}
}
