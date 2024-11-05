package serialisieren;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class B04_manuell_Serialisieren {

	/*
	 * Stellen wir uns vor, dass die Klasse GameObject
	 * nicht Serializable sein kann (z.B. ist Klasse aus einer externen Bibliothek).
	 */
	static class GameObject {
		int id; 
	}
	
	/*
	 * Stellen wir uns vor, dass die Klasse Motor
	 * nicht Serializable sein kann (z.B. ist Klasse aus einer externen Bibliothek).
	 */
	static class Motor {
		String typ;
		
		public String toString() {
			return typ;
		}
	}
	
	static class Auto extends GameObject implements Serializable {
		String hersteller;
		int baujahr;
		
		transient Motor motor; 
		
		public String toString() {
			return "id: " + id + 
					", hersteller: " + hersteller + 
					", baujahr: " + baujahr + 
					", motor: " + motor;
		}
		
		private void writeObject(ObjectOutputStream oos) throws IOException {
			System.out.println("in meiner writeObject");
			
			oos.defaultWriteObject();
			
			oos.writeInt(id);
			oos.writeUTF(motor.typ);
		}
		
		private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
			System.out.println("in meiner readObject");
			
			ois.defaultReadObject();
			
			this.id = ois.readInt();
			
			this.motor = new Motor();
			this.motor.typ = ois.readUTF();
		}
	}
	
	
	public static void main(String[] args) {

		String fileName = "a4";
		Auto a1 = new Auto();
		
		a1.id = 771;
		a1.hersteller = "VW";
		a1.baujahr = 2023;
		
		a1.motor = new Motor();
		a1.motor.typ = "MS18";

		
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
		

	}

}
