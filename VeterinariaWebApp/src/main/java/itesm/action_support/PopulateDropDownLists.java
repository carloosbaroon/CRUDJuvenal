package itesm.action_support;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;
import itesm.database.DAO_Implementation.DAOEmpleadoImpl;
import itesm.database.DAO_Implementation.DAOUsuarioImpl;
import itesm.database.DAO_Interfaces.DAOEmpleado;
import itesm.database.DAO_Interfaces.DAOUsuario;

public class PopulateDropDownLists extends ActionSupport{
	private UsuarioBean usuario;
	private EmpleadoBean empleado;
	private ArrayList<String> list_empleados_frontend, list_grupos_privilegios_frontend, list_estado_usuario_frontend, list_estado_empleado_frontend;
	private ArrayList<EmpleadoBean> buffer_empleado;
	
	public ArrayList<String> getList_empleados_frontend() {return list_empleados_frontend;}
	public ArrayList<String> getList_grupos_privilegios_frontend() {return list_grupos_privilegios_frontend;}
	public ArrayList<String> getList_estado_usuario_frontend() {return list_estado_usuario_frontend;}
	public ArrayList<String> getList_estado_empleado_frontend() {return list_estado_empleado_frontend;}
	
	public UsuarioBean getUsuario() {return usuario;}
	public void setUsuario(UsuarioBean usuario) {this.usuario = usuario;}
	public EmpleadoBean getEmpleado() {return empleado;}
	public void setEmpleado(EmpleadoBean empleado) {this.empleado = empleado;}
	
	public String fill() {
		//Estado Usuario
		this.list_estado_usuario_frontend = new ArrayList<String>();		
		this.list_estado_usuario_frontend.add("Activo");
		this.list_estado_usuario_frontend.add("Bloqueado");
		this.list_estado_usuario_frontend.add("Inactivo");
		//Estado Empleado
		this.list_estado_empleado_frontend = new ArrayList<String>();
		this.list_estado_empleado_frontend.add("Activo");
		this.list_estado_empleado_frontend.add("Baja");
		//Privilegios o Grupo
		this.list_grupos_privilegios_frontend = new ArrayList<String>();
		this.list_grupos_privilegios_frontend.add("Administrador");
		this.list_grupos_privilegios_frontend.add("Usuario");
		
		llenarListadeEmpleadosDisponibles();
		
		return SUCCESS;
	}
	
	public String buscarUsuario_Empleado() {
		DAOUsuario daoUsuario = new DAOUsuarioImpl();
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		
		try {
			System.out.println("ID Usuario: " + usuario.getUsuarioID());
			this.usuario = daoUsuario.buscar(usuario.getUsuarioID());
			this.empleado = daoEmpleado.buscar(usuario.getId_empleado_FK());
			llenarListadeEmpleadosDisponibles();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	private void llenarListadeEmpleadosDisponibles() {
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		
		try {
			this.buffer_empleado = daoEmpleado.consultarEmpleadosDisponibles(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.list_empleados_frontend = new ArrayList<String>();
		for(EmpleadoBean item : buffer_empleado) {
			list_empleados_frontend.add(item.getId_empleado());
		}
	}
}
