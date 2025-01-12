package Functional.src.streams.wdh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CyclicBarrier;

public class SingletonTestDrive {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        System.out.println ("Enter GDP: ");
        int GDP = Integer.parseInt (br.readLine ());
        System.out.println ("GDP: " + GDP);
    
    
}

enum Singleton {
    
    INSTANCE;
    
    int value = 0;
    
    private void doSomething() {
        
        value = value + 1;
    }
    
    public synchronized int updateValue() {
        
        doSomething ();
        return value;
    }
    
    public int getValue() {
        return value;
    }
    
}}