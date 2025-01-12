package Generics.src.generics;



import java.io.*;

// Basisklasse, die NICHT serialisierbar ist
class NichtSerializable {
    private String nichtSerialisierbaresFeld;
    
    // Notwendig: Ein no-args-Konstruktor
    public NichtSerializable() {
        this.nichtSerialisierbaresFeld = "Standardwert";
        System.out.println("NichtSerializable no-args Konstruktor aufgerufen");
    }
    
    public NichtSerializable(String wert) {
        this.nichtSerialisierbaresFeld = wert;
    }
    
    public String getNichtSerialisierbaresFeld() {
        return nichtSerialisierbaresFeld;
    }
}

// Subklasse, die serialisierbar ist
class Serialisierbar extends NichtSerializable implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String serialisierbaresFeld;
    
    public Serialisierbar(String nichtSerialisierbaresFeld, String serialisierbaresFeld) {
        super(nichtSerialisierbaresFeld); // Aufruf des Basisklassen-Konstruktors
        this.serialisierbaresFeld = serialisierbaresFeld;
    }
    
    public String getSerialisierbaresFeld() {
        return serialisierbaresFeld;
    }
}

public class SerialisierungBeispiel {
    public static void main(String[] args) {
        Serialisierbar objekt = new Serialisierbar("Wert1", "Wert2");
        
        // Serialisierung
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objekt.ser"))) {
            oos.writeObject(objekt);
            System.out.println("Objekt wurde serialisiert.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Deserialisierung
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objekt.ser"))) {
            Serialisierbar deserialisiertesObjekt = (Serialisierbar) ois.readObject();
            System.out.println("Objekt wurde deserialisiert.");
            System.out.println("Nicht-serialisierbares Feld: " +
                    deserialisiertesObjekt.getNichtSerialisierbaresFeld());
            System.out.println("Serialisierbares Feld: " +
                    deserialisiertesObjekt.getSerialisierbaresFeld());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}