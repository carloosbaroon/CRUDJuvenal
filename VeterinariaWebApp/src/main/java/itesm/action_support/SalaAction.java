package itesm.action_support;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.SalaBean;
import itesm.database.DAO_Implementation.DAOSalasImpl;
import itesm.database.DAO_Interfaces.DAOSalas;

public class SalaAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private SalaBean sala;
	private ArrayList<String> list_estado_sala;
	private String mensajeError;
	
	public SalaBean getSala() {return sala;}
	public void setSala(SalaBean sala) {this.sala = sala;}
	
	public String registrarSala() throws Exception {
		
		DAOSalas daoSala = new DAOSalasImpl();
		try {
			daoSala.insertar(sala);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/*public String llenarDropDownLists() {
		this.list_estado_sala = new ArrayList<String>();
		this.list_estado_sala.add("Disponible");
		this.list_estado_sala.add("No disponible");		
		
		return SUCCESS;
	}*/
}
