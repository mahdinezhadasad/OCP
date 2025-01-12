package Functional.src.func;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Augabe {
    
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        putIntegers(i -> sb.append(i).append(" "));
        System.out.println(sb); // Zeile A
        
        List<Integer> list = new ArrayList<> ();
        putIntegers(list::add);
        System.out.println(list); // Zeile B
        
        putIntegers(System.out::print); // Zeile C, op
    }
    
    public static void putIntegers( Consumer<Integer> T){
        
        
        for(int j = 0; j < 10; j++){
            
            T.accept (j);
        }
    }

}