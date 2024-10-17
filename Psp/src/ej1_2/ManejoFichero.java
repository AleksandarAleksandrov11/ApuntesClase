package ej1_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//clase que mediante el file que hemos creado antes lo lee, y maneja la variable que va a ir sumando a medida que se lea.
public class ManejoFichero {
	private static final File file = new File("fichero.dat");
	private static FileReader conexion;
	private static BufferedReader read;
	private static String line;
	private static int counter = 0;
	private static int suma = 0;

// lee el archivo desde el numero que pasan hasta el numero
	public int leerfichero(File f, int startnumber, int endnumber) {
		try {
			conexion = new FileReader(f);
			read = new BufferedReader(conexion);

			while ((line = read.readLine()) != null) {
				counter++;
				if (counter >= startnumber && counter < endnumber) {
					suma += Integer.parseInt(line);
				}

				if (counter > endnumber) {
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (read != null) {
					read.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return suma;
	}
}
