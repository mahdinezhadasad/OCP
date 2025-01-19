package IO.src.serialisieren;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cereal implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String name ;
    private transient int sugar;
    
    public Cereal() {
        super();
        this.name =name;
        
    }
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getSugar() {
        return sugar;
    }
    
    public void setSugar(int sugar) {
        this.sugar = sugar;
    }
    
    public static void main(String[] args) {
        
        Cereal c = new Cereal();
        c.setName("CornLoops");  // We set it to "CornLoops"
        
        // Serialize to a file
        try (ObjectOutputStream oos =
                     new ObjectOutputStream (new FileOutputStream ("cereal.txt"))) {
            oos.writeObject(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Deserialize from that file
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream ("cereal.txt"))) {
            Cereal deserialized = (Cereal) ois.readObject();
            System.out.println("Deserialized name = " + deserialized.getName());
            // This should print "CornLoops"
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}