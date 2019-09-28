package itesm.action_support;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.OwnerBean;

public class editarOwner extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OwnerBean owner;
	private Map<String, Object> ownerSession ;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OwnerBean getOwner() {
		return owner;
	}

	public void setOwner(OwnerBean owner) {
		this.owner = owner;
	}
	
	public void setSession(Map<String, Object> session) {
		ownerSession = session;
		
	}
	
	public String init() {
		return SUCCESS;
	}
	
	public String execute() {
		owner = (OwnerBean)ownerSession.get(owner.getId());
		if(owner == null)
		{
			message = "No existe el usuario requerido";
			return ERROR;
		}
			return SUCCESS;
	}
	
	public String show() {
		ownerSession.put(owner.getId(),owner);
		return SUCCESS;
	}
}
