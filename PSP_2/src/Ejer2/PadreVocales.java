package Ejer2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PadreVocales {

	public static void main(String[] args) {

		System.out.println(
				"Hay " + (leerVocales("a") + leerVocales("e") + leerVocales("i") + leerVocales("o") + leerVocales("u"))
						+ " vocales");

	}

	public static int leerVocales(String vocal) {

		Process hijo;
		int suma = 0;
		try {
			hijo = new ProcessBuilder("java", "-jar", "HijoVocales.jar", vocal, vocal + ".txt").start();
			hijo.waitFor();

			BufferedReader bfr = new BufferedReader(new FileReader(new File(vocal + ".txt")));

			String linea;

			while ((linea = bfr.readLine()) != null) {

				suma = Integer.parseInt(linea) + suma;

			}

			bfr.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
			return suma;
		
	}

}
