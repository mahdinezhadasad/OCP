package Generics.src.generics;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    
    public static void main(String[] args) {
        
        final int THREAD_COUNT = 3;
        
        CyclicBarrier barrier = new CyclicBarrier (THREAD_COUNT,() ->{
            
            
            System.out.println ("All threads reached the barrier, now continuing ...");
        });
        
        for(int i = 0; i<THREAD_COUNT; i++){
            
            new Thread (() -> {
                
                System.out.println (Thread.currentThread ().getName () + " doing some workd ...");
                
                try { Thread.sleep((long)(Math.random() * 1000)); } catch (InterruptedException e) {}
                
                System.out.println(Thread.currentThread().getName() + " waiting at barrier...");
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                // Once the barrier is released, all threads continue in parallel
                System.out.println(Thread.currentThread().getName() + " continues after barrier!");
            }, "Worker-" + (i+1)).start();
        }
        
        }
    }