package serialisieren;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class B02_BasisklasseIstNichtSerializable {
	
	/*
	 * Stellen wir uns vor, dass die Klasse GameObject
	 * nicht Serializable sein kann (z.B. ist Klasse aus einer externen Bibliothek).
	 */
	static class GameObject {
		int id; // wird beim Serialisieren von einem Auto nicht mitserialisiert
		
		GameObject() {
			System.out.println("GameObject()");
		}
	}

	static class Auto extends GameObject implements Serializable {
		String hersteller;
		int baujahr;
		
		Auto() {
			System.out.println("Auto()");
		}
		
		public String toString() {
			return "id: " + id + ", hersteller: " + hersteller + ", baujahr: " + baujahr;  
		}
	}

	public static void main(String[] args) {
		
		String fileName = "a2";
		Auto a1 = new Auto();
		
		a1.id = 209;
		a1.baujahr = 2011;
		a1.hersteller = "VW";
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(a1);
			System.out.println("Serialisiert: " + a1); //id: 209, hersteller: VW, baujahr: 2011
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Auto a2 = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			a2 = (Auto)ois.readObject(); // Konstruktor GameObject() wird aufgerufen
			System.out.println("Deserialisiert: " + a2); // id: 0, hersteller: VW, baujahr: 2011
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
