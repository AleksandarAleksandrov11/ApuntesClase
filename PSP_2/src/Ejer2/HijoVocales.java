package Ejer2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class HijoVocales {

	public static void main(String[] args) {

		try {
			BufferedReader bfr = new BufferedReader(new FileReader(new File("FicheroVocales.txt")));
			BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(args[1])));

			String linea;
			int contVocales = 0;

			while ((linea = bfr.readLine()) != null) {

				char[] letras = linea.toCharArray();

				for (char l : letras) {

					if ((l + "").equalsIgnoreCase(args[0])) {
						contVocales++;
					}

				}

			}

			bfw.write(contVocales + "");

			bfr.close();
			bfw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
