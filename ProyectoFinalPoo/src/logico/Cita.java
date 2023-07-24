package logico;

import java.util.Date;

public class Cita {
	
	private String nombre;
	private String fecha;
	private String hora;
	private String doctor;
	private String tipo;
	private String cedula;
	
	public Cita(String nombre, String fecha, String hora, String doctor, String tipo, String cedula) {
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
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
