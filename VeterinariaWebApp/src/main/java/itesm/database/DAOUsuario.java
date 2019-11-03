package itesm.database;

import java.util.ArrayList;

import itesm.business.UsuarioBean;

public interface DAOUsuario {
	public String insertarUsuario(UsuarioBean usuario) throws Exception;
	//Este método ayuda a verificar que el usuario que quiera autenticarse exista en la BD y en caso de existir
	//indica a que menu principal se le tiene que reedirigr
	public String verificarUsuario(UsuarioBean usuario) throws Exception;
	public ArrayList<UsuarioBean> consultarUsuarios() throws Exception;
}
