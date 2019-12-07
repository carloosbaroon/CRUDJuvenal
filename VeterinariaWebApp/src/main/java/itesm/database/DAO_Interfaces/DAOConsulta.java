package itesm.database.DAO_Interfaces;

import java.util.ArrayList;

import itesm.business.ConsultaBean;
import itesm.business.SalaBean;

public interface DAOConsulta extends CRUD<ConsultaBean>{

	ArrayList<SalaBean> consultarDisponibles(String fecha, String hora_inicial, String hora_final) throws Exception;

	ArrayList<ConsultaBean> consultabyPro(String idPropietario) throws Exception;

	void cancelarCita(String idConsulta) throws Exception;

	ArrayList<SalaBean> consultarDisponiblesAten(String fecha, String hora_inicial, String hora_final) throws Exception;

}
