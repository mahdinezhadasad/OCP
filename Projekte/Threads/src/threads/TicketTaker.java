package Threads.src.threads;

import java.util.function.IntUnaryOperator;

public class TicketTaker {
    
    private static int AT_CAPACITY = 100;
    public int takeTiket(int currentCount, IntUnaryOperator  counter){
        
        return counter.applyAsInt(currentCount);
    }
    
    public static void main(String[] args) {
        final TicketTaker bob = new TicketTaker();
        final int oldCount = 50;
        
        final int newCount = bob.takeTiket(oldCount, x ->{
            
            if(x>AT_CAPACITY){
                
                throw new RuntimeException ("Soor, Max has been reached");
            }
            
            return oldCount +1;
        });
        
        System.out.println (newCount);
    }
}