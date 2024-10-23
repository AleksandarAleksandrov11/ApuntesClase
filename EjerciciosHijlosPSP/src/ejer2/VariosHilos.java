package ejer2;

public class VariosHilos {

	public static void main(String[] args) {
		
		HiloC h;
		
		
		for (int i = 0; i < 5; i++) {
			
			h = new HiloC(i+1);
			h.start();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Todos los hilos creados");
		
		
		
	}
	
	
}
