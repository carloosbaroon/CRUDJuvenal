package itesm.business;

public class EmpleadoBean {
	private String id_empleado;
	private String nombre_completo;
	private String direccion;
	private String telefono;
	private String puesto;
	private String especialidad;
	private String turno;
	private String estado;
	private String elegido;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(String no_empleado) {
		this.id_empleado = no_empleado;
	}
	public String getElegido() {
		return elegido;
	}
	public void setElegido(String elegido) {
		this.elegido = elegido;
	}
}
