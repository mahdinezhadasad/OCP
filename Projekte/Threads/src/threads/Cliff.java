package Threads.src.threads;

final class FallenException extends Exception{}

final class HikinGear implements AutoCloseable {
    @Override
    public void close() throws Exception {
        
        throw new FallenException();
        
    }
}


public class Cliff {
    
    public final void climb() throws Exception{
        
        try(HikinGear gear = new HikinGear()){
            
            throw new RuntimeException ("RuntimeException from climb()");
        }
    }
    
    public static void main(String[] args) {
        try{
            
            new Cliff ().climb ();
        } catch (Throwable e) {
            System.out.println ("Primary Exception: " + e);
            for(Throwable suppressed : e.getSuppressed()){
                
                System.out.println ("Suppressed: " + suppressed);
            }
        }
    }
}