package Generics.src.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import java.util.function.Predicate;

class Wash<T extends Collection<?>> {
    T items;
    
    public void clean(T items) {
        System.out.println("Cleaned " + items.size() + " items");
    }
}

public class LaundryTime {
    public static void main(String[] args) {
        
        // First consumer to print the value
        DoubleConsumer printConsumer = value -> System.out.println("Original: " + value);
        
        // Second consumer to calculate the square
        DoubleConsumer squareConsumer = value -> System.out.println("Square: " + (value * value));
        
        // Combine the two consumers
        DoubleConsumer combinedConsumer = printConsumer.andThen(squareConsumer);
        
        // Apply the combined consumer
        combinedConsumer.accept(4.5);
    }
}

class Tourist{
    
    public Tourist(double distance){
        this.distance = distance;
    }
    
    public double distance;
}

class lifeguard{
    public void mine(BiFunction<Integer, Integer, Double> lambda) {
    
    }
    private void saveLife(Predicate<Tourist>  canSave, Tourist tourist){
        
        System.out.println (canSave.test(tourist) ? "Saved": "Too far");
    }
    
    public final static void main(String[] args) {
        
        new lifeguard ().saveLife (s-> s.distance<4, new Tourist(3.5));
    }
}

class Asteroid {
    // The method mine accepts a BiFunction with Integer, Double, and Double types
    public void mine(BiFunction<Integer, Double, Integer> lambda) {
        // Example usage of the lambda
        double result = lambda.apply(10, 20.0);
        System.out.println("Result: " + result);
    }
    
    public static void main(String[] args) {
        BiPredicate<Integer,Integer>  isSumGreaterThanThreshold = (a,b) -> a>b;
        
        System.out.println (isSumGreaterThanThreshold.test (5,6));
    }
}