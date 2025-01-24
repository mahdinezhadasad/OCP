package Threads.src.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

public class CountSheep extends RecursiveAction {
    
    static int[] sheep = new int[] {1,2,3,4};
    final int start;
    final int end;
    static int count;
    
    
    public CountSheep(int start, int end) {
        
        this.start = start;
        this.end = end;
    }
    
    @Override
    public  void compute() {
        if (end - start < 2) {
            count+=sheep[start];
            return;
        } else {
            int middle = start + (end - start) / 2;
            invokeAll(new CountSheep(start, middle), new CountSheep(middle, end));
        }
    }
    
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        CountSheep action = new CountSheep(0,sheep.length);
        pool.invoke (action);
        pool.shutdown();
        System.out.println (action.count);
    }
}