package Ejer1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Hijo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int lineaInicial,lineaFinal;
		
		lineaInicial=sc.nextInt();
		lineaFinal=sc.nextInt();
		
		try {
			
			BufferedReader bfr = new BufferedReader(new FileReader(new File(".\\numeros.dat")));
			
			for (int i = 0; i < lineaInicial-1; i++) {
				
				bfr.readLine();
			
			}
			
			int cont=lineaInicial;
			
			String linea;
			int suma=0;
			
			while((linea=bfr.readLine())!=null && cont!=lineaFinal+1) {
				
				suma = suma + Integer.parseInt(linea);
				
				cont++;
				
			}
			
			System.out.println("La suma es " + suma);
			
			
			bfr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
