package ejercicio;

import java.util.Scanner;

public class TerminarProceso extends Thread {
	private Process proceso;
	private Scanner sc = new Scanner(System.in);

	public TerminarProceso(Process proceso) {
        this.proceso = proceso;
    }

	@Override
	public void run() {
		// Para un proceso pasado por el constructor:
		while (true) {
			String entrada = sc.nextLine();
			if (entrada.equalsIgnoreCase("q") || !proceso.isAlive()) {
				proceso.destroy();
				sc.close();
				return;
			}
		}
	}
}
