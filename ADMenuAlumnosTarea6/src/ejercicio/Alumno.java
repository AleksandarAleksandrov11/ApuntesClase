package ejercicio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa a un Alumno con atributos como NIA, nombre, apellidos, género, fecha de nacimiento, ciclo, curso y grupo.
 * 
 * @author MigGon
 */
public class Alumno implements Serializable {
	int nia;
	String nombre;
	String apellidos;
	char genero;
	LocalDate nacimiento;
	String ciclo;
	String curso;
	String grupo;

	/**
	 * Constructor que inicializa un objeto Alumno con los atributos especificados.
	 * 
	 * @param nia Número de Identificación del Alumno.
	 * @param nombre Nombre del alumno.
	 * @param apellidos Apellidos del alumno.
	 * @param genero Género del alumno (M para masculino, F para femenino).
	 * @param nacimiento Fecha de nacimiento del alumno.
	 * @param ciclo Ciclo académico en el que está matriculado el alumno.
	 * @param curso Curso actual del alumno.
	 * @param grupo Grupo al que pertenece el alumno.
	 */
	public Alumno(int nia, String nombre, String apellidos, char genero, LocalDate nacimiento, String ciclo, String curso,
			String grupo) {
		super();
		this.nia = nia;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.nacimiento = nacimiento;
		this.ciclo = ciclo;
		this.curso = curso;
		this.grupo = grupo;
	}

	/**
	 * Devuelve el NIA del alumno.
	 * 
	 * @return nia Número de Identificación del Alumno.
	 */
	public int getNia() {
		return nia;
	}

	/**
	 * Establece el NIA del alumno.
	 * 
	 * @param nia Número de Identificación del Alumno.
	 */
	public void setNia(int nia) {
		this.nia = nia;
	}

	/**
	 * Devuelve el nombre del alumno.
	 * 
	 * @return nombre Nombre del alumno.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del alumno.
	 * 
	 * @param nombre Nombre del alumno.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve los apellidos del alumno.
	 * 
	 * @return apellidos Apellidos del alumno.
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Establece los apellidos del alumno.
	 * 
	 * @param apellidos Apellidos del alumno.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Devuelve el género del alumno.
	 * 
	 * @return genero Género del alumno (M para masculino, F para femenino).
	 */
	public char getGenero() {
		return genero;
	}

	/**
	 * Establece el género del alumno.
	 * 
	 * @param genero Género del alumno (M para masculino, F para femenino).
	 */
	public void setGenero(char genero) {
		this.genero = genero;
	}

	/**
	 * Devuelve la fecha de nacimiento del alumno.
	 * 
	 * @return nacimiento Fecha de nacimiento del alumno.
	 */
	public LocalDate getNacimiento() {
		return nacimiento;
	}

	/**
	 * Establece la fecha de nacimiento del alumno.
	 * 
	 * @param nacimiento Fecha de nacimiento del alumno.
	 */
	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	/**
	 * Devuelve el ciclo académico del alumno.
	 * 
	 * @return ciclo Ciclo académico en el que está matriculado el alumno.
	 */
	public String getCiclo() {
		return ciclo;
	}

	/**
	 * Establece el ciclo académico del alumno.
	 * 
	 * @param ciclo Ciclo académico en el que está matriculado el alumno.
	 */
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Devuelve el curso actual del alumno.
	 * 
	 * @return curso Curso actual del alumno.
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * Establece el curso actual del alumno.
	 * 
	 * @param curso Curso actual del alumno.
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * Devuelve el grupo al que pertenece el alumno.
	 * 
	 * @return grupo Grupo al que pertenece el alumno.
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * Establece el grupo al que pertenece el alumno.
	 * 
	 * @param grupo Grupo al que pertenece el alumno.
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public static String convertirFecha(LocalDate fecha) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d-M-yyyy");
        return fecha.format(formato);
    }
	
	/**
	 * Devuelve una representación en cadena de los atributos del alumno.
	 * 
	 * @return Cadena de texto con los atributos del alumno.
	 */
	@Override
	public String toString() {
		return "Alumno [nia=" + nia + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero=" + genero
				+ ", nacimiento=" + convertirFecha(nacimiento) + ", ciclo=" + ciclo + ", curso=" + curso + ", grupo=" + grupo + "]";
	}
}
