package itesm.action_support;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.SalaBean;
import itesm.database.DAO_Implementation.DAOSalasImpl;
import itesm.database.DAO_Implementation.DAOUsuarioImpl;
import itesm.database.DAO_Interfaces.DAOSalas;
import itesm.database.DAO_Interfaces.DAOUsuario;

public class SalaAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private SalaBean sala;
	private ArrayList<String> list_estado_sala;
	private ArrayList<SalaBean> buffer_salas;
	private String mensajeError;
	
	public SalaBean getSala() {return sala;}
	public void setSala(SalaBean sala) {this.sala = sala;}
	public ArrayList<SalaBean> getBuffer_salas() {return buffer_salas;}
	public void setBuffer_salas(ArrayList<SalaBean> buffer_salas) {this.buffer_salas = buffer_salas;}
	
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
	
	public String listarSalas()
	{
		DAOSalas daoSala = new DAOSalasImpl();
		try {
			this.buffer_salas = daoSala.consultar();			
			
			/*for(SalaBean item: buffer_salas) {
				System.out.println(item.getId_sala());
			}*/
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			mensajeError = "Error al mostrar la lista de Salas";
			return ERROR;
		}
	}
	
	public String buscarSala() {
		DAOSalas daoSala = new DAOSalasImpl();
		try {
			this.sala = daoSala.buscar(sala.getId_sala());
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mensajeError = "Sala no encontrado";
			return ERROR;
		}
	}
	
	public String actualizarSala() {
		DAOSalas daoSala = new DAOSalasImpl();
		try {
			daoSala.editar(sala);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mensajeError = "No se puede actualizar registro";
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
