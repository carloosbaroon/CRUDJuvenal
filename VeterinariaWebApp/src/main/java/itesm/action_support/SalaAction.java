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
	private String qs_sala_id;
	private ArrayList<String> list_sala_estado;
	
	public String getQs_sala_id() {
		return qs_sala_id;
	}
	public void setQs_sala_id(String qs_sala_id) {
		this.qs_sala_id = qs_sala_id;
	}
	public SalaBean getSala() {return sala;}
	public void setSala(SalaBean sala) {this.sala = sala;}
	public ArrayList<SalaBean> getBuffer_salas() {return buffer_salas;}
	public void setBuffer_salas(ArrayList<SalaBean> buffer_salas) {this.buffer_salas = buffer_salas;}
	
	public ArrayList<String> getList_sala_estado() {
		return list_sala_estado;
	}
	public void setList_sala_estado(ArrayList<String> list_sala_estado) {
		this.list_sala_estado = list_sala_estado;
	}
	
	public String fill(){
		this.list_sala_estado = new ArrayList<String>();
		this.list_sala_estado.add("disponible");
		this.list_sala_estado.add("no disponible");
		
		return SUCCESS;
	}
	
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
	
	/*public String buscarSala() {
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
	}*/
	public String buscarSala() {
		this.list_sala_estado = new ArrayList<String>();
		DAOSalas daoSala = new DAOSalasImpl();
		try {
			System.out.println(this.qs_sala_id);
			this.sala = daoSala.buscar(this.qs_sala_id);
			if(sala.getEstado_sala().equals("disponible"))
			{
				this.list_sala_estado.add("disponible");
				this.list_sala_estado.add("no disponible");
			}else
			{
				this.list_sala_estado.add("no disponible");
				this.list_sala_estado.add("disponible");
			}
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
