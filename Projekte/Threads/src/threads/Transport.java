package Threads.src.threads;

public class Transport {
    @Override
    public int hashCode() {
        return super.hashCode ();
    }
    
    static interface Vehiclee{}
    static class Bus implements Vehiclee{}
    static class Van implements Vehiclee{}
    
    public static void main(String[] args) {
        
        Bus bus = new Bus();
        Van van = new Van();
        Van[] vans = new Van[0];
        
        boolean b = bus instanceof Vehiclee;
        
        boolean v = van instanceof Vehiclee;
        
        boolean b1 = vans instanceof Vehiclee[];
        
        System.out.println (b + " " + v + " " + b1);
    }
}