package Functional.src.streams.wdh;

import java.io.Closeable;
import java.io.IOException;

public class Animals {
    class Lamb implements Closeable {
        @Override
        public void close() {
            throw new RuntimeException("a");
        }
    }
    
    public static void main(String[] args) {
        try {
            new Animals().run();
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed.getMessage());
            }
        }
    }
    
    public void run() throws IOException {
        try (Lamb l = new Lamb()) {
            throw new IOException("Primary Exception");
        } catch (Exception e) {
            throw new IOException("New IOException");
        }
    }
}