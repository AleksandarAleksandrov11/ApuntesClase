package ejer3;

public class HiloTac extends Thread{

	public void run() {
		
		int cont = 0;
		
		while(cont!=1) {
			
			System.out.println("TAC");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
