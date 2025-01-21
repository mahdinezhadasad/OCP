package IO.src.serialisieren;

import javax.xml.xpath.XPath;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public static void jenniferReads(Path p) throws IOException {
        Files.lines (p);
    }
    
    public void jonReads(Path p) throws IOException {
        Files.readAllLines (p);
    }
    public static Stream<String> readlines(Path p) throws IOException {
        
        return Files.lines(p);
    }
    
    public static long count(Path p) throws IOException {
        
        return Files.list (p)
                .filter (w -> Files.isRegularFile (w))
                .flatMap (s -> {
                    try {
                        return readlines (s);
                    } catch (IOException e) {
                        throw new RuntimeException (e);
                    }
                })
                .count ();
    }
    
    public static void main(String... tools) throws Exception {
        
        
        System.out.println (count (Paths.get ("D:\\Udacity_Java_Entwikler\\ocp\\Projekte\\Localization\\src\\aufgaben")));
        
        
        //final Surgeon a1 = new Surgeon();
        //  Path original = Paths.get("/tissue/heart/chambers.txt");
        // Path repaired = a1.dissectAndRebuild(original);
        // System.out.print(original.equals(repaired)); // Output: true
        
      /*  Path v1 = Paths.get("/./desert/./").resolve(Paths.get("sand.doc"));
        Path v2 = new File ("/desert/./cactus/../sand.doc").toPath();
        //System.out.print(Files.isSameFile(v1,v2));
        System.out.println (v1.normalize ());
        System.out.println (v2.normalize ());
        System.out.print(" "+v1.equals(v2));
        System.out.print(" "+v1.normalize().equals(v2.normalize()));*/
        // printInfo ();
        
        
        
        Path path = Paths.get("/project/src/main/java/com/example/App.java");
       // jenniferReads (path);
        // Print original path
        System.out.println("Original Path: " + path);
        
        // Extract subpath
        Path subPath = path.subpath(2, 5);
        System.out.println("Subpath (2, 5): " + subPath);
        
        // Resolve a new path
        Path resolvedPath = subPath.resolve("Helper.java");
        System.out.println("Resolved Path: " + resolvedPath);
        
        // Normalize the resolved path
        Path normalizedPath = resolvedPath.normalize();
        System.out.println("Normalized Path: " + normalizedPath);
    }
    
    public static void printInfo(){
        
        Path halleysComet = Paths.get("stars/./rocks/../m1.meteor").normalize();
        System.out.println (halleysComet + " let see");
        Path lexellsComet = Paths.get("./stars/../solar/");
        System.out.println ( lexellsComet + " Second let see");
        
        lexellsComet = lexellsComet.subpath(0, 2)
                .resolve("m1.meteor")
                .normalize();
        System.out.println (lexellsComet + "\n after changing happend");
        System.out.print(halleysComet.equals(lexellsComet)
                ? "Same!" : "Different!");
        
      //  System.out.println (halleysComet.equals (lexellsComet) ? "Same!":"Different!");
        
        
    }
}