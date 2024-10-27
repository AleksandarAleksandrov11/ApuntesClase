package ejercicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MaikIO {
	private static Scanner sc = null;
	
	public MaikIO(boolean useScanner) {
		if (sc == null && useScanner) {
			sc = new Scanner(System.in);
		}
	}
	
	// Read:
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
	
	// Write:
	public void list_element(char symbol, String text, int spaceNum) {
		if (spaceNum < 0) {
			return;
		}
		
		for (int i = 0; i < spaceNum; i++) {
			System.out.print(" ");
		}
		System.out.println(symbol + " " + text);
	}
	
	public void list_element(char symbol, String text) {
		for (int i = 0; i < 4; i++) {
			System.out.print(" ");
		}
		System.out.println(symbol + " " + text);
	}
	
	public void list_element(int pos, String text, int spaceNum) {
		if (spaceNum < 0) {
			return;
		}
		
		for (int i = 0; i < spaceNum; i++) {
			System.out.print(" ");
		}
		System.out.println(pos + ". " + text);
	}
	
	public void list_element(int pos, String text) {
		for (int i = 0; i < 4; i++) {
			System.out.print(" ");
		}
		System.out.println(pos + ". " + text);
	}
	
	public void list(List<String> elements, char symbol, int spaceNum) {
		for (String i : elements) {
			list_element(symbol, i, spaceNum);
		}
	}
	
	public void list(List<String> elements, char symbol) {
		for (String i : elements) {
			list_element(symbol, i);
		}
	}
	
	public void list(List<String> elements, int spaceNum) {
		for (int i = 0; i < elements.size(); i++) {
			list_element(i + 1, elements.get(i), spaceNum);
		}
	}
	
	public void list(List<String> elements) {
		for (int i = 0; i < elements.size(); i++) {
			list_element(i + 1, elements.get(i));
		}
	}
	
	public void list(String[] elements, char symbol, int spaceNum) {
		for (String i : elements) {
			list_element(symbol, i, spaceNum);
		}
	}
	
	public void list(String[] elements, char symbol) {
		for (String i : elements) {
			list_element(symbol, i);
		}
	}
	
	public void list(String[] elements, int spaceNum) {
		for (int i = 0; i < elements.length; i++) {
			list_element(i + 1, elements[i], spaceNum);
		}
	}
	
	public void list(String[] elements) {
		for (int i = 0; i < elements.length; i++) {
			list_element(i + 1, elements[i]);
		}
	}
	
	public void list_inline(String[] elements) {
		for (int i = 0; i < elements.length; i++) {
			System.out.print(elements[i]);
			if (i < elements.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
	public void hr(boolean lines) {
		if (lines) {
			System.out.println("-----------------------------------------------------------------");
		} else {
			System.out.println();
		}
	}
	
	
	public void close() {
		if (sc != null) {
			sc.close();
			sc = null;
		}
	}
}
