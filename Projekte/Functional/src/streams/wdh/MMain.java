package Functional.src.streams.wdh;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class MyClass {
    // Instance synchronized method
    public synchronized void instanceMethod() {
        System.out.println(Thread.currentThread().getName() + " is in instanceMethod()");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " exits instanceMethod()");
    }
    
    // Static synchronized method 1
    public static synchronized void staticMethod1() {
        System.out.println(Thread.currentThread().getName() + " is in staticMethod1()");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " exits staticMethod1()");
    }
    
    // Static synchronized method 2
    public static synchronized void staticMethod2() {
        System.out.println(Thread.currentThread().getName() + " is in staticMethod2()");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " exits staticMethod2()");
    }
}

public class MMain {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer>  cowList = new CopyOnWriteArrayList<>();
        cowList.add (4);
        cowList.add (2);
        cowList.add (6);
        
        
        Iterator<Integer> iterator = cowList.iterator();
        cowList.remove (2);
        while (iterator.hasNext()) {
            
            System.out.println (iterator.next () + " ");
        }
    }
}