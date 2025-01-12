package IO.src.io;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {
    Predicate<Integer> isEven;
    // Assigning a lambda to check the length of a string
    Predicate<String> isLengthGreaterThan5;
    public Main() {
        // Assigning a lambda to check the length of a string
        isLengthGreaterThan5 = s -> s.length() > 5;
    }
    
    
    
    public static void main(String[] args) {
        
        List<Double> ppms = new ArrayList<>();
        ppms.add(406.0); ppms.add(407.2); ppms.add(408.1);
        ppms.add(406.5); ppms.add(407.8); ppms.add(407.5);
        Stream<Double> ds = ppms.stream();
        Predicate<Double> p1 = d -> d > 407.0;
        Predicate<Double> p2 = d -> d <= 407.0;
        System.out.print(ds.filter(p1).count());
        System.out.print(ds.filter(p2).count());
        
        
    }
}

class Readinng {
    int year;
    double extent;
    public Readinng(int y, double e) { this.year = y; this.extent = e; }
    public int getYear() { return this.year; }
    public double getExtent() { return this.extent; }
    public String toString() { return extent + " in " + year; }
}