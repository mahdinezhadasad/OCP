package Functional.src.func;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Emp{
    
    private String eName;
    private Integer eAge;
    
    Emp(String eName, Integer eAge){
        this.eName = eName;
        this.eAge = eAge;
    }
    
    public Integer getEAge(){
        return eAge;
    }
    public String geteName(){return eName;}
}
class CallerThread implements Callable<String>{
    
    String str;
    public CallerThread(String str){
        this.str = str;
    }
    
    
    public String call() throws Exception {
        return str.concat ("Call");
    }
}
 class FileThread implements Runnable {
    String fName;
    public FileThread(String fName) {
        this.fName = fName;
    }
    public void run() {
        System.out.println(fName);
    }
}

class CheckClass{
    public static int checkValue(String s1, String s2) {
        return s1.length () - s2.length();
    }
}
class Product {
    String name;
    int qty;
    
    public Product(String name, int qty) {
        this.name = name;
        this.qty = qty;
    }
    
    public String toString() {
        return name;
    }
    
    // Static nested class
    static class ProductFilter {
        public static boolean isAvailable(Product p) { // line n1
            return p.qty >= 10;
        }
    }
}
public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        
        
        Supplier<List<String>>  listSupplier = ArrayList::new;
        List<String> list = listSupplier.get();
        
        list.add ("Value1");
        list.add ("Value2");
        list.add ("Value3");
        
        list.forEach (System.out::println);
        
        List<int[]>  listOfIntArrays = Arrays.asList (
                
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        );
        
        IntStream intStream = listOfIntArrays.stream ()
                .flatMapToInt (Arrays::stream);
        
        intStream.forEach (System.out::println);
        
        List<List<Integer>>  listoflists = Arrays.asList(
                
                Arrays.asList (1,2,3),
                Arrays.asList (4,5,6),
                Arrays.asList (7,8,9)
        );
        
        IntStream  intStream1 = listoflists.stream().flatMapToInt (liest -> liest.stream().mapToInt (Integer::intValue));
        intStream1.forEach (System.out::println);
        
       
        
        List<String> colors = Arrays.asList("red", "green", "yellow");
        Predicate<String> test = n -> {
            System.out.println("Searching...");
            return n.contains("red");
        };
        colors.stream()
                .filter(c -> c.length() > 3)
                .anyMatch (test);
        
        
        Path path1 = Paths.get("/software/././sys/readme.txt");
        Path path2 = path1.normalize();
        Path path3 = path2.relativize(path1);
        System.out.print(path1.getNameCount());
        System.out.print(" : " + path2.getNameCount());
        System.out.print(" : " + path3.getNameCount());
        
        List<Product> products = Arrays.asList(
                new Product("MotherBoard", 5),
                new Product("Speaker", 20)
        );
        
        products.stream()
                .filter(Product.ProductFilter::isAvailable) // line n2
                .forEach(p -> System.out.println(p));
    }
        
    }