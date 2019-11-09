package itesm.database.DAO_Interfaces;

import java.util.ArrayList;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;

public interface CRUD<T> {
	public void insertar(T entidad) throws Exception;
	public T buscar(String id) throws Exception;
	public void editar(T entidad) throws Exception;
	public ArrayList<T> consultar() throws Exception;
}
