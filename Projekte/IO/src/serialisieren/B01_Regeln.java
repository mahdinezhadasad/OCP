package serialisieren;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class B01_Regeln {
	
	static class Motor implements Serializable {
		String typ = "T1";
	}
	
	static class Auto implements Serializable {
		Motor motor = new Motor();
		int baujahr;
		
		@Override
		public String toString() {
			return "Auto. Baujahr: " + baujahr + ". Motor: " + motor.typ;
		}
	}

	/*
	 * Ein Objekt ist serialisierbar wenn:
	 * 
	 * 		- seine Klasse IST Serializable
	 *        und alle Attribute (rekursiv) erfüllen die Regeln fürs Serialisieren.
	 *        - Primitive Attribute sind automatisch serialisierbar.
	 *        - transient-Attribute werden beim Serialisieren übersprungen.
	 *        
	 * 		- Objekt ist ein Array (Arrays sind serialisierbar)
	 * 		  - alle Elemente von einem Referenzen-Array (rekursiv) 
	 *          müssen die Regeln fürs Serialisieren erfüllen 
	 *        - Primitive Elemente sind automatisch serialisierbar.
	 * 
	 * Deserialisieren:
	 * 
	 * 		- Beim Deserialisieren wird der noargs-Konstruktor der 
	 *        (in der Vererbungshierarchie) tiefsten Nicht-Serializable-Basisklasse
	 *        aufgerufen.
	 *        Wenn diese Nicht-Serializable-Basisklasse keinen noargs-Konstruktor hat,
	 *        gibt es beim Deserialisiren eine Exception.
	 *        
	 *        Z.B.:
	 *        
	 *           Object
	 *              |
	 *           GameObject      Serializable
	 *              |               |
	 *              ----------------
	 *                      |
	 *                     Auto
	 *                     
	 *   	  Klasse GameObject muss den noargs-Konstruktor haben, 
	 *        damit ein Auto-Objekt deserialisiert werden kann.
	 *   
	 */
	public static void main(String[] args) {
		
		String fileName = "a1";
		Auto a1 = new Auto();
		
		a1.baujahr = 2011;
		a1.motor.typ = "MX22";
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(a1);
			System.out.println("Serialisiert: " + a1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Auto a2 = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			a2 = (Auto)ois.readObject();
			System.out.println("Deserialisiert: " + a2);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Referenzen unterschiedlich: " + (a1 != a2)); // true

	}

}
