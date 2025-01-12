package IO.src.io;
import java.util.*;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CountSheep  {
    
    
        
    
    
    public String concat1(List<String> values) {
        return values.parallelStream()
                .reduce("a", (x, y) -> x + y);
    }
    
    public String concat2(List<String> values) {
        return values.parallelStream()
                .reduce((w, z) -> z + w)
                .get();
    }
    
    
    public static void main(String[] night) {
        
        
        CountSheep  c = new CountSheep ();
        List<String> list = Arrays.asList("Cat", "Hat");
        String x = c.concat1(list); // Result: "aCatHat"
        String y = c.concat2(list); // Result: "HatCat"
        System.out.print(x + " " + y); // Final Output: "aCatHat HatCat"
    }
}
 class Accountant {
    public static void completePaperwork() {
        System.out.print("[Filing]");
    }
    public static double getPi() {
        return 3.14159;
    }
     
     private void waitTillFinished(CyclicBarrier c) {
         try {
             c.await();
             System.out.print("1");
         } catch (Exception e) {}
     }
     public void row(ExecutorService service) {
         final CyclicBarrier cb = new CyclicBarrier(5);
         IntStream.iterate (1,i->i+1)
                 .limit(12)
                 .forEach(i->service.submit (()->waitTillFinished (cb)));
     }
     
     static BlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
    public static void main(String[] args) throws Exception {
        
        // Synchronized list for thread-safe access
        List<Integer> db = Collections.synchronizedList(new ArrayList<>());
        
        // Parallel stream processing with side effects
        IntStream.iterate(1, i -> i + 1).limit(5)
                .parallel()
                .map(i -> {
                    db.add(i); // Adding elements to the synchronized list
                    return i;
                })
                .forEachOrdered(System.out::println);  // p1: Prints 1 2 3 4 5
        
        System.out.println();
        
        // Iterating over the list to print its elements
        db.forEach(System.out::print);  // p2: Non-deterministic order
    }
}