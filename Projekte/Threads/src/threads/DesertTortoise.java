package Threads.src.threads;


interface CanBurrow{
    
    public abstract void burrow();
    
}

@FunctionalInterface
interface HashHardShell extends CanBurrow{}

abstract class Tortoise implements HashHardShell{
    
    public abstract int toughness();
}

public class DesertTortoise extends Tortoise {
    @Override
    public int toughness() {
        return 0;
    }
    
    
    @Override
    public void burrow() {
    
    }
}