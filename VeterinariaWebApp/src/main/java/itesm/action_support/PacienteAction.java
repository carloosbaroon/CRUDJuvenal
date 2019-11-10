package itesm.action_support;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.business.OwnerBean;
import itesm.business.PacienteBean;
import itesm.business.UsuarioBean;
import itesm.database.DAO_Implementation.DAOEmpleadoImpl;
import itesm.database.DAO_Implementation.DAOPacienteImpl;
import itesm.database.DAO_Implementation.DAOUsuarioImpl;
import itesm.database.DAO_Interfaces.DAOEmpleado;
import itesm.database.DAO_Interfaces.DAOPaciente;
import itesm.database.DAO_Interfaces.DAOUsuario;

public class PacienteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private OwnerBean owner;
	private PacienteBean paciente;
	private ArrayList<PacienteBean> buffer_pacientes;
	private String mensajeError;
	private String qs_paciente_id, qs_id_propietario;

	
	public OwnerBean getOwner() {return owner;}
	public void setOwner(OwnerBean owner) {this.owner = owner;}
	
	public PacienteBean getPaciente() {return paciente;}
	public void setPaciente(PacienteBean paciente) {this.paciente = paciente;}
	
	public String getMensajeError() {return mensajeError;}
	
	public ArrayList<PacienteBean> getBuffer_pacientes() {return buffer_pacientes;}
	public void setBuffer_pacientes(ArrayList<PacienteBean> buffer_pacientes) {this.buffer_pacientes = buffer_pacientes;}
	
	public String getQs_paciente_id() {return qs_paciente_id;}
	public void setQs_paciente_id(String qs_paciente_id) {this.qs_paciente_id = qs_paciente_id;}
	
	public String getQs_id_propietario() {return qs_id_propietario;}
	public void setQs_id_propietario(String qs_id_propietario) {this.qs_id_propietario = qs_id_propietario;}
	
	public String crearPaciente() {
		DAOPaciente daoPaciente = new DAOPacienteImpl();
		try {
			daoPaciente.insertar(paciente);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			mensajeError = "Error al crear paciente";
			return ERROR;
		}
	}
	
	public String mostrarListaPacientes() {
		//1. Obtener la tabla empleados con todos sus registros
		DAOPaciente daoPaciente = new DAOPacienteImpl();
		try {
			this.buffer_pacientes = daoPaciente.consultarPacientesDelPropietario(qs_id_propietario);
			
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.mensajeError = "Error al mostrar la lista de Pacientes";
			return ERROR;
		}
	}
	
	public String modificarPaciente() {
		DAOPaciente daoPaciente = new DAOPacienteImpl();
		
		try {
			daoPaciente.editar(paciente);
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			mensajeError = "Error al modificar paciente";
			return ERROR;
		}	
	}
	
	public String buscarPaciente() {
		DAOPaciente daoPaciente = new DAOPacienteImpl();
		try {
			this.paciente = daoPaciente.buscar(this.qs_paciente_id);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mensajeError = "Usuario no encontrado";
			return ERROR;
		}
	}
	
	public String bajaPaciente() {
		//1. Verificamos que el usuario que nos estan pidiendo eliminar existe
		DAOPaciente daoPaciente = new DAOPacienteImpl();
		
		try {
			daoPaciente.eliminarPaciente(paciente);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			//En caso de que no encuentre el registro que se va eliminar se reedirige
			//a un jsp indicando al usuario el error
			mensajeError = "Error al encontrar paciente";
			return ERROR;
		}
	}
}