package logico;

import java.util.Date;

public class Vacuna {
	private String codigo;
	private String nombre;
	private String  descrip;
	private int antMiligramos;
	private Date fechaRecibida;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public int getAntMiligramos() {
		return antMiligramos;
	}
	public void setAntMiligramos(int antMiligramos) {
		this.antMiligramos = antMiligramos;
	}
	public Date getFechaRecibida() {
		return fechaRecibida;
	}
	public void setFechaRecibida(Date fechaRecibida) {
		this.fechaRecibida = fechaRecibida;
	}
	
	public Vacuna(String codigo, String nombre, String descrip, int antMiligramos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descrip = descrip;
		this.antMiligramos = antMiligramos;
		fechaRecibida =  new Date();
	}
	
	

}