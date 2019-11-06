package itesm.action_support;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.database.DAOEmpleado;
import itesm.database.DAOEmpleadoImpl;

public class EmpleadoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private EmpleadoBean empleado;
	private ArrayList<String> list_estado_empleado;
	private ArrayList<EmpleadoBean> buffer_empleados;
	private String mensajeError;
	
	public ArrayList<String> getList_estado_empleado() {return list_estado_empleado;}
	
	public EmpleadoBean getEmpleado() {return empleado;}
	public void setEmpleado(EmpleadoBean empleado) {this.empleado = empleado;}
	
	public ArrayList<EmpleadoBean> getBuffer_empleados() {return buffer_empleados;}

	public String registrarEmpleado() throws Exception {
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		try {
			daoEmpleado.insertarEmpleado(empleado);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String listarEmpleados() {
		//1. Obtener la tabla empleados con todos sus registros
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		try {
			this.buffer_empleados = daoEmpleado.consultarEmpleados(false);
			
			System.out.println("Mostrar ID");
			
			for(EmpleadoBean item: buffer_empleados) {
				System.out.println(item.getId_empleado());
			}
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mensajeError = "Error al mostrar la lista de Empleados";
			return ERROR;
		}
	}
	
	public String llenarDropDownLists() {
		this.list_estado_empleado = new ArrayList<String>();
		this.list_estado_empleado.add("Activo");
		this.list_estado_empleado.add("Baja");		
		
		return SUCCESS;
	}	
	
}
