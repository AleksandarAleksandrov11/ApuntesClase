package ejercicio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class Main {

	private static String DESTINO = ".\\src\\archivo_class\\";

	public static void main(String[] args) {
		// Terminamos el programa si no recive un solo argumento:
		if (args.length != 1) {
			System.out.println("Error: Se espera un solo argumento, la ruta y nombre del .java");
			return;
		}
		// Compilamos el codigo y nos aseguramos de que no tenga errores:
		int resultado = 0;
		try {
			Process proceso = new ProcessBuilder("javac", args[0]).start();
			long tiempoInicio = System.currentTimeMillis();
			TerminarProceso terminar = terminarProceso(proceso);
			resultado = proceso.waitFor();
			// Calculamos el tiempo de ejecución del proceso:
			long tiempoFinal = System.currentTimeMillis() - tiempoInicio;
			System.out.println("Tiempo: " + tiempoFinal + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (resultado == 0) {
			System.out.println("Compilado con exito");
			copiarArchivo(args);
		} else {
			System.out.println("Error de compilacion");
		}
	}

	// Movemos el archivo a la ruta especificada:
	private static void copiarArchivo(String[] args) {
		String rutaClass = args[0].replace(".java", ".class");
		File archivoClass = new File(rutaClass);
		try {
			Path destino = Paths.get(DESTINO, archivoClass.getName());
			Files.copy(archivoClass.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Error, copia de archivos fallada");
			return;
		}
		System.out.println("Archivo copiado con exito");
	}
	
	// Iniciamos un hilo para terminar el proceso si queremos:
	private static TerminarProceso terminarProceso(Process proceso) {
        System.out.println("Pulsa q para terminar");
        TerminarProceso terminar = new TerminarProceso(proceso);
        terminar.start();
        return terminar;
    }

}
