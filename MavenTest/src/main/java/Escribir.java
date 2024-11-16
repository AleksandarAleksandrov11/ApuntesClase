import java.util.ArrayList;
import java.util.List;

public class Escribir {
	
	private static final int NUM_ALUMNOS = 5;

	public static void main(String[] args) {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		leerAlumnos(alumnos);
		new Gg().writeAlumnos(alumnos, "alumnos.json");
	}

	private static void leerAlumnos(List<Alumno> alumnos) {
		MaikIO io = new MaikIO();
		for(int i = 0; i < NUM_ALUMNOS; i++) {
			alumnos.add(new Alumno(
					io.readInt("Dime el nia del alumno " + (i+1)),
					io.readString("Dime el nombre del alumno " + (i+1)),
					io.readString("Dime el apellido del alumno " + (i+1)),
					io.readChar("Dime el genero del alumno " + (i+1)),
					io.readDate("Dime el nacimiento del alumno " + (i+1) + " (d-M-yyyy)"),
					io.readString("Dime el ciclo del alumno " + (i+1)),
					io.readString("Dime el grupo del alumno " + (i+1)),
					io.readString("Dime el curso del alumno " + (i+1))
					));
		}
		io.close();
	}

}
