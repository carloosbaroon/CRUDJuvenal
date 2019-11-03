package itesm.database;

import java.util.ArrayList;

import itesm.business.EmpleadoBean;

public interface DAOEmpleado {
	public String insertarEmpleado(EmpleadoBean empleado) throws Exception;
	//Si ponemos a true 'soloDisponibles' obtenemos solo los Empleados que no han sido elegidos por un usuario
	public ArrayList<EmpleadoBean> consultarEmpleados(boolean soloDisponibles) throws Exception;
}
