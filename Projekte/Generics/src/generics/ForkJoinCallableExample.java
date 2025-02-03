package Generics.src.generics;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinCallableExample {
    public static void main(String[] args) {
        // Create a ForkJoinPool with the default number of threads
        ForkJoinPool pool = new ForkJoinPool();
        
        // Submit a Callable to the pool
        Future<Integer> future = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // Simulate some computation
                System.out.println("Running in the ForkJoinPool!");
                Thread.sleep(500);
                return 42;
            }
        });
        
        // Now you can retrieve the result
        try {
            Integer result = future.get();
            System.out.println("Callable result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always shut down the pool when done
            pool.shutdown();
        }
    }
}