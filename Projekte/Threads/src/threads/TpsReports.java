package Threads.src.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TpsReports {
    public void submitReports() {
        ExecutorService service = Executors.newCachedThreadPool ();
        Future<?> bosses = service.submit (() -> {
            System.out.println ("eee");
        });
        try {
            
            System.out.println (bosses.get ());
        } catch (InterruptedException | ExecutionException e) {
            
            e.printStackTrace ();
        }
        
        service.shutdown ();
    }
    
    public static void main(String[] args) {
        new TpsReports().submitReports ();
    }
}