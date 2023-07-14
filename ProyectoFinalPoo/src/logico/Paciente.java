package logico;

import java.util.Date;

public class Paciente extends Persona {
	private boolean estado;
	private String contactoEmergencia;
	private String numEmergencia;

	public Paciente(String nombre, String cedula, String direccion, Date fechaDeNacim, char sexo, String telefono, boolean estado, String contactoEmergencia, String numEmergencia) {
		super(nombre, cedula, direccion, fechaDeNacim, sexo, telefono);
		this.contactoEmergencia = contactoEmergencia;
		this.numEmergencia = numEmergencia;
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getContactoEmergencia() {
		return contactoEmergencia;
	}

	public void setContactoEmergencia(String contactoEmergencia) {
		this.contactoEmergencia = contactoEmergencia;
	}

	public String getNumEmergencia() {
		return numEmergencia;
	}

	public void setNumEmergencia(String numEmergencia) {
		this.numEmergencia = numEmergencia;
	}

}
