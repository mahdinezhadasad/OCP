package Generics.src.generics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Boottle {
    
    public static class Ship{
        
        private enum Sail{
            TAIL{protected int getHeight(){return 4;}},
            SHORT{protected int getHeight(){return 3;}};
        
            protected abstract int getHeight();
        }
        
        public Sail getSail(){
            return Sail.TAIL;
        }
        
    }
    
    public static void main(String[] args) {
        
        
        TreeMap<String,String> books = new TreeMap<>();
        books.put("978-3-16-148410-0", "The Harry Potter");
        books.put ("978-0-123-45678-9","1984");
        books.put ("978-3-16-14841e0-0","19www84");
        books.put ("978-3-16-14www841e-1","198ee4");
        books.put ("978-3ee-16-14841e-2","198ee4");
        
        System.out.println ("Book sorted by ISBN:");
        
        for(String isbn : books.keySet()){
            
            System.out.println (isbn + "->" + books.get(isbn));
        }
        
        String isbnToFind = "978-3ee-16-14841e-2";
        if(books.containsKey(isbnToFind)){
            System.out.println ("\n Book found: " + isbnToFind);
        }
        else {
            System.out.println ("\n Book not found: " + isbnToFind);
        }
        
        
        // Remove a book by its ISBN
        books.remove("978-1-56619-909-4");
        System.out.println("\nAfter removing 'To Kill a Mockingbird':");
        for (String isbn : books.keySet()) {
            System.out.println(isbn + " -> " + books.get(isbn));
        }
        
        // Check if the TreeMap is empty
        System.out.println("\nIs the TreeMap empty? " + books.isEmpty());
    
    }
}