package itesm.database;

import java.util.ArrayList;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;

public interface DAOEmpleado {
	public void insertarEmpleado(EmpleadoBean empleado) throws Exception;
	//Si ponemos a true 'soloDisponibles' obtenemos solo los Empleados que no han sido elegidos por un usuario
	public ArrayList<EmpleadoBean> consultarEmpleados(boolean soloDisponibles) throws Exception;
	public EmpleadoBean buscarEmpleado(EmpleadoBean empleado) throws Exception;
	public void editarEmpleado(EmpleadoBean empleado) throws Exception;
}
