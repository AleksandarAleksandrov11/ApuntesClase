package ejercicio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	// Soy consciente de que el enunciado no pide opción de sarir pero la añado por
	// comodidad.
	private static final String[] OPCIONES = { "Generar fichero", "Seleccionar fichero", "Cargar alumno",
			"Mostrar alumnos", "Salir" };

	private static String fichero = null;

	public static void main(String[] args) {
		MaikIO io = new MaikIO(true);
		int opcion = 0;
		mostrarTitulo(io);
		while (opcion != 5) {
			io.list(OPCIONES, 0);
			io.hr(false);
			opcion = io.readInt("Selecciona una opcion [1-5]:");
			io.hr(true);
			procesarOpcion(io, opcion);
		}
		io.close();
	}

	private static void procesarOpcion(MaikIO io, int opcion) {
		switch (opcion) {
		case 1:
			crearFichero(io);
			break;
		case 2:
			seleccionarFichero(io);
			break;
		case 3:
			cargarAlumno(io);
			break;
		case 4:
			mostrarAlumnos(io);
			break;
		case 5:
			System.out.println("Fin del programa.");
			break;
		default:
			System.out.println("Opcion no valida.");
			io.hr(true);
			break;
		}
	}

	private static void mostrarAlumnos(MaikIO io) {
		if (fichero == null) {
			System.out.println("No hay fichero seleccionado.");
			io.hr(true);
			return;
		}
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(new File(fichero));
			ois = new ObjectInputStream(fis);
			while (true) {
				Alumno alumno = (Alumno) ois.readObject();
				System.out.println(alumno);
			}
		} catch (Exception e) {
			return;
		} finally {
			io.hr(true);
			try {
				if (ois != null) {
					ois.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void mostrarTitulo(MaikIO io) {
		io.hr(true);
		System.out.println("Tarea 6 - Alumnos y gestor de ficheros.");
		io.hr(true);
	}

	private static void crearFichero(MaikIO io) {
		fichero = io.readString("Dame el nombre del fichero:");
		File archivo = new File(fichero);
		try {
			io.hr(true);
			if (archivo.createNewFile()) {
				System.out.println("Fichero " + archivo.getName() + " creado.");
			} else {
				System.out.println("Error, el fichero ya existe.");
			}
			io.hr(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void seleccionarFichero(MaikIO io) {
		fichero = io.readString("Dame la ruta y el nombre de un fichero.");
		File archivo = new File(fichero);
		io.hr(true);
		System.out.println((archivo.exists() && !archivo.isDirectory()) ? ("Usando " + fichero) : "El archivo no existe");
		io.hr(true);
	}

	private static void cargarAlumno(MaikIO io) {
		if (fichero == null) {
			System.out.println("No hay fichero seleccionado.");
			io.hr(true);
			return;
		}
		Alumno alumno = leerAlumno(io);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(new File(fichero));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(alumno);
			System.out.println("Alumno " + alumno.getNombre() + " inscrito.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		io.hr(true);
	}
	
	public static Alumno leerAlumno(MaikIO io) {
		Alumno alumno = new Alumno(io.readInt("Dame el NIA"), io.readString("Dame el Nombre"),
				io.readString("Dame el Apellido"), io.readChar("Dame el Genero"),
				io.readDate("Dame la Fecha (d-M-yyyy)"), io.readString("Dame el Ciclo"), io.readString("Dame el Curso"),
				io.readString("Dame el Grupo"));
		io.hr(true);
		return alumno;
	}

}
