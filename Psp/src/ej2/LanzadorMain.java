package ej2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LanzadorMain {
	public static void main(String[] args) {
		Scanner abielto = new Scanner(System.in);
		ProcessBuilder pb = new ProcessBuilder(args);
		String linea;
		while (!abielto.next().equals("fin")) {
			try {
				Process proceso = pb.start();
				InputStream is = proceso.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader leer = new BufferedReader(isr);
				while ((linea = leer.readLine()) != null) {
					System.out.println(linea);
				}
				is.close();
				isr.close();
				proceso.destroy();
				leer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		abielto.close();
	}
}
