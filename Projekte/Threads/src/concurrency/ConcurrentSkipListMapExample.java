package Threads.src.concurrency;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapExample {
    
    public static void main(String[] args) throws InterruptedException {
        
        ConcurrentSkipListMap<Integer,String>  map = new ConcurrentSkipListMap<>();
        
        Runnable writer = () -> {
            for (int i = 1; i <= 5; i++) {
                map.put(i, "Value-" + i);
                System.out.println("Added: " + i);
                try {
                    Thread.sleep(100); // Simuliert Verzögerung
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        
        // Thread für Leseoperationen
        Runnable reader = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Reading: " + map);
                try {
                    Thread.sleep(150); // Verzögertes Lesen
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        
        Thread writerThread = new Thread(writer);
        Thread readerThread = new Thread(reader);
        
        writerThread.start();
        readerThread.start();
        
        writerThread.join ();
        readerThread.join ();
        
        System.out.println ("Final map: " + map);
        
        
        
        
    }
}