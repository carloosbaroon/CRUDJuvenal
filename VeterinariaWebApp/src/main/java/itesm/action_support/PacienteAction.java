package itesm.action_support;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.OwnerBean;
import itesm.business.PacienteBean;
import itesm.database.DAOEmpleado;
import itesm.database.DAOEmpleadoImpl;
import itesm.database.DAOPaciente;
import itesm.database.DAOPacienteImpl;

public class PacienteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private PacienteBean paciente;

	public PacienteBean getPaciente() {return paciente;}
	public void setPaciente(PacienteBean paciente) {this.paciente = paciente;}
	
	
	public String crearPaciente() {
		DAOPaciente daoPaciente = new DAOPacienteImpl();
		try {
			daoPaciente.insertarPaciente(paciente);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}