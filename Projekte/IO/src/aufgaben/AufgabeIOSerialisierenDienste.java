package aufgaben;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dienst {
	private String name;

	public Dienst(String name) {
		this.name = name;
	}
}

class Defragmentierung extends Dienst {
	private int zeitabstand;
	private String laufwerk;

	Defragmentierung(int zeitabstand, String laufwerk) {
		super("Defrag");
		this.zeitabstand = zeitabstand;
		this.laufwerk = laufwerk;
	}

	@Override
	public String toString() {
		return "Zeitabstand(" + zeitabstand + "), LW(" + laufwerk + ")";
	}

	public String getLaufwerk() {
		return laufwerk;
	}

	public int getZeitabstand() {
		return zeitabstand;
	}
}

class SpeicherManager extends Dienst implements Serializable {

	private int size;
	transient private Defragmentierung defrag;

	SpeicherManager(int size, Defragmentierung defrag) {
		super("S-Man");
		this.size = size;
		this.defrag = defrag;
	}

	public String toString() {
		return "Manager. Size: " + size + ". Defrag-Dienst: " + defrag;
	}
}

public class AufgabeIOSerialisierenDienste {

	/*
	 *  Object
	 *     |
	 *  Dienst
	 *     |
	 *  SpeicherManager <- Serializable
	 * 
	 */
	public static void main(String[] args) {
		SpeicherManager sManager = new SpeicherManager(2000, new Defragmentierung(3000, "C:\\"));

		String fileName = "sManager.bin";

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {

			oos.writeObject(sManager);
			System.out.println("*** Serialisiert: ");
			System.out.println(sManager);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			SpeicherManager sManager2 = (SpeicherManager)ois.readObject();
			System.out.println("\n*** Deserialisiert:");
			System.out.println(sManager2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
