package ejer2;

public class HiloC extends Thread{

	private int c;
	
	public HiloC(int c) {
		System.out.println("Creado el hilo: "+c);
		this.c=c;
	}
	
	public void run() {
		for (int i = 1; i < 6; i++) {
			
			System.out.println("Hilo "+c+" linea "+i);
			
		}
	}
	
	
}
