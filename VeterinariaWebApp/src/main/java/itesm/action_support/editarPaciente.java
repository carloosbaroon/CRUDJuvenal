package itesm.action_support;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.PacienteBean;
import itesm.business.OwnerBean;

public class editarPaciente extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PacienteBean paciente;
	private OwnerBean owner;
	public OwnerBean getOwner() {
		return owner;
	}

	public void setOwner(OwnerBean owner) {
		this.owner = owner;
	}

	private Map<String, Object> pacienteSession ;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PacienteBean getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteBean paciente) {
		this.paciente = paciente;
	}
	
	public void setSession(Map<String, Object> session) {
		pacienteSession = session;
		
	}
	
	public String init() {
		return SUCCESS;
	}
	
	public String execute() {
		paciente = (PacienteBean)pacienteSession.get(paciente.getId());
		if(paciente == null)
		{
			message = "No existe el usuario requerido";
			return ERROR;
		}
			return SUCCESS;
	}
	
	public String show() {
		paciente.idOwner = owner.id;
		
		
		pacienteSession.put(paciente.getId(), paciente);
		return SUCCESS;
	}
}