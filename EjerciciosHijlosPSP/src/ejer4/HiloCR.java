package ejer4;

public class HiloCR implements Runnable{

	private int c;
	
	public HiloCR(int c) {
		System.out.println("Creado el hilo: "+c);
		this.c=c;
	}
	
	public void run() {
		for (int i = 1; i < 6; i++) {
			
			System.out.println("Hilo "+c+" linea "+i);
			
		}
	}
	
	
}
