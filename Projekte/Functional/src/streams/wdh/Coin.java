package Functional.src.streams.wdh;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ImageScnanner implements AutoCloseable{
    
    
    @Override
    public void close() throws Exception {
        
        System.out.println ("Scanner Closed.");
    }
    public void scanImage() throws Exception{
        
        System.out.println ("Scan..");
        throw new Exception ("Unable to scan.");
    }
}

class ImagePrinter implements AutoCloseable {
    
    @Override
    public void close() throws Exception {
        
       System.out.println ("Printer Closed.");
        
    }
    
    public void printImage(){
        
        System.out.println ("Print.");
    }
}

public class Coin {
    
    public static void main(String[] args) {
        try (Stream<Path> files = Files.walk(Paths.get(System.getProperty("user.home"))))
        { files.forEach(fName -> { try { Path aPath = fName.toAbsolutePath();
            System.out.println(fName + ": " +
                    Files.readAttributes(aPath, BasicFileAttributes.class).creationTime()); }
        catch (
                IOException ex) { ex.printStackTrace(); } }); } catch
        (IOException e) { e.printStackTrace(); }
    }
}

class Vehicle  {
    int vno;
    String name;
    
    public Vehicle(int vno, String name) {
        this.vno = vno;
        this.name = name;
    }
    
/*    @Override
    public int compareTo(Vehicle other) {
        return Integer.compare(this.vno, other.vno);
   } */
   
  /*  @Override
    public String toString() {
        return vno + ":" + name;
    }*/
}

 class Malin {
    public static void main(String[] args) {
        Set<Vehicle> vehicles = new TreeSet<>();
        vehicles.add(new Vehicle(10123, "Ford"));
        vehicles.add(new Vehicle(10124, "BMW"));
        System.out.println(vehicles);
    }
}