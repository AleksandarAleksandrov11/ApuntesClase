//package ej1_2;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//
////Esta clase crea un fichero el cual va a rellenar con 1000 numeros enteros 
//public class CrearFichero {
//	private static final File fichero = new File("fichero.dat");
//	private static BufferedWriter write;
//	private static FileWriter conexion;
//
//	// Constructor que crea directamente el fichero cuando se crea el objeto
//	public CrearFichero() {
//		try {
//			conexion = new FileWriter(fichero);
//			write = new BufferedWriter(conexion);
//			for (int i = 0; i <= 1000; i++) {
//				write.write(i);
//				write.newLine();
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				write.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	public static File getFichero() {
//		return fichero;
//	}
//
//}
