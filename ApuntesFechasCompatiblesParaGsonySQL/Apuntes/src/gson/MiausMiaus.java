package gson;

import java.util.Date;

public class MiausMiaus {
	private String Nombre;
	private String likings;
	private Date fechadenacimiento;
	private int codigo;

	public MiausMiaus(String nombre, String likings, Date fechadenacimiento, int codigo) {
		super();
		Nombre = nombre;
		this.likings = likings;
		this.fechadenacimiento = fechadenacimiento;
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getLikings() {
		return likings;
	}

	public void setLikings(String likings) {
		this.likings = likings;
	}

	public Date getFechadenacimiento() {
		return fechadenacimiento;
	}

	public void setFechadenacimiento(Date fechadenacimiento) {
		this.fechadenacimiento = fechadenacimiento;
	}

	@Override
	public String toString() {
		return "MiausMiaus [Nombre=" + Nombre + ", likings=" + likings + ", fechadenacimiento=" + fechadenacimiento
				+ ", codigo=" + codigo + "]";
	}
	
	

}
