package Threads.src.threads;



import java.io.*;

class OutOfTuneException extends Exception {
    OutOfTuneException(String message) {
        super(message);
    }
}

public class Piano {
    public void play() throws OutOfTuneException, FileNotFoundException {
        throw new OutOfTuneException("Sour note!");
    }
    
    public static void main(String... keys) throws OutOfTuneException, FileNotFoundException {
        final Piano piano = new Piano();
        try {
            piano.play();
        } catch (OutOfTuneException e) {
           // System.out.println("Caught exception: " + e.getMessage());
            throw e;
        } catch (FileNotFoundException e) {
           // System.out.println("Caught exception: File not found!");
            throw e;
        } finally {
            System.out.println("Song finished!");
        }
    }
}