package itesm.action_support;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.OwnerBean;

public class validarID extends ActionSupport implements SessionAware {
	private OwnerBean owner;
	private Map<String, Object> ownerSession;
	private String message;
	
	public OwnerBean getOwner() {
		return owner;
	}
	public void setOwner(OwnerBean owner) {
		this.owner = owner;
	}
	public void setSession(Map<String, Object> session) {
		ownerSession = session;
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String init() {
		
		
		return SUCCESS;
	}
	
	public String execute() {
		if(owner == null)
		{
			message = "No existe el usuario requerido";
			return ERROR;
		}
		else {
			
		}
		return SUCCESS;
	}

	

}
