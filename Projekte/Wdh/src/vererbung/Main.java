package Wdh.src.vererbung;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.stream.Stream;

class Employee {
    Optional<Address> address;
    
    Employee(Optional<Address> address) {
        this.address = address;
    }
    
    public Optional<Address> getAddress() {
        return address;
    }
}

class Address {
    String city = "New York";
    
    public String getCity() {
        return city;
    }
    
    public String toString() {
        return city;
    }
}
class Book {
    int id;
    String name;
    
    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }
    

    
  
}
public class Main {
    public static void main(String[] args) {
        try (Stream<Path> files = Files.walk(Paths.get(System.getProperty("user.home")))) { // Stream<Path> files
            files.forEach(fName -> { // Line n1
                try {
                    Path aPath = fName.toAbsolutePath(); // Line n2
                    System.out.println(fName + ": "
                            + Files.readAttributes(aPath, BasicFileAttributes.class).creationTime());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}