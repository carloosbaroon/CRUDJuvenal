package itesm.action_support;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.ConsultaBean;
import itesm.business.SalaBean;
import itesm.database.DAO_Implementation.DAOConsultaImpl;
import itesm.database.DAO_Implementation.DAOSalasImpl;
import itesm.database.DAO_Interfaces.DAOConsulta;
import itesm.database.DAO_Interfaces.DAOSalas;

public class ConsultaAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private ConsultaBean consulta;
	private SalaBean sala;
	
	private ArrayList<SalaBean> buffer_salas_disponibles;
	private String mensajeError;
	
	public SalaBean getSala() {return sala;}
	public void setSala(SalaBean sala) {this.sala = sala;}	
	public ConsultaBean getConsulta() {return consulta;}
	public void setConsulta(ConsultaBean consulta) {this.consulta = consulta;}
	
	public ArrayList<SalaBean> getBuffer_salas() {return buffer_salas_disponibles;}
	public void setBuffer_salas(ArrayList<SalaBean> buffer_salas_disponibles) {this.buffer_salas_disponibles = buffer_salas_disponibles;}
	
	public String revisarDisponibilidad()
	{
		DAOConsulta daoConsulta = new DAOConsultaImpl();
		try {
			this.buffer_salas_disponibles = daoConsulta.consultarDisponibles(consulta.getFecha_consulta(), consulta.getHora_inicial(), consulta.getHora_final());
			
			if(buffer_salas_disponibles != null)
			{
				for(SalaBean item: buffer_salas_disponibles) {
					System.out.println(item.getId_sala());
				}
				return SUCCESS;
			}else
			{
				return NONE;
			}
			
		}catch (Exception e)
		{
			e.printStackTrace();
			mensajeError = "Error al mostrar la lista de Salas";
			return ERROR;
		}
	}
	
	public String interReservar() {
		/*DAOSalas daoSala = new DAOSalasImpl();
		try {
			this.sala = daoSala.buscar(sala.getId_sala());
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mensajeError = "Sala no encontrado";
			return ERROR;
		}*/
		return SUCCESS;
	}
	
	public String reservarSala() throws Exception {
		
		DAOConsulta daoConsulta = new DAOConsultaImpl();
		try {
			daoConsulta.insertar(consulta);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
