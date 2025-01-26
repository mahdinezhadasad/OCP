package Threads.src.threads;
public class IllegalStateExceptionExample {
    
    public static void main(String[] args) {
        try {
            performAction(false); // Hier wird IllegalStateException geworfen
        } catch (IllegalStateException e) {
            System.out.println("Caught IllegalStateException: " + e.getMessage());
        }
    }
    
    public static void performAction(boolean isReady) {
        if (!isReady) {
            throw new IllegalStateException("The system is not ready to perform this action.");
        }
        System.out.println("Action performed successfully!");
    }
}