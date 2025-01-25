package Threads.src.threads;


public class Fetch {
    public int play(String dogName) throws Exception {
        try {
            throw new RuntimeException(dogName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static final void main(String[] ball) throws Exception {
        try {
            new Fetch().play("Webby");
            new Fetch().play("Georgette");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}