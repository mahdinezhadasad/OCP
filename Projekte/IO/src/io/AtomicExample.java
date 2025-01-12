package IO.src.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    
    private static AtomicInteger atomicValue = new AtomicInteger(5);
    
    public static void main(String[] args) {
        
        List<Integer> original = new ArrayList<> (Arrays.asList(1, 2, 3, 4, 5));
        
        
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        for (Integer value : list) {
            list.remove(value);  // Throws ConcurrentModificationException
        }
        
        
    }
}

class CartoonCat {
    private void await(CyclicBarrier c) {
        try {
            c.await();
        } catch (Exception e) {}
    }
    
    public void march(CyclicBarrier c) {
        ExecutorService s = Executors.newSingleThreadExecutor ();
        for (int i = 0; i < 12; i++) {
            s.execute(() -> await(c));
        }
        s.shutdown();
    }
    
    public static void main(String... strings) {
        // CyclicBarrier for 4 runners, with an action to print a message when all runners finish
        CyclicBarrier barrier = new CyclicBarrier(4, () -> System.out.println("All runners finished their part of the race!"));
        
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        for (int i = 1; i <= 4; i++) {
            final int runner = i;
            executor.execute(() -> {
                try {
                    System.out.println("Runner " + runner + " is running...");
                    Thread.sleep(2000); // Simulate time taken to run
                    System.out.println("Runner " + runner + " reached the barrier.");
                    barrier.await(); // Wait for all runners to reach the barrier
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        
        executor.shutdown();
    }
}

class Race {
    private static final ExecutorService service = Executors.newFixedThreadPool (8);
    
    // Simulates a task that takes 1 second to complete
    public static int sleep() {
        try {
            Thread.sleep (1000);
        } catch (InterruptedException e) {
            Thread.currentThread ().interrupt ();
        }
        return 1;
    }
    
    // Simulates the hare's behavior in the race using invokeAll()
    public static void hare() {
        try {
            Callable<Integer> task = Race::sleep; // A callable task that sleeps
            List<Callable<Integer>> tasks = Arrays.asList (task, task, task);
            
            // invokeAll waits for all tasks to complete
            List<Future<Integer>> results = service.invokeAll (tasks);
            System.out.println ("Hare won the race!");
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
    
    // Simulates the tortoise's behavior in the race using invokeAny()
    public static void tortoise() {
        try {
            Callable<Integer> task = Race::sleep; // A callable task that sleeps
            List<Callable<Integer>> tasks = Arrays.asList (task, task, task);
            
            // invokeAny returns the result of the first completed task
            Integer result = service.invokeAny (tasks);
            System.out.println ("Tortoise won the race!");
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
    
    public static void main(String[] args) {
        // Submit hare and tortoise tasks and get Future objects
        Future<?> hareFuture = service.submit(Race::hare);
        Future<?> tortoiseFuture = service.submit(Race::tortoise);
        
        try {
            // Wait for both tasks to complete
            hareFuture.get();
            tortoiseFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor service
            service.shutdown();
        }
    }
}

class Athlete {
    private int stroke = 0;
    
    // Synchronized method to ensure thread-safe increment
    public synchronized void swimming() {
        stroke++;
    }
    
    public static void main(String[] laps) {
        ExecutorService s = Executors.newFixedThreadPool(11);
        Athlete a = new Athlete();
        
        // Submit 1000 tasks to increment stroke
        for (int i = 0; i < 11; i++) {
            s.execute(() -> a.swimming());
        }
        
        // Shutdown the executor service
        s.shutdown();
        
        // Print the stroke value without waiting for task completion
        System.out.print(a.stroke);
    }
}