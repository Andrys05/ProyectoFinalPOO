package logico;

import java.io.Serializable;

public class Administrador implements Serializable{

	private static final long serialVersionUID = 1L;
	private String usuario;
	private String contrasena;
	
	
	public Administrador(String usuario, String contrasena) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	

}
