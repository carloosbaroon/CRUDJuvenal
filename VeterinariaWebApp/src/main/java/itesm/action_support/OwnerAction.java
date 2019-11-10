package itesm.action_support;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import itesm.business.OwnerBean;
import itesm.database.DAO_Implementation.DAOEmpleadoImpl;
import itesm.database.DAO_Implementation.DAOOwnerImpl;
import itesm.database.DAO_Implementation.DAOUsuarioImpl;
import itesm.database.DAO_Interfaces.DAOEmpleado;
import itesm.database.DAO_Interfaces.DAOOwner;
import itesm.database.DAO_Interfaces.DAOUsuario;

public class OwnerAction extends ActionSupport {
	private OwnerBean owner;
	private String mensajeError;
	public OwnerBean getOwner() {return owner;}
	public void setOwner(OwnerBean owner) {this.owner = owner;}
	
	public String crearOwner() {
		DAOOwner daoOwner= new DAOOwnerImpl();
		try {
			daoOwner.insertar(owner);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			mensajeError = "Error al crear Dueño";
			return ERROR;
		}
	}
	
	public String buscarOwner() {
		DAOOwner daoOwner = new DAOOwnerImpl();
		try {
			this.owner = daoOwner.buscar(owner.getId());
			if(this.owner == null) {
				mensajeError = "Error al buscar dueño";
				return ERROR;
			}
			else
				return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String actualizarOwner() {
		DAOOwner daoOwner = new DAOOwnerImpl();
		
		try {
			daoOwner.editar(owner);			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			mensajeError = "Error al editar dueño";
			return ERROR;
		}	
	}
}



