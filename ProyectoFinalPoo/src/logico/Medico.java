package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Medico{
	
	/**
	 * 
	 */
	private String usuario;
	private String contrasenaDoctor; 
	private String especialidad;
	private String nombre;
	private String cedula;
	private String direccion;
	private int edad;
	private boolean sexo;
	private String telefono;
	private ArrayList<Paciente> misPacientes;
	private ArrayList<Cita> misCitas;
	
	public Medico(String usuario, String contrasenaDoctor, String especialidad,String nombre, String cedula, 
			String direccion,int edad, boolean sexo, String telefono) {
		super();
		this.usuario = usuario;
		this.contrasenaDoctor = contrasenaDoctor;
		this.especialidad = especialidad;
		this.nombre = nombre;
		this.cedula = cedula;
		this.direccion = direccion;
		this.edad = edad;
		this.sexo = sexo;
		this.telefono = telefono;
		misPacientes = new ArrayList<>();
		misCitas = new ArrayList<>();
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
	
	public ArrayList<Cita> getMisCitas() {
		return misCitas;
	}
	public void setMisCitas(ArrayList<Cita> misCitas) {
		this.misCitas = misCitas;
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
	public int getedad() {
		return edad;
	}
	public void setedad(int edad) {
		this.edad = edad;
	}
	public boolean getSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
