package serialisieren;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class B03_AttributIstNichtSerializable {

	/*
	 * Stellen wir uns vor, dass die Klasse Motor
	 * nicht Serializable sein kann (z.B. ist Klasse aus einer externen Bibliothek).
	 */
	static class Motor {
	}
	
	static class Auto implements Serializable {
		transient Motor motor; // wird beim Serialisieren übersprungen
		int baujahr;
		
		@Override
		public String toString() {
			return "Auto. Baujahr: " + baujahr + ". Motor: " + motor;
		}
	}
	
	public static void main(String[] args) {
		String fileName = "a3";
		Auto a1 = new Auto();
		
		a1.baujahr = 2011;
		a1.motor = new Motor();
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(a1); // motor wird nicht serialisiert
			System.out.println("Serialisiert: " + a1); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Auto a2 = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			a2 = (Auto)ois.readObject(); 
			System.out.println("Deserialisiert: " + a2); // motor ist null
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
