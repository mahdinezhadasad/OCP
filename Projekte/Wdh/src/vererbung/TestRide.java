package Wdh.src.vererbung;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Predicate;

// Custom exception class
class FuelNotAvailException extends Exception {
}

// Parent class
class Vehicle {
    // Method in parent class
    void ride() throws Exception { // line n1
        System.out.println("Happy Journey!");
    }
}

// Child class extending Vehicle


// Main class
public class TestRide {
    public static void main(String[] args) throws FuelNotAvailException, Exception {
        //    Vehicle v = new SolarVehicle();
        //   v.ride();
        
        List<Integer> list1 = Arrays.asList (10, 20);
        List<Integer> list2 = Arrays.asList (15, 30);
        
        // Uncomment the options below one at a time to test each case:
        
        // Option A: Correct option
        // Stream.of(list1, list2)
        //       .flatMap(list -> list.stream())
        //       .forEach(s -> System.out.print(s + " "));
        
        // Option B: Incorrect due to intStream()
        // Stream.of(list1, list2)
        //       .flatMap(list -> list.intStream()) // `intStream()` doesn't exist for List<Integer>
        //       .forEach(s -> System.out.print(s + " "));
        
        // Option C: Incorrect, improper chaining of streams
        // list1.stream()
        //       .flatMap(list2.stream().flatMap(e1 -> e1.stream())) // `e1.stream()` is invalid
        //       .forEach(s -> System.out.print(s + " "));
        
        // Option D: Incorrect due to flatMapToInt usage
        // Stream.of(list1, list2)
        //     .flatMapToInt(list -> list ())) // `flatMapToInt` expects an IntStream
        //  .forEach(s -> System.out.print(s + " "));
        
        
        List<String> colors = Arrays.asList ("red", "green", "yellow");
        
        Predicate<String> test = n -> {
            System.out.println ("Searching...");
            return n.contains ("red");
        };
        
        // Example usage of the predicate:
        // colors.stream()
        //       .filter(test)
        
        Locale currentLocale = new Locale.Builder ()
                //.setRegion ("FR")
                .setLanguage ("fr")
                .build ();
        
        ResourceBundle messages = ResourceBundle.getBundle ("MessagesBundle", currentLocale);
        Enumeration<String> names = messages.getKeys ();
        
        while (names.hasMoreElements ()) {
            String key = names.nextElement ();
            String name = messages.getString (key);
            System.out.println (key + " = " + name);
        }
        
    }}