package itesm.database.DAO_Interfaces;

import java.util.ArrayList;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;

public interface DAOEmpleado extends CRUD<EmpleadoBean> {
	//Si ponemos a true 'soloDisponibles' obtenemos solo los Empleados que no han sido elegidos por un usuario
	public ArrayList<EmpleadoBean> consultarEmpleadosDisponibles() throws Exception;
}
