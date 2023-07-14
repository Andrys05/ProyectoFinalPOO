package logico;

import java.util.ArrayList;

public class Clinica {
	
	private ArrayList<Persona> misPersonas;
	/*
	private ArrayList<Consulta> misConsultas;
	private ArrayList<Cita> misCitas;
	private ArrayList<Enfermedad> misEnfermedades;
	private ArrayList<Vacuna> misVacunas;
	*/
	private static Clinica clinic = null;
	
	public Clinica() {
		super();
		this.misPersonas = new ArrayList<Persona>();
	}
	
	public static Clinica getInstance() {
		if(clinic==null)
			clinic = new Clinica();
		return clinic;
		
	}

	/*
	public Clinica() {
		super();
		this.misPersonas = new ArrayList<Persona>();
		this.misConsultas = new ArrayList<Consulta>();
		this.misCitas = new ArrayList<Cita>();
		this.misEnfermedades = new ArrayList<Enfermedad>();
		this.misVacunas = new ArrayList<Persona>();
	}
	*/

	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}


	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}

/*
	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}


	public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
	}


	public ArrayList<Cita> getMisCitas() {
		return misCitas;
	}


	public void setMisCitas(ArrayList<Cita> misCitas) {
		this.misCitas = misCitas;
	}


	public ArrayList<Enfermedad> getMisEnfermedades() {
		return misEnfermedades;
	}


	public void setMisEnfermedades(ArrayList<Enfermedad> misEnfermedades) {
		this.misEnfermedades = misEnfermedades;
	}


	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}


	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}
*/
	
	public void insertarPaciente(Paciente miPaciente) {
		misPersonas.add(miPaciente);
	}
}
