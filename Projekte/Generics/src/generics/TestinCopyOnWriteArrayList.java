package Generics.src.generics;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TestinCopyOnWriteArrayList {
    
    public static void main(String[] args) {
        
        ConcurrentMap<String,Integer>  ages = new ConcurrentHashMap<> ();
        
        ages.put ("John",23);
        ages.put ("Jane",25);
        ages.put ("Jack",24);
        
        ages.remove ("John");
        
        System.out.println (randomD ());
    }
    
    public static int randomD(){
        
        ThreadLocalRandom lr = ThreadLocalRandom.current();
        return lr.nextInt (1,100);
    }
}