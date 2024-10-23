package ejer4;

public class VariosHilosR {

	public static void main(String[] args) {
		
		HiloCR h;
		
		
		for (int i = 0; i < 5; i++) {
			
			h = new HiloCR(i+1);
			new Thread(h).start();;
			
			
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
