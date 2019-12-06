package itesm.business;

public class AtencionBean {
	private String id_atencion;
	private String id_consulta;
	private String id_paciente;
	private String fecha;
	private String hora_entrada;
	private String hora_salida;
	private String detalle;
	private String monto;
	
	public String getId_atencion() {
		return id_atencion;
	}
	public void setId_atencion(String id_atencion) {
		this.id_atencion = id_atencion;
	}
	public String getId_consulta() {
		return id_consulta;
	}
	public void setId_consulta(String id_consulta) {
		this.id_consulta = id_consulta;
	}
	public String getId_paciente() {
		return id_paciente;
	}
	public void setId_paciente(String id_paciente) {
		this.id_paciente = id_paciente;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora_entrada() {
		return hora_entrada;
	}
	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}
	public String getHora_salida() {
		return hora_salida;
	}
	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	
}
