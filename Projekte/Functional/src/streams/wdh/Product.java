package Functional.src.streams.wdh;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Product{

  int id; int price;
  
  public Product(int id, int price){
      
      this.id = id; this.price = price;
  }
  
  public String toString(){
      
      return id + " " + price;
  }
    
    public static void main(String[] args) {
        
        // Create the IntStream
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);
        
        // Define IntFunction to create an IntUnaryOperator
        IntFunction<IntUnaryOperator> inFu = x -> y -> x * y;
        
        // Create an IntUnaryOperator by applying the function
        IntUnaryOperator multiplier = inFu.apply(10);
        
        // Use applyAsInt explicitly in the map operation
        IntStream newStream = stream.map(value -> multiplier.applyAsInt(value));
        
        // Print the results
        newStream.forEach(System.out::println);
    }
      
    }

class Student {
    String course, name, city;
    
    // Constructor
    public Student(String name, String course, String city) {
        this.course = course;
        this.name = name;
        this.city = city;
    }
    
    // toString method to format the output
    public String toString() {
        return course + ":" + name + ":" + city;
    }
    
    // Getter for course
    public String getCourse() {
        return course;
    }
    
    // Getter for name
    public String getName() {
        return name;
    }
    
    // Getter for city
    public String getCity() {
        return city;
    }
}