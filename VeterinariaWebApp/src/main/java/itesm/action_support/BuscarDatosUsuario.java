package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.EmpleadoBean;
import itesm.business.UsuarioBean;

public class BuscarDatosUsuario extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private EmpleadoBean empleado;
	private UsuarioBean usuario;
	private Map<String, Object> session_map;
	private ArrayList<EmpleadoBean> buffer_empleados;
	private ArrayList<UsuarioBean> buffer_usuarios;
	private String message;
	
	public String execute() {
		//1. Obtener la tabla usuario con todos sus registros
		this.buffer_usuarios = (ArrayList<UsuarioBean>)this.session_map.get(Tabla.TABLA_USUARIO);
		//1. Obtener la tabla usuario con todos sus registros
		this.buffer_empleados = (ArrayList<EmpleadoBean>)this.session_map.get(Tabla.TABLA_EMPLEADO);
		
		System.out.println(buffer_usuarios);
		
		return SUCCESS;
	}
	/*public String execute() {
		usuario = (UsuarioBean)session_map.get(usuario.getUsuarioID());
		if(usuario == null)
		{
			message = "No existe el usuario requerido";
			return ERROR;
		}
			return SUCCESS;
	
	}*/
	
	/*public String show() {
		if(!pacienteSession.containsKey("userCount")){
			pacienteSession.put("userCount", pacienteCount);
		}
		pacienteCount = (Integer) pacienteSession.get("userCount");
		
		pacienteCount ++;
		pacienteSession.put("userCount", pacienteCount);
		
		paciente.setId((String.valueOf(pacienteCount)));
		pacienteSession.put(paciente.getId(), paciente);	
		return SUCCESS;
	}*/
	
	public ArrayList<EmpleadoBean> getBuffer_empleados() {
		return buffer_empleados;
	}

	public ArrayList<UsuarioBean> getBuffer_usuarios() {
		return buffer_usuarios;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session_map = session;	
	}

}

/*
	private static final long serialVersionUID = 1L;
	private PacienteBean paciente;
	private int pacienteCount;
	private Map<String, Object> pacienteSession;
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
	
	

}*/
