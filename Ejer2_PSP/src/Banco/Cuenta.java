package Banco;

public class Cuenta {

	private Double saldo;
	private int n_reintegros;
	
	public Cuenta(Double saldo) {
		this.saldo=saldo;
		this.n_reintegros=0;
	}
	
	public synchronized  Double devolverSaldo() {
		System.out.println("El saldo es "+saldo);
		System.out.println("Ha habido "+n_reintegros+" reintegros");
		return saldo;
	}
	
	public synchronized  void restarCantidad(Double cantidad) {
		
		if(comprobarSaldo(cantidad)) {
		saldo = saldo - cantidad;
		n_reintegros++;
		}else {
			System.out.println("No hay tanto saldo");
		}
		
	}
	
	public boolean comprobarSaldo(Double cantidad) {
		
		if(saldo>=cantidad) {
			return true;
		}else {
			return false;
		}
		
	}

	public int getN_reintegros() {
		return n_reintegros;
	}

	public void setN_reintegros(int n_reintegros) {
		this.n_reintegros = n_reintegros;
	}

}
