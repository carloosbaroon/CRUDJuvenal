package itesm.database.DAO_Interfaces;

import itesm.business.SalaBean;

public interface DAOSalas extends CRUD<SalaBean>{

	void editarEstado(String id_sala, String estado) throws Exception;

}
