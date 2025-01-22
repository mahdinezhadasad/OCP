package Threads.src.threads;

import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample {
    
    public static void main(String[] args) {
        
        LinkedBlockingQueue<Integer>  queue = new LinkedBlockingQueue<> ();
        Thread producer = new Thread( () -> {
            
            try{
                
                for(int i = 0 ; i < 10 ; i++){
                    
                    System.out.println ("Producing " + i);
                    queue.put (i);
                }
                
            }catch (InterruptedException e){
                
                Thread.currentThread().interrupt();
            }
            
            
        });
        
        Thread consumer = new Thread( () -> {
            
            try{
                
                while(true){
                    
                    Integer  item = queue.take ();
                    System.out.println ("Consuming " + item);
                }
            }catch (InterruptedException e){
                Thread.currentThread ().interrupt ();
            }
            
        });
        
        producer.start ();
        consumer.start ();
    }
}