package itesm.database;

import itesm.business.OwnerBean;
import itesm.business.UsuarioBean;

public interface DAOOwner {
	public String insertarOwner(OwnerBean owner) throws Exception;
	public OwnerBean buscarOwner(String id) throws Exception;
}
