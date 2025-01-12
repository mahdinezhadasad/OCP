package IO.src.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface Modern{
    
    default String speak(){
        return "Hello World";
    }
    
    static String doStuff(String gerund){
        return gerund + "in your Sleep";
    }
    
    boolean m1();
}



public class PostModern extends Class3 implements Modern {
    public static void main(String[] args) {
        
        new PostModern ().go ();
    
    }
    void go(){
        
        System.out.println (speak ());
        System.out.println (Modern.doStuff ("Belki de yillar sonra ..."));
        System.out.println (m3 ());
    }
    
    @Override
    public boolean m1() {
        return false;
    }
    
    
    @Override
    String m3() {
        return hadibakalim (m4 ());
    }
}

abstract class Class2 implements Modern{
    
    public boolean m1(){
        return true;
    }
}

abstract class Class3 implements Modern{
    
    abstract String m3();
    static String m4(){
        return  "Hello World from abstract static class";
    }
    
    void m5(){
        System.out.println (m4());
    }
    
    public String hadibakalim(String m){
        
        return "hey do you can what ever you want " +  m;
    }
}

class Car2 {
    static int i1 = 5;
    int i2 = 6;
    public  void m1() { System.out.print(i1); }
}

class Helper {
    public static void help(Tool t) {
        t.work(); // Calls the work() method on the Tool object
        t.name(); // Calls the name() method on the Tool object
        t.work(); // Calls the work() method again on the Tool object
    }
}

class Tool {
    public void work() {
        System.out.print("work ");
    }
    
    public void name() {
        System.out.print("tool ");
    }
}

class Hammer extends Tool {
    @Override
    public void work() {
        System.out.print("bang ");
    }
}
class Bloom {
    String name;
    String month;
    public Bloom(String n, String m) {
        this.name = n; this.month = m;
    }
    public String getName() { return this.name; }
    public String getMonth() { return this.month; }
    public String toString() { return name + ": " + month; }
}
class Apple {}
class Macintosh extends Apple {}
class Mini2 extends Car2 {
    
    public static void main(String[] args) {
        
        List<Weather> weather = new ArrayList<>();
        weather.add(new Weather(2017, 1, 31));
        weather.add(new Weather(2016, 1, 29));
        weather.add(new Weather(2015, 2, 33));
        weather.add(new Weather(2014, 1, 35));
        weather.add(new Weather(2011, 2, 27));
        weather.add(new Weather(2010, 3, 28));
        weather.stream()
                .collect(Collectors.groupingBy(Weather::getMonth))
                .forEach((m, w) -> System.out.println(w));
        
    }
    

    
 
    }

 class Weather {
    int year;
    int month;
    int temp;
    public Weather(int y, int m, int t) {
        this.year = y; this.month = m; this.temp = t;
    }
    public int getYear() { return this.year; }
    public int getMonth() { return this.month; }
    public int getTemp() { return this.temp; }
    public String toString() {
        return year + "/" + month + ": " + temp;
    }
}

 class Two {
    static class Good implements AutoCloseable {
        public void close() throws Exception {
            System.out.println("Good");
        } }
    
    static class Bad implements AutoCloseable {
        public void close() throws Exception {
            System.out.println("Bad");
            throw new Exception("bad exception");
        } }
    
    public static void main(String[] args) throws Exception {
        try (Good good = new Good(); Bad bad = new Bad()) {
            throw new Exception("try exception");
        } } }

class MyException extends Exception { }    // line A

class MyTestClass {
    public static void main(String[] args) {
        try {
            new MyTestClass().go();
        } catch (MyException me) {               // line B
            System.out.println("threw ME");
        }
    }
    void go() throws MyException {            // line C
        int x = 7/0;                            // line D
    }
}

class Gutsy {
    public static void main(String[] args) throws IOException {
        new Gutsy().go();
    }
    void go() throws IOException {
        String row;
        try {
            FileReader fr = new FileReader("TestFile.txt");
            BufferedReader br = new BufferedReader(fr);
            while((row = br.readLine()) != null)
                System.out.println(row);
        } catch (IOException e) {
            System.out.print("got io error ");
        } finally {
            System.out.println("done ");
        }
    }
}

class S {
    static class A implements AutoCloseable {
        public void close() throws Exception {
            throw new Exception ("catch");
        }
    }
    
    private static void method() throws Exception {
        try (A a = new A ()) {
            throw new Exception ("try");
        } finally {
            // throw new Exception("finally");
            System.out.println ("finally");
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get ("D:\\Udacity_Java_Entwikler\\ocp"))) {
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
        Files.walk(Path.of ("D:\\Udacity_Java_Entwikler\\ocp"))
                .filter(Files::isRegularFile)
                .forEach(path -> System.out.println(path.getFileName()));
        
    }
}

 class Weatheer {
    int year;
    int month;
    int temp;
    public Weatheer(int y, int m, int t) {
        this.year = y; this.month = m; this.temp = t;
    }
    public int getYear() { return this.year; }
    public int getMonth() { return this.month; }
    public int getTemp() { return this.temp; }
    public String toString() {
        return year + "/" + month + ": " + temp;
    }
     
     public static void main(String[] args) {
         
         List<Bloom> flowers = new ArrayList<>();
         flowers.add(new Bloom("Apple", "May"));
         flowers.add(new Bloom("Cherry", "April"));
         flowers.add(new Bloom("Dahlia", "June"));
         flowers.add(new Bloom("Poppy", "June"));
         flowers.add(new Bloom("Zinnia", "May"));
         flowers.add(new Bloom("Cosmos", "July"));
         flowers.add(new Bloom("Heather", "July"));
         flowers.add(new Bloom("Allium", "August"));
         
         Map<Boolean, List<Bloom>> springFlowers =
                 flowers.stream()
                         .collect(Collectors.groupingBy(
                                 f -> f.getMonth().equals("May") ||
                                         f.getMonth().equals("June")));
         
         springFlowers.forEach((b, f) -> { if (b) { System.out.print(f + " "); }});
     }
}
class Alphabet extends Thread {
    public synchronized void run() {
        try {
            System.out.println("A");
            wait(1);
            System.out.println("B");
            notify();
            System.out.println("C");
            wait(1);
            System.out.println("D");
            notifyAll();
            System.out.println("E");
        } catch (Exception e) {
            System.out.println("F");
        } finally {
            System.out.println("G");
        }
    }
    public static void main(String[] args) {
        new Alphabet().start();
    }
}