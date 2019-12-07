package itesm.database.DAO_Interfaces;

import java.util.ArrayList;

import itesm.business.AtencionBean;

public interface DAOAtencion extends CRUD<AtencionBean> {

	ArrayList<AtencionBean> consultarAtencionesToday(String datesyst) throws Exception;
	public void editarSergio(AtencionBean entidad) throws Exception;

}
