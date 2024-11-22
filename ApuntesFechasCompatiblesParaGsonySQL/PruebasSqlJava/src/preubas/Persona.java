package preubas;

import java.util.Date;

public class Persona {
	private int codigo;
	private String nombre;
	private String likings;
	private Date fehcadenacimiento;
	
	public Persona(int codigo, String nombre, String likings, Date fehcadenacimiento) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.likings = likings;
		this.fehcadenacimiento = fehcadenacimiento;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLikings() {
		return likings;
	}
	public void setLikings(String likings) {
		this.likings = likings;
	}
	public Date getFehcadenacimiento() {
		return fehcadenacimiento;
	}
	public void setFehcadenacimiento(Date fehcadenacimiento) {
		this.fehcadenacimiento = fehcadenacimiento;
	}
	
	
}
