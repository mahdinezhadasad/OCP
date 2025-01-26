package Threads.src.threads;


class MissedCallException extends RuntimeException {} // geändert auf RuntimeException

public class Phone {
    static void makeCall() throws RuntimeException {
        throw new ArrayIndexOutOfBoundsException("Call");
    }
    
    public static void main(String[] messages) {
        try {
            makeCall();
        } catch (RuntimeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
            
            // Print suppressed exceptions
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed Exception: " + suppressed.getMessage());
            }
        } finally {
            throw new RuntimeException("Text");
        }
    }
}