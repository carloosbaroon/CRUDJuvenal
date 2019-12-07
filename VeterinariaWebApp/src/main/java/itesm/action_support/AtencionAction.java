package itesm.action_support;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.AtencionBean;
import itesm.business.ConsultaBean;
import itesm.business.SalaBean;
import itesm.database.DAO_Implementation.DAOAtencionImpl;
import itesm.database.DAO_Implementation.DAOConsultaImpl;
import itesm.database.DAO_Implementation.DAOSalasImpl;
import itesm.database.DAO_Interfaces.DAOAtencion;
import itesm.database.DAO_Interfaces.DAOConsulta;
import itesm.database.DAO_Interfaces.DAOSalas;

public class AtencionAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//BEANS
	private ConsultaBean consulta;
	private AtencionBean atencion;
	private SalaBean sala;
	//GETTERS AND SETTERS BEAN
	public ConsultaBean getConsulta() {
		return consulta;
	}
	public void setConsulta(ConsultaBean consulta) {
		this.consulta = consulta;
	}
	public AtencionBean getAtencion() {
		return atencion;
	}
	public void setAtencion(AtencionBean atencion) {
		this.atencion = atencion;
	}
	public SalaBean getSala() {
		return sala;
	}
	public void setSala(SalaBean sala) {
		this.sala = sala;
	}
	
	//BUFFERS
	private ArrayList<SalaBean> buffer_salas_disponibles;	
	private ArrayList<SalaBean> buffer_horario_disponible;
	//GETTERS AND SETTERS BUFFERS	
	public ArrayList<SalaBean> getBuffer_salas_disponibles() {
		return buffer_salas_disponibles;
	}
	public void setBuffer_salas_disponibles(ArrayList<SalaBean> buffer_salas_disponibles) {
		this.buffer_salas_disponibles = buffer_salas_disponibles;
	}
	public ArrayList<SalaBean> getBuffer_horario_disponible() {
		return buffer_horario_disponible;
	}
	public void setBuffer_horario_disponible(ArrayList<SalaBean> buffer_horario_disponible) {
		this.buffer_horario_disponible = buffer_horario_disponible;
	}
	
	//Variables Auxiliares
	private String mensajeError;
	private String datesyst;
	private String timesyst;
	private String timeaprox;
	//GETTERS AND SETTERS Auxiliares
	
	public String getDatesyst() {
		return datesyst;
	}
	public void setDatesyst(String datesyst) {
		this.datesyst = datesyst;
	}
	public String getTimesyst() {
		return timesyst;
	}
	public void setTimesyst(String timesyst) {
		this.timesyst = timesyst;
	}
	public String getTimeaprox() {
		return timeaprox;
	}
	public void setTimeaprox(String timeaprox) {
		this.timeaprox = timeaprox;
	}
	public String dateSystem()
	{
		String datesyst = "";
		Date dateObj = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		//System.out.println("Fecha: "+dateFormat.format(dateObj));
		datesyst = dateFormat.format(dateObj);
		return datesyst;
	}
	public String timeSystem()
	{
		String timesyst = "";
		Date dateObj = new Date();
		DateFormat timeFormat = new SimpleDateFormat("hh:mm");
		//System.out.println("Fecha: "+dateFormat.format(dateObj));
		timesyst = timeFormat.format(dateObj);
		return timesyst;
	}
	public String timeAprox()
	{
		String timesyst = "";
		Date dateObj = new Date();
		
		DateFormat timeFormat = new SimpleDateFormat("hh:mm");
		Calendar ahora = Calendar.getInstance();
		ahora.add(Calendar.HOUR, 2);
		dateObj = ahora.getTime();		
		//System.out.println("Fecha: "+dateFormat.format(dateObj));
		timesyst = timeFormat.format(dateObj);
		return timesyst;
	}
	
	
	public String revisarDisponibilidadNow()
	{
		datesyst = dateSystem();
		timesyst = timeSystem();
		timeaprox = timeAprox();
		
		DAOConsulta daoConsulta = new DAOConsultaImpl();
		System.out.println(datesyst);
		System.out.println(timesyst);
		System.out.println(timeaprox);
		try {
			this.buffer_salas_disponibles = daoConsulta.consultarDisponiblesAten(datesyst, timesyst, timesyst);
			
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
	public String preRegistrarAtencion() {
		//System.out.println(this.atencion.getFecha());
		return SUCCESS;
	}
	public String endRegistrarAtencion() {
		DAOSalas daoSala = new DAOSalasImpl();
		DAOAtencion daoAtencion = new DAOAtencionImpl();
		try {
			daoAtencion.insertar(atencion);
			daoSala.editarEstado(atencion.getId_sala(), "no disponible");	
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			mensajeError = "Error al registrar la atencion";
			return ERROR;
		}
	}

}
