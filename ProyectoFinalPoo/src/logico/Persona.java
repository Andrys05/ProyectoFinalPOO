package logico;

import java.util.Date;

public class Persona {
	
	private String nombre;
	private String cedula;
	private String direccion;
	private Date fechaDeNacim;
	private char sexo;
	private String telefono;
	
	public Persona(String nombre, String cedula, String direccion, Date fechaDeNacim, char sexo, String telefono) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.direccion = direccion;
		this.fechaDeNacim = fechaDeNacim;
		this.sexo = sexo;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaDeNacim() {
		return fechaDeNacim;
	}

	public void setFechaDeNacim(Date fechaDeNacim) {
		this.fechaDeNacim = fechaDeNacim;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
