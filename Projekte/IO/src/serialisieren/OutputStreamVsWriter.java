package IO.src.serialisieren;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OutputStreamVsWriter {
    
    public static void main(String[] args) {
        
        
        File file = new File ("/Earth");
        System.out.print(file.getParentFile()
                + " - "
                + file.getParentFile().getParent());
        
        System.out.println ("\n dddddddddddddddddddddd");
        
        Path path1 = Paths.get("/Earth");
        System.out.println("Path: " + path1);
        System.out.println("Parent with one Parent: " + path1.getParent());
        System.out.println ("Parent with two getParent(): " + path1.getParent().getParent ());
        
    }
}