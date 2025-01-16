package IO.src.io;

public class Penguin {
    private int volume = 1;
    
    private class Chick {
        private static int volume = 3; // INVALID: static field in a non-static inner class
        
        void chick() {
            System.out.println("Honk(" + Penguin.this.volume + ")!");
        }
    }
    
    public static void main(String[] args) {
        Penguin p = new Penguin();
        final Penguin.Chick littleOne = p.new Chick();
        littleOne.chick();
    }
}

interface CanBurrow{
    
     void burrow();
}

@FunctionalInterface
interface  HasHardShell extends CanBurrow{


}

abstract class Tortoise implements HasHardShell{
    
    public abstract int toughness();
}