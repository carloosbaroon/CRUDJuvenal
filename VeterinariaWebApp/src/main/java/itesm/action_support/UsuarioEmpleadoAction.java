package itesm.action_support;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;
import itesm.database.DAOEmpleado;
import itesm.database.DAOEmpleadoImpl;
import itesm.database.DAOUsuario;
import itesm.database.DAOUsuarioImpl;

public class UsuarioEmpleadoAction extends ActionSupport{
	private UsuarioBean usuario;
	private EmpleadoBean empleado;
	
	public UsuarioBean getUsuario() {return usuario;}
	public void setUsuario(UsuarioBean usuario) {this.usuario = usuario;}
	
	public EmpleadoBean getEmpleado() {return empleado;}
	public void setEmpleado(EmpleadoBean empleado) {this.empleado = empleado;}



	public String buscarUsuario_Empleado() {
		DAOUsuario daoUsuario = new DAOUsuarioImpl();
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		
		EmpleadoBean empleadoAux = new EmpleadoBean();
		
		try {
			this.usuario = daoUsuario.buscarUsuario(usuario);
			//Get the 'empleado_id' and pass to the dao function 'buscarEmpleado()'
			empleadoAux.setId_empleado(usuario.getId_empleado_FK());
			this.setEmpleado(daoEmpleado.buscarEmpleado(empleadoAux));
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String actualizarUsuarioEmpleado() {
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		DAOUsuario daoUsuario = new DAOUsuarioImpl();
		
		System.out.println("Usuario: " + usuario.getUsuarioID());
		System.out.println("Empleado: " + empleado.getId_empleado());
		
		try {
			daoUsuario.editarUsuario(usuario);
			daoEmpleado.editarEmpleado(empleado);
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}	
	}

}
