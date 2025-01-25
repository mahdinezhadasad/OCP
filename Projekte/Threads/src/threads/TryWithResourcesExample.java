package Threads.src.threads;
public class TryWithResourcesExample {
    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {
            throw new RuntimeException("Exception im try-Block");
        } catch (Exception e) {
            System.out.println("Gefangene Ausnahme: " + e.getMessage());
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Unterdrückte Ausnahme: " + suppressed.getMessage());
            }
        }
    }
}

class MyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("Exception in close()");
    }
}