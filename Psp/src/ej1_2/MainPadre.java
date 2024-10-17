package ej1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainPadre {
	private static Scanner abielto = new Scanner(System.in);
	private static String line;

	public static void main(String[] args) {
		try {

			Process process = new ProcessBuilder("java", "-jar", "sumanumeros1000.jar").start();
			OutputStream conexion = process.getOutputStream();
			OutputStreamWriter conexion2 = new OutputStreamWriter(conexion);
			PrintWriter write = new PrintWriter(conexion2);
			write.println(abielto.nextInt());
			write.println(abielto.nextInt());
			
			write.flush();

			InputStream conexionleer = process.getInputStream();
			InputStreamReader conexionleer2 = new InputStreamReader(conexionleer);
			BufferedReader read = new BufferedReader(conexionleer2);

			while ((line = read.readLine()) != null) {
				System.out.println(line);
			}

			conexion.close();
			conexion2.close();
			write.close();
			conexionleer.close();
			conexionleer2.close();
			abielto.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
