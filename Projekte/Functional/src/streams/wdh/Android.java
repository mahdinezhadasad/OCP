package Functional.src.streams.wdh;

import javax.swing.text.html.Option;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toMap;

public class Android {
    // Corrected method signature: Supplier with generic type
    public void wakeUp(Supplier<String> supplier) { // d1
       supplier.get();
    }
    
    private static void longer(Optional<Boolean> optional) {
        
        if(optional.isPresent ()){
            
            System.out.println ("run: " + optional.get());
        }
    }
    
    private static void shorter(Optional<Boolean> optional) {
        
        optional.map (x -> " run: " + x).ifPresent (System.out::println);
    }
 
    
    public static void main(String... electricSheep) {
        Stream<Character>  stream = Stream.of ('c','b','a','t');
        System.out.println (stream.sorted ().findAny ().get ());
       
    }
}

class Ballot{
    
    private String name;
    private int judgeNumber;
    private int score;
    
    public Ballot(String name, int judgeNumber, int score) {
        this.name = name;
        this.judgeNumber = judgeNumber;
        this.score = score;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getJudgeNumber() {
        return judgeNumber;
    }
    
    public void setJudgeNumber(int judgeNumber) {
        this.judgeNumber = judgeNumber;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
}

class searchinginStream{
    
    public static void main(String[] args) {
      /*
        Set<String> set = new HashSet<> ();
        set.add("tire-");
        
        List<String> list = new LinkedList<> ();
        
        Deque<String> queue = new ArrayDeque<> ();
        queue.push("wheel-");
        
        Stream.of(set, list, queue)
                // Convert each collection into a stream
                .flatMap(collection -> collection.stream())
                // or .flatMap(Collection::stream)
                .forEach(System.out::print);
        */
        
        List<String> words = Arrays.asList("a", "bb", "", "ccc", "dddd", "bb", "");
        
        // I. Map<Integer, List<String>> using groupingBy
        Map<Integer, List<String>> map1 = words.stream()
                .collect(Collectors.groupingBy(String::length));
        // Example output might look like: {0=["",""], 1=["a"], 2=["bb","bb"], 3=["ccc"], 4=["dddd"]}
        System.out.println("Map<Integer, List<String>> = " + map1);
        
        // II. Map<Boolean, HashSet<String>> using groupingBy + toCollection
        // Here, we group by whether the string is empty; collecting each group into a HashSet
        Map<Boolean, HashSet<String>> map2 = words.stream()
                .collect(Collectors.groupingBy(
                        s -> s.isEmpty(),
                        Collectors.toCollection(HashSet::new) // So each group is a HashSet<String>
                ));
        // Example output might look like: {false=[a, bb, ccc, dddd], true=[]}
        System.out.println("Map<Boolean, HashSet<String>> = " + map2);
        
        // III. List<String> is NOT from groupingBy -- you use toList() instead.
        List<String> list = words.stream().collect(Collectors.toList());
        // Example output might be: [a, bb, , ccc, dddd, bb, ]
        System.out.println("List<String> = " + list);
        
    }
}

class FlatMapDemo {
    public static void main(String[] args) {
        // Example 1: an empty List
        List<String> list = new LinkedList<>();
        System.out.println("Calling withFlatMap(list):");
        withFlatMap(list);
        System.out.println("Calling withoutFlatMap(list):");
        withoutFlatMap(list);
        
        // Example 2: a non-empty Deque
        Deque<String> queue = new ArrayDeque<>();
        queue.push("allqueuedup");
        queue.push("last");
        // So 'last' is at the front
        
        System.out.println("\nCalling withFlatMap(queue):");
        withFlatMap(queue);
        System.out.println("Calling withoutFlatMap(queue):");
        withoutFlatMap(queue);
    }
    
    // Uses flatMap() to flatten each collection into its contents
    private static void withFlatMap(Collection<?> coll) {
        Stream.of(coll)
                // x is a Collection<?>, so x.stream() is a Stream of the inner elements
                .flatMap(c -> c.stream())
                .forEach(System.out::print);
        System.out.println();
    }
    
    // Tries to replicate the logic but uses filter/map instead of flatMap
    private static void withoutFlatMap(Collection<?> coll) {
        Stream.of(coll)
                // If coll is empty, we skip it
                .filter(c -> !c.isEmpty())
                // But after filter, we're still streaming the entire Collection as one item
                //.map(c -> c)  // This line effectively does nothing: the item is still one Collection
                .forEach(System.out::print);
        System.out.println();
    }
}