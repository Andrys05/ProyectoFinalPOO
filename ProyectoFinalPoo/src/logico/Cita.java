package logico;

import java.util.Date;

public class Cita {
	
	private String nombre;
	private Date fecha;
	private String hora;
	private String doctor;
	private String tipo;
	private String cedula;
	
	public Cita(String nombre, Date fecha, String hora, String doctor, String tipo, String cedula) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.hora = hora;
		this.doctor = doctor;
		this.tipo = tipo;
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	

}
