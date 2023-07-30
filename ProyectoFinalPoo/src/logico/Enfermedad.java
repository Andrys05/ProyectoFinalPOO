package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Enfermedad{
	/**
	 * 
	 */
	private String id;
	private String nombre;
	private ArrayList<String> misSintomas;
	private boolean permanente;
	
	public Enfermedad(String id, String nombre, ArrayList<String> misSintomas, boolean permanente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.misSintomas = new ArrayList<String>();
		this.permanente = permanente;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<String> getMisSintomas() {
		return misSintomas;
	}
	public void setMisSintomas(ArrayList<String> misSintomas) {
		this.misSintomas = misSintomas;
	}
	public boolean isPermanente() {
		return permanente;
	}
	public void setPermanente(boolean permanente) {
		this.permanente = permanente;
	}
	
	
	
}
