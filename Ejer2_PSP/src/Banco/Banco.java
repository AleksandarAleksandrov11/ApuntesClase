package Banco;

public class Banco {

	public static void main(String[] args) {
		
		Cuenta c1 = new Cuenta(1000.0);
		
		Cliente cl1 = new Cliente(c1,"Inigo",55.0);
		Cliente cl2 = new Cliente(c1,"Moha",25.0);
		
        cl1.start();
        cl2.start();

        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		System.out.println(cl1.getNombre()+" ha retirado "+cl1.getTotal());
		System.out.println(cl2.getNombre()+" ha retirado "+cl2.getTotal());
		
		c1.devolverSaldo();
		
	}
	
}
