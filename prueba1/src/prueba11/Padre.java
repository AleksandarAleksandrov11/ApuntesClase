package prueba11;

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
		
		
		hijo = new ProcessBuilder("java", "-jar", ".\\hijoPrueba.jar").start();
		
		
		
		
		OutputStream os = hijo.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw);
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime un numero");
		
		pw.println(sc.nextInt());
		pw.flush();
		
		
		
		InputStream is = hijo.getInputStream();
		InputStreamReader isw = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isw);
		
		String linea;
		
		while((linea = bfr.readLine())!=null) {
			System.out.println(linea);
		}
			
		
		os.close();
		osw.close();
		pw.close();
		is.close();
		isw.close();
		bfr.close();
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
