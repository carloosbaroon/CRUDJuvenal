package itesm.action_support;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class ControlarFormEmpleado extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private ArrayList<String> estado;
	
	public String execute() throws Exception {
		estado = new ArrayList<String>();
		estado.add("Activo");
		estado.add("Baja");
		return SUCCESS;
	}

	public ArrayList<String> getEstado() {
		return estado;
	}

	public void setEstado(ArrayList<String> estado) {
		this.estado = estado;
	}
}
