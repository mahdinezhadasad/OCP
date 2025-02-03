package Functional.src.collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.DoubleStream;

class Combinatio{
    
    private int[]  combo = {17,24,36};
    int[]  getCombo()  {return combo;}
    void printCombo(){
        
        for(int x : combo){
            System.out.println (x + "");
        }
    }
}


public class Thief {
    public static void before() {
        Set set = new TreeSet();
        set.add("2");
        set.add(3);
        set.add("1");
        Iterator it = set.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
    }
    
    public static void main(String[] args){
        
        double[] ppms = { 405.91, 405.98, 406.14, 406.48, 406.20,
                406.03, 405.91, 406.91, 407.37 };
        DoubleStream s = Arrays.stream(ppms);
        long result = s.parallel()
                .filter(d -> d > 406.5)
                .peek(d -> System.out.print (d + " ")).count();
        
        System.out.println (result);
        
        System.out.println ("\n *****************************************");
        Combinatio c = new Combinatio();
        c.printCombo();
        System.out.println ("*****************************************");
        int[] myArray = c.getCombo();
        myArray[0] = 18;
        
        c.printCombo();
        
        ArrayDeque a = new ArrayDeque();
        a.offer(new Long(7));
        a.offer(new String("hi"));
        a.offer(true);
        a.offer(420);
        
        System.out.println (a  +" ");
        
        if(a.peekLast() == new Integer(420)){
            System.out.println ("==");
        }
    }
}