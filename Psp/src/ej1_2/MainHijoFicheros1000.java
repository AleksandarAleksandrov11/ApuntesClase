package ej1_2;

import java.io.File;
import java.util.Scanner;

public class MainHijoFicheros1000 {
	public static void main(String[] args) {
		Scanner abielto = new Scanner(System.in);
		File f = new File("numeros.dat");
//		CrearFichero f = new CrearFichero();
		ManejoFichero mf = new ManejoFichero();
		System.out.println(mf.leerfichero(f, abielto.nextInt(), abielto.nextInt()));
	}
}
