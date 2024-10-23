package ejer1;

public class DentroFuera {

	public static void main(String[] args) {
		
		HiloFor h = new HiloFor();
		
		h.start();
		
		
		for (int i = 0; i < 10; i++) {
			
			System.out.println("Estoy fuera del hilo");
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
