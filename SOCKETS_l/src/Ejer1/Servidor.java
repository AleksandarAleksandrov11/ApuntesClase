package Ejer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
	
		System.out.println("servidor");
		
		try {
		ServerSocket servidor = new ServerSocket();
		
		InetSocketAddress addres = new InetSocketAddress("localhost",5000);
		
		servidor.bind(addres);
		
		Socket cliente1 = servidor.accept();
		
		InputStream is = cliente1.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isr);
		
		String resCliente = "";
		
		OutputStream os = cliente1.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw,true);
		
		while((resCliente=bfr.readLine())!=null) {
			
			System.out.println("Recibiendo: "+resCliente);
			pw.println(resCliente);
			
		}
		
		System.out.println("cerrado");
		
		servidor.close();
		
		is.close();
		isr.close();
		bfr.close();
		
		os.close();
		osw.close();
		pw.close();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
