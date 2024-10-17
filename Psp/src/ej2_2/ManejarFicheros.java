package ej2_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManejarFicheros {
	private static final File usedfiletoread = new File("fichero.txt");
	private String chosencharacter;
	private File usedfiletowrite;
	private static FileReader conexion;
	private static BufferedReader read;
	private static String line;
	private static FileWriter conexionwrite;
	private static BufferedWriter write;

	public ManejarFicheros(String chosencharacter,File usedfiletowrite) {
		this.chosencharacter = chosencharacter;
		this.usedfiletowrite = usedfiletowrite;
	}

	public void readfile() {
		try {
			conexion = new FileReader(usedfiletoread);
			read = new BufferedReader(conexion);
			while ((line = read.readLine()) != null) {
				if (line.equalsIgnoreCase(chosencharacter)) {
					writeinfile(chosencharacter);
				}
			}
			closereadFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeinfile(String chosencharacter) {
		try {
			conexionwrite = new FileWriter(usedfiletowrite);
			write = new BufferedWriter(conexionwrite);
			write.write(chosencharacter);
			write.newLine();
			closewriteFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closereadFile() {
		try {
			if (read != null) {
				read.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closewriteFile() {
		try {
			if (write != null) {
				write.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
