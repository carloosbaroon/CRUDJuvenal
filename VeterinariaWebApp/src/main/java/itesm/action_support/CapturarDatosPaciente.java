package itesm.action_support;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.OwnerBean;
import itesm.business.PacienteBean;

public class CapturarDatosPaciente extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PacienteBean paciente;
	private int pacienteCount = 100;
	private Map<String, Object> pacienteSession;
	private String message;
	private OwnerBean owner;
	
	public OwnerBean getOwner() {
		return owner;
	}

	public void setOwner(OwnerBean owner) {
		this.owner = owner;
	}

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

	public int getPacienteCount() {
		return pacienteCount;
	}

	public void setPacienteCount(int pacienteCount) {
		this.pacienteCount = pacienteCount;
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
		if(!pacienteSession.containsKey("pacienteCount")){
			pacienteSession.put("pacienteCount", pacienteCount);
		}
		pacienteCount = (Integer) pacienteSession.get("pacienteCount");
		
		pacienteCount ++;
		pacienteSession.put("pacienteCount", pacienteCount);
		paciente.idOwner = owner.id;
		
		paciente.setId((String.valueOf(pacienteCount)));
		pacienteSession.put(paciente.getId(), paciente);
		System.out.println("ID owner: "+ paciente.idOwner);
		
		return SUCCESS;
	}

}