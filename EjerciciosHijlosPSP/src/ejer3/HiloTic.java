package ejer3;

public class HiloTic extends Thread {

	public void run() {
		
		int cont = 0;
		
		while(cont!=1) {
			
			System.out.println("TIC");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
