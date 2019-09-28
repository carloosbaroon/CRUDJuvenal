package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.OwnerBean;

public class CapturarDatosDueño extends ActionSupport implements SessionAware {
	private OwnerBean owner;
	private int ownerCount;
	private Map<String, Object> ownerSession;

	public OwnerBean getOwner() {
		return owner;
	}

	public void setOwner(OwnerBean owner) {
		this.owner = owner;
	}

	public int getOwnerCount() {
		return ownerCount;
	}

	public void setOwnerCount(int ownerCount) {
		this.ownerCount = ownerCount;
	}

	public void setSession(Map<String, Object> session) {
		ownerSession = session;
		
	}
	
	public String init() {
		return SUCCESS;
	}
	
	public String execute() {
		if(!ownerSession.containsKey("userCount")){
			ownerSession.put("userCount", ownerCount);
		}
		ownerCount = (Integer) ownerSession.get("userCount");
		
		ownerCount ++;
		ownerSession.put("userCount", ownerCount);
		
		owner.setId((String.valueOf(ownerCount)));
		ownerSession.put(owner.getId(), owner);	
		return SUCCESS;
	}

}



