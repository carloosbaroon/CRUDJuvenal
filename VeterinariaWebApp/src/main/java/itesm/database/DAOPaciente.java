package itesm.database;

import itesm.business.PacienteBean;
import itesm.business.UsuarioBean;

public interface DAOPaciente {
	public void insertarPaciente(PacienteBean paciente) throws Exception;
}
