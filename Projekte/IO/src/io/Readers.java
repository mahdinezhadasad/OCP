package IO.src.io;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

class Nearly {
    String value;
    Nearly(String v) { value = v; }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals (obj);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode ();
    }
    
    public static void main(String[] sss) {
        
        Locale i1 = Locale.getDefault();       // US
        Locale i2 = new Locale("it");          // Italy
        Locale i3 = new Locale("it", "CH");    // Switzerland
        System.out.println(i1.getDisplayCountry(i2));
    }
}class MyObj {
    private int myInt;
    void setMyInt(int m) { myInt = m; }
    int getMyInt() { return myInt; }
}
class TestMO {
    
    public static double findTax(double p, DoubleUnaryOperator df){
        
        return df.applyAsDouble (p);
    }
    public static double findTaxx(double p, Function<Double, Double> tf){
       
       return tf.apply (p).doubleValue ();
    }
    
    public static double finddTax(double p, DoubleFunction<Double> f){
        
        return f.apply (p).doubleValue ();
    }
    public static void main(String[] args) throws InterruptedException {
        
        double price = 100.0;
        double tax = finddTax(price, (v -> v * 0.08));
        System.out.println("Tax for price " + price + " is " + tax);
        
        List<Integer> c = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3, 4));

// Secondary thread adds `42` after a delay
        new Thread(() -> {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.add(42); // Modifies the list
            System.out.println("After modification in thread: " + c);
        }).start();

// Main thread adds elements and iterates
        c.add(55);
        c.add(66);
        
        System.out.println("Before iteration: " + c); // Latest state of the list
        
        for (int i : c) {
            System.out.print(i + " "); // Iterates over the snapshot (state at iteration start)
            try {
                Thread.sleep(100); // Simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nAfter iteration: " + c); // Reflects the latest state
    }
    }


class Reading {
    int year;
    double extent;
    public Reading(int y, double e) { this.year = y; this.extent = e; }
    public int getYear() { return this.year; }
    public double getExtent() { return this.extent; }
}

class AlternateFuel {
    int getRating() { return 42; }
    static int getRating2() { return 43; }
}
class BioDiesel extends AlternateFuel {
    public static void main(String[] args) {
        new BioDiesel().go();
       System.out.print(getRating2());   // #1
    }
    void go() {
        System.out.print(super.getRating());    // #2
    }
}