package itesm.action_support;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.ConsultaBean;
import itesm.business.EmpleadoBean;
import itesm.business.PacienteBean;
import itesm.business.SalaBean;
import itesm.business.CancelacionBean;
import itesm.database.DAO_Implementation.DAOConsultaImpl;
import itesm.database.DAO_Implementation.DAOEmpleadoImpl;
import itesm.database.DAO_Implementation.DAOPacienteImpl;
import itesm.database.DAO_Implementation.DAOSalasImpl;
import itesm.database.DAO_Implementation.DAOCancelacionImpl;
import itesm.database.DAO_Interfaces.DAOConsulta;
import itesm.database.DAO_Interfaces.DAOEmpleado;
import itesm.database.DAO_Interfaces.DAOPaciente;
import itesm.database.DAO_Interfaces.DAOSalas;
import itesm.database.DAO_Interfaces.DAOCancelacion;


public class ConsultaAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private ConsultaBean consulta;
	private SalaBean sala;
	private PacienteBean paciente;
	private EmpleadoBean empleado;
	private CancelacionBean cancelacion;
	
	private ArrayList<SalaBean> buffer_salas_disponibles;
	private ArrayList<ConsultaBean> buffer_citas;
	

	private String mensajeError;
	private String qs_sala_id;
	private String idPropietario;
	private String qs_consulta_id;
	
	public String getQs_consulta_id() {
		return qs_consulta_id;
	}
	public void setQs_consulta_id(String qs_consulta_id) {
		this.qs_consulta_id = qs_consulta_id;
	}
	public String getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(String idPropietario) {
		this.idPropietario = idPropietario;
	}
	public String getQs_sala_id() {
		return qs_sala_id;
	}
	public void setQs_sala_id(String qs_sala_id) {
		this.qs_sala_id = qs_sala_id;
	}
	
	public SalaBean getSala() {return sala;}
	public void setSala(SalaBean sala) {this.sala = sala;}	
	public ConsultaBean getConsulta() {return consulta;}
	public void setConsulta(ConsultaBean consulta) {this.consulta = consulta;}
	
	public CancelacionBean getCancelacion() {
		return cancelacion;
	}
	public void setCancelacion(CancelacionBean cancelacion) {
		this.cancelacion = cancelacion;
	}
	public PacienteBean getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteBean paciente) {
		this.paciente = paciente;
	}
	public EmpleadoBean getEmpleado() {
		return empleado;
	}
	public void setEmpleado(EmpleadoBean empleado) {
		this.empleado = empleado;
	}
	public ArrayList<SalaBean> getBuffer_salas_disponibles() {return buffer_salas_disponibles;}
	public void setBuffer_salas_disponibles(ArrayList<SalaBean> buffer_salas_disponibles) {this.buffer_salas_disponibles = buffer_salas_disponibles;}
	
	
	public ArrayList<ConsultaBean> getBuffer_citas() {
		return buffer_citas;
	}
	public void setBuffer_citas(ArrayList<ConsultaBean> buffer_citas) {
		this.buffer_citas = buffer_citas;
	}
	
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
		System.out.println(this.consulta.getId_sala());
		return SUCCESS;
	}
	
	public String reservarSala() throws Exception {
		//String resp = "";
		DAOPaciente daoPaciente = new DAOPacienteImpl();
		DAOConsulta daoConsulta = new DAOConsultaImpl();
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		try {
			this.setPaciente(daoPaciente.buscar(consulta.getId_paciente()));
			if(paciente == null) {
				mensajeError = "Paciente NO valido";
				return ERROR;
			};
			this.setEmpleado(daoEmpleado.buscar(consulta.getId_empleado()));
			if(empleado == null) {
				mensajeError = "Empleado NO valido";
				return ERROR;
			};
			//return SUCCESS;
			daoConsulta.insertar(consulta);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String buscarCitas()
	{
		DAOConsulta daoConsulta = new DAOConsultaImpl();
		try {
			this.buffer_citas = daoConsulta.consultabyPro(idPropietario);
			if(buffer_citas != null)
			{
				for(ConsultaBean item: buffer_citas) {
					System.out.println(item.getId_consulta());
				}
				
				return SUCCESS;
			}else
			{
				return NONE;
			}
		}catch (Exception e)
		{
			e.printStackTrace();
			mensajeError = "Error al mostrar la lista de Citas";
			return ERROR;
		}
	}
	public String interCancelar() {
		//System.out.println(consulta.getId_consulta());
		return SUCCESS;
	}
	
	public String cancelarCita() throws Exception {
		String datesyst = "";
		Date dateObj = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("Fecha: "+dateFormat.format(dateObj));
		datesyst = dateFormat.format(dateObj);
		cancelacion.setFecha(datesyst);
		
		DAOConsulta daoConsulta = new DAOConsultaImpl();
		DAOCancelacion daoCancelacion = new DAOCancelacionImpl();
		try {
			daoCancelacion.insertar(cancelacion);
			daoConsulta.cancelarCita(cancelacion.getId_consulta());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
