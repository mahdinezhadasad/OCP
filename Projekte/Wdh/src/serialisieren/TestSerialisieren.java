package serialisieren;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

class GameObject {
	int id;
	
	public GameObject() {
		System.out.println("GameObject()");
	}
}


class Fisch {}

class Aquarium extends GameObject implements Serializable {
	int preis;
	
	String name;
	
	Fisch[] fische = new Fisch[5];
	
	
	public Aquarium() {
		System.out.println("Aquarium()");
	}
	
	public String toString() {
		return "Aquarium.  id = " + id +
				", name=" + name +
				", preis=" + preis +
				", fische: " + 
					Arrays.toString(fische);
	}
}

public class TestSerialisieren {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Aquarium a1 = new Aquarium();
		a1.id = 33;
		a1.preis = 123;
		a1.name = "Gross";
		a1.fische[0] = new Fisch(); // Fisch ist nicht Serializable

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("a.bin"))) {
			
			oos.writeObject(a1); // Exception
			
			System.out.println("Serialisiert: " + a1);
		}
		
		System.out.println("--------------------");
		
		Aquarium a2;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.bin"))) {
			a2 = (Aquarium)ois.readObject();
		}
		
		System.out.println("Deserialisiert: " + a2);
	}

}
