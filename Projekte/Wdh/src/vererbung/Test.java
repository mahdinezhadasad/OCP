package Wdh.src.vererbung;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class Test<T> {
    private T t;
    
    public T get() {
        return t;
    }
    
    public void set(T t) {
        this.t = t;
    }
    
    public static void main(String args[]) {
        List<Integer> nums = Arrays.asList(10, 20, 8);
        
        System.out.println(
                // Uncomment ONE of the following options at a time:
                
                // Option A: Correct way to find max using Comparator
                // nums.stream().max(Comparator.comparing(a -> a)).get()
                
                // Option B: Incorrect usage of max() method
                // nums.stream().max(Integer::max).get()
                
                // Option C: Incorrect because max() requires a comparator
                // nums.stream().max()
                
                // Option D: Incorrect because map() does not find max; it transforms data
                // nums.stream().map(a -> a).max()
                
              

        );
   /*     List<String> list = Arrays.asList("Java", "is", "a", "programming", "language");
        String reference = "Java is a programming language";
        list.stream()
                .mapToInt(reference::indexOf) // Use method reference here
                .forEach(System.out::println);*/
      /*  List<String> codes = Arrays.asList ("DOC", "MPEG", "JPEG"); codes.forEach (c -> System.out.print(c + " ")); String fmt = codes.stream()
                .filter (s-> s.contains ("PEG"))
                .reduce((s, t) -> s + t).get(); System.out.println("\n" + fmt);*/
        
        List<String> nL = Arrays.asList("Jim", "John", "Jeff");
        
        // Function to add "Hello :" prefix to each element
        Function<String, String> funVal = s -> "Hello : ".concat(s);
        
        // Stream processing
        nL.stream()
                .map(funVal)
                .peek(System.out::print)
                .forEach(s -> {});       // Peek to print each transformed element
        
    }
}