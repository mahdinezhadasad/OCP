package Functional.src.func;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Productz {
    String name;
    Integer price;
    
    Productz(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
    
    public void printVal() {
        System.out.print(name + " Price:" + price + " ");
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public Integer getPrice() {
        return price;
    }
}

class MyClass implements AutoCloseable {
    int test;
    
    @Override
    public void close() {
        // No special cleanup needed
    }
    
    public MyClass copyObject() {
        return this;
    }
}


class Vehicle {
    int vid;
    String vName;
    
    public Vehicle(int vIdArg, String vNameArg) {
        this.vid = vIdArg;
        this.vName = vNameArg;
    }
    
    public int getVId() {
        return vid;
    }
    
    public String getVName() {
        return vName;
    }
    
    @Override
    public String toString() {
        return vName; // Corrected toString() method
    }
}

 class Foo<K, V> {
    private K key;
    private V value;
    
    public Foo(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public static <T> Foo<T, T> twice(T value) {
        return new Foo<T, T>(value, value);
    }
    
    public K getKey() {
        return key;
    }
    
    public V getValue() {
        return value;
    }
}

class Person implements Comparator{
    String name;
    Person(String name) {
        this.name = name;
        
    }
    

    
    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o1;         // cast o1 to Person
        Person p2 = (Person) o2;         // cast o2 to Person
        return p1.name.compareTo(p2.name);
    }
}

class Test{
    
  static   List<String> list = null;
    public static  void printValues(){
        System.out.println (getList());
    }
    
    public static List<String> getList(){
        return list;
    }
    
    public void setList(List<String> newlist){
        list = newlist;
    }
}

public class Singelton {
    
    final List<String> list = new CopyOnWriteArrayList<>();
    final AtomicInteger ai = new AtomicInteger(0);
    final CyclicBarrier barrier = new CyclicBarrier(2, () -> {
        System.out.println(list);
    });
    
    // Provide a public getter method to supply the Runnable
    public Runnable getRunnable() {
        return () -> {
            try {
                Thread.sleep(1000 * ai.incrementAndGet());
                list.add("X");
                barrier.await();
            } catch (Exception x) {
                System.out.println("Exception thrown: " + x);
            }
        };
    }
         
         
    
    
    public static void main(String[] args) throws IOException {
        
        IntConsumer consumer = e -> System.out.println (e);
        
        Integer value = 90;
        ToIntFunction<Integer> toInt = i -> i +10;  Integer result = toInt.applyAsInt (value);
        consumer.accept (value);
        
    }
    
    };