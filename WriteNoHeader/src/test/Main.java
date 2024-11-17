package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Main {

	static class Boss extends ObjectOutputStream {

		public Boss(OutputStream out) throws IOException {
			super(out);
		}
		
		@Override
		public void writeStreamHeader() throws IOException {
			reset();
		}

	}
	
	public static void main(String[] args) {
		File file = new File("test.dat");
		if (file.exists()) {
			writeNoHeader(file);
		} else {
			writeWithHeader(file);
		}
		try(ObjectInputStream ois = new ObjectInputStream(new DataInputStream(new FileInputStream(file)))) {
			while(true) {
				System.out.println(ois.readUTF());
			}
		} catch (EOFException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void writeWithHeader(File file) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new DataOutputStream(new FileOutputStream(file, true)))) {
			oos.writeUTF("Cheese");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void writeNoHeader(File file) {
		try(Boss boss = new Boss(new DataOutputStream(new FileOutputStream(file, true)))) {
			boss.writeUTF("Cheese");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
