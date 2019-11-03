package itesm.database;

import java.util.ArrayList;

import itesm.business.EmpleadoBean;

public interface DAOEmpleado {
	public String insertarEmpleado(EmpleadoBean empleado) throws Exception;
	public ArrayList<EmpleadoBean> consultarEmpleados() throws Exception;
}
