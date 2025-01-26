package Threads.src.threads;


public class Bells {
    class Player implements AutoCloseable {
        @Override
        public void close() throws RingException {
            throw new RingException("Player closing failed!");
        }
    }
    
    class RingException extends Exception {
        public RingException(String message) {
            super(message);
        }
    }
    
    public static void main(String[] notes) throws Throwable {
        try (Player p = null) {
            throw new Exception("Main Exception");
        } catch (Exception e) { // Der Catch-Block fängt `Error`, das kein Untertyp von `Exception` ist.
            System.out.println("Caught Error: " + e.getMessage());
        }catch (Error r){
            
            System.out.println ("Hier is Error von Throwable ");
        }
    }
}