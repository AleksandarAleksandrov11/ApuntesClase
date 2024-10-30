package archivo_java;

import java.util.concurrent.TimeUnit;

public class Archivo {

	public static void main(String[] args) {
		// Pretendemos hacer algun tipo de operacion que dure un tiempo:
		for (int i = 0; i < 5; i++) {
			System.out.print("Cargando archivo " + (i + 1) + ": ");
			for (int j = 0; j < 3; j++) {
				esperar(1);
				System.out.print(".");
			}
			esperar(2);
			System.out.println();
		}
		// Operacion falsa terminada:
		System.out.println("Archivos cargados con exito");
	}
	
	// Dormimos el programa unos segundos:
	public static void esperar(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException e) {
		}
	}

}
