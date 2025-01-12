package Functional.src.streams.wdh;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    private List<String> list = null;
    
    // Method to print values
    public void printValues() {
        System.out.print(getList());
    }
    
    // Getter method for list
    public List<String> getList() {
        return list;
    }
    
    // Setter method for list
    public void setList(List<String> newList) {
        list = newList;
    }
    
    public static void main(String[] args) {
        // Initialize a list of strings
        List<String> li = Arrays.asList("Dog", "Cat", "Mouse");
        
        // Create an instance of Test
        Test t = new Test();
        
        // Set the list using a stream and collect the result into a list
        t.setList(li.stream().collect(Collectors.toList()));
        
        // Print each element using the getList method and a method reference
        t.getList().forEach(System.out::println);
    }
}