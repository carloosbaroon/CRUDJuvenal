package itesm.action_support;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import itesm.business.PacienteBean;
import itesm.business.OwnerBean;
import com.opensymphony.xwork2.ActionSupport;

public class ConsultaGeneralPaciente extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<PacienteBean> pacientes;
	private PacienteBean paciente;
	private OwnerBean owner;
	private Map<String, Object> ownerSession ;
	private String message;
	
	public void setSession(Map<String, Object> session) {
		ownerSession = session ;
	}
	
	public PacienteBean getPaciente() {
	return paciente;
	}

	public void setPaciente(PacienteBean paciente) {
	this.paciente = paciente;
	}

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

	public Collection<PacienteBean> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Collection<PacienteBean> pacientes) {
		this.pacientes = pacientes;
	}
	
	public String init() {
		return SUCCESS;
	}
	public String execute() {
		
		pacientes = new ArrayList<PacienteBean>();
		List<Object>  listaSession = new ArrayList<Object>(ownerSession.values());
		System.out.println(owner.getId());
		for(int i=0; i<listaSession.size();i++)
		{
			Object test = listaSession.get(i);
			
			if(test instanceof PacienteBean) {
				paciente = (PacienteBean) test;
				
				if(paciente.getIdOwner().equals(owner.getId())) {
					pacientes.add(paciente);
				}
			}
		}
		
		System.out.println(pacientes);
		
		return SUCCESS;
		
	}
	
	
	
	
}