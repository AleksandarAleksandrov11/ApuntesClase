

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MaikIO {
	private static Scanner sc = null;
	
	public MaikIO() {
		if (sc == null) {
			sc = new Scanner(System.in);
		}
	}
	
	public int readInt(String message) {
		if (sc == null) {
			return -1;
		}
		System.out.println(message);
		boolean exit = false;
		int num = 0;
		while(!exit) {
			try {
				num = sc.nextInt();
				exit = true;
			} catch(Exception e) {
				System.out.println("Valor incorrecto.");
			}
			finally {
				sc.nextLine();
			}
		}
		return num;
	}
	
	public char readChar(String message) {
		if (sc == null) {
			return ' ';
		}
		System.out.println(message);
		return sc.nextLine().charAt(0);
	}
	
	public String readString(String message) {
		if (sc == null) {
			return null;
		}
		System.out.println(message);
		return sc.nextLine();
	}
	
	public LocalDate readDate(String message) {
		if (sc == null) {
			return null;
		}
		System.out.println(message);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d-M-yyyy");
        String date = sc.nextLine();
        return LocalDate.parse(date, format);
	}
	
	public void hr() {
		System.out.println();
	}
	
	public void close() {
		if (sc != null) {
			sc.close();
			sc = null;
		}
	}
}
