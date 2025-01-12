package Functional.src.func;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

interface Moveable<Integer>{
    
    public default void Walk(Integer distance){
        System.out.println ("Waking");
    }
    public void run(Integer distance);
}
public class Frame {
    
    public static void main(String[] args) {
       Moveable<Integer> moveable = (Integer n) -> System.out.println (n);
       
       moveable.run (100);
       moveable.Walk (50);
      
        
        
    }

}