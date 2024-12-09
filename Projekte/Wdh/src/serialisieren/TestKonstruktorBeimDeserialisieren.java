package serialisieren;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestKonstruktorBeimDeserialisieren {

	static class Auto {
		Auto(int x) {
			System.out.println("Auto(int)");
		}
	}
	
	static class PKW extends Auto implements Serializable {
		PKW() {
			super(12);
			System.out.println("PKW()");
		}
	}
	
	public static void main(String[] args) {

		serialisieren();
		System.out.println("---------------------");
		deserialisieren();
	}

	static void serialisieren() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("b.bin"))) {
			oos.writeObject(new PKW());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void deserialisieren() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("b.bin"))) {
			PKW pkw = (PKW)ois.readObject(); // Exception beim Deserialisieren!
											 // Nicht-Serializable-Basisklasse hat 
											 // keinen noargs-Konstruktor
			System.out.println("Deserialisiert: " + pkw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
