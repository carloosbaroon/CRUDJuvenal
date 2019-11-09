package itesm.database.DAO_Interfaces;

import java.util.ArrayList;

import itesm.business.UsuarioBean;

public interface DAOUsuario extends CRUD<UsuarioBean>{
	//Este método ayuda a verificar que el usuario que quiera autenticarse exista en la BD y en caso de existir
	//indica a que menu principal se le tiene que reedirigr
	public String verificarUsuario(UsuarioBean usuario) throws Exception;
	public void eliminarUsuario(UsuarioBean usuario) throws Exception;
	public void actualizarEstado(UsuarioBean usuario) throws Exception;
}
