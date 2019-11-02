package itesm.database;

import itesm.business.UsuarioBean;

public interface DAOUsuario {
	public String insertarUsuario(UsuarioBean usuario) throws Exception;
	public String consultarUsuario(UsuarioBean usuario) throws Exception;
}
