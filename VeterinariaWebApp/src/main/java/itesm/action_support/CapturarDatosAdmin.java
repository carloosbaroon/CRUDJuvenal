package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.AdminBean;
import itesm.business.EmpleadoBean;

public class CapturarDatosAdmin extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private AdminBean admin;
	private Map<String, Object> session_admin;
	private ArrayList<EmpleadoBean> buffer_admins;
	
	public AdminBean getAdmin() {
		return admin;
	}
	public void setAdmin(AdminBean admin) {
		this.admin = admin;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session_admin = session;
		
	}
	
	public String execute() {
		admin.setRole(Tabla.ROL_1);
		
		this.session_admin.put(admin.getUsername(), admin);
		System.out.println("Admin Datos");
		
		System.out.println(admin.getUsername());
		System.out.println(admin.getPassword());
		return SUCCESS;
	}


	
}
