package Threads.src.threads;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.LongSupplier;
import java.util.function.ObjDoubleConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toMap;

public class Product {
    
    String name;
    double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    void applyDiscount(double discount){
        
        this.price -= this.price*discount/100;
    }
    
    @Override
    public String toString() {
        
        return name + "-Price: §" +price;
    }
    
    private static void longer(Optional<Boolean>  opt){
        
        if(opt.isPresent()){
            
            System.out.println ("Run: "+opt.get());
        }
    }
    private static void shorter(Optional<Boolean> opt){
        
        opt.map(x -> " Run : " +x).ifPresent (System.out::println);
    }
    
    
    public static void main(String[] args) {
        
        Map<Integer,Integer>  map = new HashMap<> ();
        map.put(9,3);
        map.put(5,2);
        map.put(4,1);
        map.put(3,8);
        
        
       Map<Integer,List<Integer>>  result = map.entrySet ()
               .stream ()
               .collect(Collectors.groupingBy (
                       Map.Entry::getValue,
                       Collectors.mapping(Map.Entry::getKey, Collectors.toList())
               ));
        
        System.out.println (result);
        
        Stream<String>  s = Stream.of("speak","bark","meow","growl");
        BinaryOperator<String>  merge = (a,b)->b+a;
        
        Map<Integer,String>  mapp = s.collect (toMap(String::length,k->k,merge));
        System.out.println (mapp.size () + " " + mapp.get (5));
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        
        Map<String,Long> countMap = words.stream().collect(Collectors.toMap (word ->word,word ->1L,Long::sum));
        
        
        System.out.println (countMap);
        
        IntStream pages = IntStream.of(200,300);
        IntSummaryStatistics stats = pages.summaryStatistics ();
        long total = stats.getSum();
        long count = stats.getCount();
        System.out.println (total + "-"+ count);
        
        Stream<Boolean>  bools = Stream.iterate (true, b ->!b);
        Map<Boolean,List<Boolean>>  maep = bools.limit (4)
                .collect (partitioningBy (b ->b));
        
        System.out.println (maep);
        
        Stream<Integer> ssss = Stream.of (1,2,3);
        System.out.println (ssss.min (Comparator.naturalOrder ()).get ());
        
        Set<String> set = new HashSet<> ();
        set.add ("tire_");
        List<String> list = new LinkedList<> ();
        Deque<String> queue = new ArrayDeque<> ();
        queue.push ("wheel_");
        
        Stream.of (set,list,queue).flatMap (x -> x.stream ())
                .forEach (System.out::println);
        
    }
    
    private static void spot(Optional<String> x){
        
        x.filter (y -> !y.isEmpty())
                .map (y->8)
                .ifPresent (System.out::println);
    }
}