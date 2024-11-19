package Banco;

public class Cliente extends Thread {

	private Cuenta cuenta;
	private String nombre;
	private Double cantidad,total;
	
	public Cliente(Cuenta cuenta, String nombre, Double cantidad) {
		super();
		this.cuenta = cuenta;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.total = 0.0;
	}
	
	public void retirar() {
		
			cuenta.restarCantidad(cantidad);
			total = total + cantidad;
			
			System.out.println(nombre + " ha retirado " + cantidad + "€. Total retirado: " + total + "€.");
			try {
				Thread.sleep(50);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	public void run() {
		while (cuenta.comprobarSaldo(cantidad)) {
		retirar();
		}
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
}
