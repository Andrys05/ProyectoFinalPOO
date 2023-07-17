package logico;

import java.util.ArrayList;
import java.util.Date;

public class Medico extends Persona {
	
	private String usuario;
	private String contrasenaDoctor; 
	private String especialidad;
	private ArrayList<Paciente> misPacientes;
	//private ArrayList<Cita> misCitas;
	
	public Medico(String nombre, String cedula, String direccion, Date fechaDeNacim, char sexo, String telefono, String usuario,String contrasenaDoctor,String especialidad) {
		super(nombre, cedula, direccion, fechaDeNacim, sexo, telefono);
		
		this.usuario = usuario;
		this.contrasenaDoctor = contrasenaDoctor;
		this.especialidad = especialidad;
		this.misPacientes = new ArrayList<Paciente>();
		//this.misCitas = new ArrayList<Cita>();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenaDoctor() {
		return contrasenaDoctor;
	}

	public void setContrasenaDoctor(String contrasenaDoctor) {
		this.contrasenaDoctor = contrasenaDoctor;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public ArrayList<Paciente> getMisPacientes() {
		return misPacientes;
	}

	public void setMisPacientes(ArrayList<Paciente> misPacientes) {
		this.misPacientes = misPacientes;
	}
	
	
	

}
