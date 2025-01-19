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
        
    }
}