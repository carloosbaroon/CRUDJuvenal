package itesm.action_support;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.OwnerBean;

public class editarOwner extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private OwnerBean owner;
	private String message;
	
	public String getMessage() {return message;}
	public void setMessage(String message) {this.message = message;}

	public OwnerBean getOwner() {return owner;}
	public void setOwner(OwnerBean owner) {this.owner = owner;}
	
	public String execute() {
		owner = (OwnerBean)ownerSession.get(owner.getId());
		if(owner == null)
		{
			message = "No existe el usuario requerido";
			return ERROR;
		}
			return SUCCESS;
	}
}
