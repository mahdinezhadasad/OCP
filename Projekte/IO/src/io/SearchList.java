package IO.src.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.nio.file.Files.copy;
import static java.nio.file.Files.newOutputStream;
import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class SearchList<T> {
    private List<T> data;
    private AtomicBoolean foundMatch = new AtomicBoolean(false);
    
    public SearchList(List<T> list) {
        this.data = list;
    }
    
    public void exists(T value, int start, int end) {
        if (end - start <= 1) {
            foundMatch.compareAndSet(false, value.equals(data.get(start)));
        } else {
            final int middle = start + (end - start) / 2;
            new Thread(() -> exists(value, start, middle)).run ();
            new Thread(() -> exists(value, middle, end)).run ();
        }
    }
    
    public static void main(String[] args) throws Exception {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6);
        SearchList<Integer> t = new SearchList<>(data);
        t.exists(5, 0, data.size());
        Thread.sleep(100); // Wait for threads to complete
        System.out.println(t.foundMatch.get());
    }
}

class Notes {
    
    public void tendGarden(Path p) throws Exception {
        
        Files.walk (p, 1)
                .map (p1 -> p1.toString ())
                .forEach (System.out::println);
    }
    
    public static void organize(Path folder, Path file) throws IOException {
        Path p = folder.resolve (file);
        
        // Fetch file attribute view
        BasicFileAttributeView vw = Files.getFileAttributeView (p, BasicFileAttributeView.class);
        
        // Ensure that vw is not null (path might not exist or lack permissions)
        if (vw != null) {
            // Read the attributes
            BasicFileAttributes attrs = vw.readAttributes ();
            
            // Check the creation time and set new times if condition is met
            if (attrs.creationTime ().toMillis () < System.currentTimeMillis ()) {
                vw.setTimes (FileTime.fromMillis (System.currentTimeMillis ()), null, null);
            }
        }
        
    }
    
}

class Song {
    public static void organize(Path folder, Path file) throws IOException {
        // Resolve the file path relative to the folder
        Path p = folder.resolve(file);
        
        // Fetch the BasicFileAttributeView
        BasicFileAttributeView vw = Files.getFileAttributeView(p, BasicFileAttributeView.class);
        
        // Ensure that vw is not null (path might not exist or lack permissions)
        if (vw != null) {
            // Read the attributes
            BasicFileAttributes attrs = vw.readAttributes();
            
            // Check the creation time and set new times if condition is met
            if (attrs.creationTime().toMillis() < System.currentTimeMillis()) {
                vw.setTimes(FileTime.fromMillis(System.currentTimeMillis()), null, null);
            }
        }
    }
    
    
    
    public static void main(String[] audio) throws Exception {
       
    
        
    
    }
}