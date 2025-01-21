package IO.src.serialisieren;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        
        System.out.println (Paths.get("/sang").getParent());
        System.out.println (Paths.get("/sang").getRoot ());
    }
}

 class Surgeon {
    public Path dissectAndRebuild(Path p) {
        Path v = p.getRoot(); // Start with the root
        for (int i = 0; i < p.getNameCount(); i++) {
            v = v.resolve(p.getName(i));
        }
        return v;
    }
    
    public static void main(String... tools) throws Exception {
        final Surgeon a1 = new Surgeon();
        Path original = Paths.get("/tissue/heart/chambers.txt");
        Path repaired = a1.dissectAndRebuild(original);
        System.out.print(original.equals(repaired)); // Output: true
    }
}