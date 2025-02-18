package Exceptions.src.exceptions;


public class Fetch {
    public int play(String dogName) throws Exception {
        try {
            throw new RuntimeException(dogName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static final void main(String[] ball) throws Exception {
        new Fetch().play("Webby");
        new Fetch().play("Georgette");
    }
}

class MyResource implements AutoCloseable {
    public void close() throws Exception {
        throw new Exception("Fehler beim Schließen!");
    }
}

 class Main {
    public static void main(String[] args) {
        try (MyResource r = new MyResource()) {
            throw new RuntimeException("Fehler im Try-Block!");
        } catch (Exception e) {
            System.out.println("Haupt-Exception: " + e.getMessage());
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed.getMessage());
            }
        }
    }
}