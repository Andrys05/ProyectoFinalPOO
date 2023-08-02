package logico;

public class Vacuna{
	/**
	 * 
	 */
	private String codigo;
	private String nombre;
	private String  descrip;
	
	
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
	
	public Vacuna(String codigo, String nombre, String descrip) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descrip = descrip;
	}
	
	

}