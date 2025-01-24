package Threads.src.threads;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Boat {
    
    private void waitTillFinished(CyclicBarrier c){
        
        try{
            
            c.wait ();
            System.out.println ("1");
        }catch (Exception e){
        
        }
    }
    public void row(ExecutorService service){
        
        final CyclicBarrier barrier = new CyclicBarrier(5);
        IntStream.iterate (1, i->i+1).limit (12)
                .forEach (i -> service.execute (()-> waitTillFinished (barrier)));
    }
    
    public static void main(String[] args) {
        
        ExecutorService service = null;
        try{
            
            service = Executors.newCachedThreadPool ();
            new Boat().row (service);
        }finally {
            service.shutdown ();
        }
    }
}