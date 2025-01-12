package Wdh.src.vererbung;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Predicate;

class Vehiclle {
    int vId;
    String vName;
    
    public Vehiclle(int vIdArg, String vNameArg) {
        this.vId = vIdArg;
        this.vName = vNameArg;
    }
    
    public int getVId() {
        return vId;
    }
    
    public String getVName() {
        return vName;
    }
    
    @Override
    public String toString() {
        return vName;
    }
}

class MyClass implements AutoCloseable {
    int test;
    
    @Override
    public void close() {
        // No specific action required on close
    }
    
    public MyClass copyObject() {
        return this;
    }
}

public class Maiin {
    public static void main(String[] args) throws InterruptedException {
        
        MyClass obj = null;
        
        try (MyClass obj1 = new MyClass()) {
            obj1.test = 100; // line n1
            obj = obj1.copyObject(); // Assign obj1 to obj
        }
        
        System.out.println(obj.test); // line n2
    }
    }