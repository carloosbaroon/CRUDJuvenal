package itesm.business;

public class UsuarioBean {
	private String usuarioID;
	private String password;
	private String confirmar_password;
	private String id_empleado_FK;
	//Grupo al que pertenece el usuario y es el que indica los privilegios de acceso que tiene
	private int grupo;
	private String estado;//Activo, Bloqueado, Inactivo
	
	public String getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(String usuarioID) {
		this.usuarioID = usuarioID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmar_password() {
		return confirmar_password;
	}
	public void setConfirmar_password(String confirmar_password) {
		this.confirmar_password = confirmar_password;
	}
	public String getId_empleado_FK() {
		return id_empleado_FK;
	}
	public void setId_empleado_FK(String id_empleado_FK) {
		this.id_empleado_FK = id_empleado_FK;
	}
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
