package Ejer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Padre {

	public static void main(String[] args) {
		
		Process hijo;
		
		try {
			
			hijo = new ProcessBuilder("java", "-jar", ".\\hijoEjer1.jar").start();
			
			Scanner sc = new Scanner(System.in);
			
			OutputStream os = hijo.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			System.out.println("Dime la linea desde la que quieres empezar");
			pw.println(sc.nextInt());
			pw.flush();
			
			System.out.println("Dime la linea donde quieres acabar");
			pw.println(sc.nextInt());
			pw.flush();
			
			InputStream is = hijo.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bfr = new BufferedReader(isr);
			
			String linea;
			
			while((linea=bfr.readLine())!=null) {
				System.out.println(linea);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
}
