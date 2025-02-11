package Threads.src.concurrency;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


public class ConcurrentLinkedQueueExample {
    
    public static void main(String[] args) {
        BlockingDeque<Integer> queue = new LinkedBlockingDeque<> (3);
        
        // Parallele Threads fügen Elemente hinzu
        IntStream.range(1, 6).parallel().forEach(i -> safeOfferLast(queue, i));
        
        // Parallele Threads entfernen Elemente
        IntStream.range(1, 6).parallel().forEach(i -> safePollFirst(queue));
    }
    
    private static void safeOfferLast(BlockingDeque<Integer> queue, int value) {
        try {
            queue.offerLast(value, 2, TimeUnit.SECONDS);
            System.out.println("Offered: " + value);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted while offering: " + value);
        }
    }
    
    private static void safePollFirst(BlockingDeque<Integer> queue) {
        try {
            Integer value = queue.pollFirst(2, TimeUnit.SECONDS);
            if (value != null) {
                System.out.println("Polled: " + value);
            } else {
                System.out.println("Queue was empty");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted while polling");
        }
    }
}