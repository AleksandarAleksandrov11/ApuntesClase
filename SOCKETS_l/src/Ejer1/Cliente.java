package Ejer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		
		System.out.println("cliente");
		
		Socket cliente = new Socket();
		InetSocketAddress adresCliente = new InetSocketAddress("localhost",5000);
		
		Scanner sc = new Scanner(System.in);
		
		try {
			cliente.connect(adresCliente);
			
			OutputStream os = cliente.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw,true);
			
			InputStream is = cliente.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bfr = new BufferedReader(isr);
			
			String res = "";
			
			while(!res.equalsIgnoreCase("fin")) {
				
				System.out.print("Introduce cadena: ");
				res = sc.nextLine();
				
				pw.println(res);
				
				String resCliente2 = "";
				
				resCliente2 = bfr.readLine();
					
				System.out.println("ECO: "+resCliente2);
					
				
			
			}
			
			System.out.println("cerrando conx");
			
			cliente.close();

			os.close();
			osw.close();
			pw.close();
			
			is.close();
			isr.close();
			bfr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
