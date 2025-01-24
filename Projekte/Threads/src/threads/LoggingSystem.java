package Threads.src.threads;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.BiFunction;
import java.util.logging.Logger;

public class LoggingSystem {
    
    private static LinkedBlockingQueue<String>  logQueue = new LinkedBlockingQueue<> (10);
    private static volatile boolean isRunning = true;
    
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Erstellen von Callable-Aufgaben
        List<Callable<String>> tasks = Arrays.asList(
                () -> {
                    Thread.sleep(2000);
                    return "Task 1 abgeschlossen";
                },
                () -> {
                    Thread.sleep(1000);
                    return "Task 2 abgeschlossen";
                },
                () -> {
                    Thread.sleep(3000);
                    return "Task 3 abgeschlossen";
                }
        );
        
        // Die schnellste Aufgabe ausführen
        System.out.println("invokeAny startet...");
        String result = executor.invokeAny (tasks); // Gibt das Ergebnis der ersten Aufgabe zurück
        System.out.println("Starte alle Aufgaben mit invokeAll...");
        List<Future<String>> results = executor.invokeAll(tasks);
        
        // Ergebnisse verarbeiten
        for (Future<String> future : results) {
            System.out.println(future.get()); // Wartet auf die Fertigstellung jeder Aufgabe
        }
        System.out.println("Ergebnis: " + result);
        
        executor.shutdown();
      
    }
    
}