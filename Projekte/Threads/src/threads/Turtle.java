package Threads.src.threads;

import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;

abstract interface CanSwim{
    
    
    public void swim();
}

public class Turtle {
    
    public static void main(String[] args) {
        
        
        DoubleConsumer  printDouble = d -> System.out.println(d);
        printDouble.accept (25555.0);
        DoubleStream.of (3.14,2.71,1.688).forEach (printDouble);
        
    }
}