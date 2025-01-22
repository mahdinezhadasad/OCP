package Threads.src.threads;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CartoonCat {
    
    private void awwait(CyclicBarrier c) {
        
        try{
            c.await ();
        }catch (Exception e) {
            
            e.printStackTrace ();
        }
    }
    
    public void march(CyclicBarrier c) {
        
        ExecutorService s = Executors.newFixedThreadPool (4);
        for(int i = 0; i < 11; i++) {
            
            s.execute (() -> awwait (c));
        }
        
        s.shutdown ();
        
        try{
            
            s.awaitTermination (12, TimeUnit.SECONDS);
        }catch (InterruptedException e) {
            
            e.printStackTrace ();
        }
    }
    
    public static void main(String[] args) {
        new CartoonCat ().march (new CyclicBarrier (4,() -> System.out.println ("Read and Write it again")));
    }
}