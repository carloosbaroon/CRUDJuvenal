package itesm.database.DAO_Interfaces;

import java.util.ArrayList;

import itesm.business.PacienteBean;
import itesm.business.UsuarioBean;

public interface DAOPaciente extends CRUD<PacienteBean>{
	 public ArrayList<PacienteBean> consultarPacientesDelPropietario(String fk_propietario) throws Exception;
	 public void eliminarPaciente(PacienteBean paciente) throws Exception;
}
