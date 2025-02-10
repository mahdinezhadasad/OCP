package Generics.src.generics;

import java.util.SortedMap;
import java.util.TreeMap;

public class SuppressedExceptionTest {
    static class Good implements AutoCloseable {
        public void close() throws Exception {
            System.out.println("Good");
            throw new Exception("Good Exception");
        }
    }
    
    static class Bad implements AutoCloseable {
        public void close() throws Exception {
            System.out.println("Bad");
           throw new Exception("bad exception");
        }
    }
    
    public static void main(String[] args) {
        try (Good good = new Good(); Bad bad = new Bad()) {
            throw new Exception("try exception"); // Main exception
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
            
            // Print suppressed exceptions
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed Exception: " + suppressed);
            }
        }
        TreeMap<String, String> myMap = new TreeMap<>();
        myMap.put("a", "apple");
        myMap.put("d", "date");
        myMap.put("f", "fig");
        myMap.put("p", "pear");
        
        // Erstelle eine Teilansicht der Map ab "f"
        SortedMap<String, String> subMap = myMap.tailMap("f");
        
        // Hole den ersten Schlüssel aus dieser Teil-Map
        System.out.println("First key in tailMap: " + subMap.firstKey());
        
        
    }
}