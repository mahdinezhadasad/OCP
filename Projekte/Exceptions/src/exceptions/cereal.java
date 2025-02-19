package Exceptions.src.exceptions;

import java.io.*;
import java.nio.file.Files;
import java.util.stream.Stream;

class Cereal implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name = "CocoaCookies"; // 1. Feldinitialisierung
    private transient int sugar; // Transient, wird nicht gespeichert
    
    // 2. Initialisierungsblock
    {
        name = "SSSS"; // Wird bei normaler Objekterstellung gesetzt
    }
    
    // 3. Konstruktor
    public Cereal() {
        this.name = "CaptainPebbles";
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getSugar() { return sugar; }
    public void setSugar(int sugar) { this.sugar = sugar; }
    
    public void deleteTree(File f){
        
        if(!f.isDirectory ()){
            f.delete ();
        }else {
            
            Stream.of (f.list ())
                    .forEach (s -> deleteTree (new File (f,s)));
            
        }
    }
}

 class CerealSerializationTest {
    public static void main(String[] args) {
        Cereal cereal = new Cereal();
        cereal.setName("CornLoops"); // Vor Serialisierung gesetzt
        
        // Serialisieren
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cereal.ser"))) {
            oos.writeObject(cereal);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Deserialisieren
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cereal.ser"))) {
            Cereal deserializedCereal = (Cereal) ois.readObject();
            System.out.println("Deserialized name: " + deserializedCereal.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}