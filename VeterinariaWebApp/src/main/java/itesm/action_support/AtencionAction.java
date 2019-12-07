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
	private ArrayList<ConsultaBean> buffer_horario_disponible;
	private ArrayList<AtencionBean> buffer_atenciones_today;
	//GETTERS AND SETTERS BUFFERS	
	
	public ArrayList<AtencionBean> getBuffer_atenciones_today() {
		return buffer_atenciones_today;
	}
	public void setBuffer_atenciones_today(ArrayList<AtencionBean> buffer_atenciones_today) {
		this.buffer_atenciones_today = buffer_atenciones_today;
	}
	public ArrayList<SalaBean> getBuffer_salas_disponibles() {
		return buffer_salas_disponibles;
	}
	public void setBuffer_salas_disponibles(ArrayList<SalaBean> buffer_salas_disponibles) {
		this.buffer_salas_disponibles = buffer_salas_disponibles;
	}
	public ArrayList<ConsultaBean> getBuffer_horario_disponible() {
		return buffer_horario_disponible;
	}
	public void setBuffer_horario_disponible(ArrayList<ConsultaBean> buffer_horario_disponible) {
		this.buffer_horario_disponible = buffer_horario_disponible;
	}
	
	//Variables Auxiliares
	private String mensajeError;
	private String datesyst;
	private String timesyst;
	private String timeaprox;
	private ArrayList<String> list_factura;
	//GETTERS AND SETTERS Auxiliares
	
	public ArrayList<String> getList_factura() {
		return list_factura;
	}
	public void setList_factura(ArrayList<String> list_factura) {
		this.list_factura = list_factura;
	}
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
	public static String dateSystem()
	{
		String datesyst = "";
		Date dateObj = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		//System.out.println("Fecha: "+dateFormat.format(dateObj));
		datesyst = dateFormat.format(dateObj);
		return datesyst;
	}
	public static String timeSystem()
	{
		String timesyst = "";
		Date dateObj = new Date();
		DateFormat timeFormat = new SimpleDateFormat("hh:mm");
		//System.out.println("Fecha: "+dateFormat.format(dateObj));
		timesyst = timeFormat.format(dateObj);
		return timesyst;
	}
	public static String timeAprox()
	{
		String timesyst = "";
		Date dateObj = new Date();
		
		DateFormat timeFormat = new SimpleDateFormat("hh:mm");
		Calendar ahora = Calendar.getInstance();
		ahora.add(Calendar.HOUR, 1);
		dateObj = ahora.getTime();		
		//System.out.println("Fecha: "+dateFormat.format(dateObj));
		timesyst = timeFormat.format(dateObj);
		return timesyst;
	}
	
	
	public String revisarDisponibilidadNow()
	{
		/*
		 * Se revisa la disponibilidad en base a que la atencion duré maximo dos horas
		 */
		datesyst = dateSystem();
		timesyst = timeSystem();
		timeaprox = timeAprox();
		
		DAOConsulta daoConsulta = new DAOConsultaImpl();
		System.out.println(datesyst);
		System.out.println(timesyst);
		System.out.println(timeaprox);
		try {
			this.buffer_salas_disponibles = daoConsulta.consultarDisponiblesAten(datesyst, timesyst, timesyst);
			
			if(buffer_salas_disponibles.isEmpty())
			{
				System.out.println("Entro al if de que es NULL");
				this.buffer_horario_disponible = daoConsulta.consultarHorariosProximos(datesyst);
				for(ConsultaBean item: buffer_horario_disponible) {
					System.out.println("Sala :"+item.getId_sala()+" Horario: "+item.getHora_final());
				}
				return NONE;
			}else
			{
				for(SalaBean item: buffer_salas_disponibles) {
					System.out.println(item.getId_sala());
				}
				
				return SUCCESS;
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
	
	public String buscarAtencionesToday()
	{
		datesyst = dateSystem();
		
		//DAOConsulta daoConsulta = new DAOConsultaImpl();
		DAOAtencion daoAtencion = new DAOAtencionImpl();
		System.out.println(datesyst);
		try {
			this.buffer_atenciones_today = daoAtencion.consultarAtencionesToday(datesyst);
			
			if(buffer_atenciones_today.isEmpty())
			{
				System.out.println("Entro al if de que es NULL");
				
				return NONE;
			}else
			{
				/*this.list_factura = new ArrayList<String>();
				this.list_factura.add("facturada");
				this.list_factura.add("no facturada");*/
				
				for(AtencionBean item: buffer_atenciones_today) {
					System.out.println(item.getId_atencion());
				}
				
				return SUCCESS;
			}
			
		}catch (Exception e)
		{
			e.printStackTrace();
			mensajeError = "Error al mostrar la lista de Atenciones";
			return ERROR;
		}
	}
	public String preTerminarAtencion() {
		System.out.println(this.atencion.getFecha());
		this.list_factura = new ArrayList<String>();
		this.list_factura.add("facturada");
		this.list_factura.add("no facturada");
		return SUCCESS;
	}
	
	public String terminarAtencion() {
		timesyst = timeSystem();
		atencion.setHora_salida(timesyst);
		DAOSalas daoSala = new DAOSalasImpl();
		DAOAtencion daoAtencion = new DAOAtencionImpl();
		DAOConsulta daoConsulta = new DAOConsultaImpl();
		try {
			daoAtencion.editar(atencion);
			daoSala.editarEstado(atencion.getId_sala(), "disponible");
			daoConsulta.editarEstado(atencion.getId_consulta(), "terminada");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			mensajeError = "Error al terminar la atencion";
			return ERROR;
		}
	}
}
