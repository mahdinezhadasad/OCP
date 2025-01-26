package Threads.src.threads;

class DiskPlayer implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("DiskPlayer closed");
    }
}

public class LightCycle {
    public static void main(String... bits) {
        try (DiskPlayer john = new DiskPlayer()) {
            System.out.println("ping");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("pong");
        }
        System.out.println("return");
    }
}