package Wdh.src.vererbung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Foo {
    String color;
    int size;
    
    Foo(int size, String color) {
        this.size = size;
        this.color = color;
    }
    
    @Override
    public String toString() {
        return "Block{" + "size=" + size + ", color='" + color + '\'' + '}';
    }
    
    public static void main(String[] args) {
        Stream.of("Java", "Unix", "Linux")
                .filter(s -> s.contains("n"))
                .peek(s -> System.out.println("PEEK: " + s))
                // Insert one of the following methods at line n1
               .findAny(); // Option C
       //  .findFirst(); // Option E
             //   .anyMatch ();
    }
    
}

class ColorSortere implements Comparable<Foo> {
    public int compare(Foo o1, Foo o2) {
        return o1.color.compareTo(o2.color);
    }
    
    @Override
    public int compareTo(Foo o) {
        return 0;
    }
}

class ColorSorter implements Comparator<Foo> {
    public int compare(Foo o1, Foo o2) {
        return o1.color.compareTo(o2.color);
    }
}