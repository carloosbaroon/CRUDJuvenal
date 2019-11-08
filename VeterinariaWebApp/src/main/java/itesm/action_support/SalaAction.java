package itesm.action_support;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.SalaBean;
import itesm.database.DAO_Implementation.DAOEmpleadoImpl;
import itesm.database.DAO_Interfaces.DAOEmpleado;

public class SalaAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private SalaBean sala;
	private ArrayList<String> list_estado_sala;
	private String mensajeError;
	
	public ArrayList<String> getList_estado_empleado() {return list_estado_sala;}
	
	public String registrarSala() throws Exception {
		return SUCCESS;
		/*
		DAOEmpleado daoSala = new DAOEmpleadoImpl();
		try {
			daoSala.insertar(sala);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}*/
	}
	
	public String llenarDropDownLists() {
		this.list_estado_sala = new ArrayList<String>();
		this.list_estado_sala.add("Disponible");
		this.list_estado_sala.add("No disponible");		
		
		return SUCCESS;
	}
}
