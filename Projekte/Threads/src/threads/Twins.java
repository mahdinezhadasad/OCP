package Threads.src.threads;


interface Alex{
    
    default void write(){}
    static void publisch(){}
    
    void think();
}

interface Michael {
    
    public default void write(){}
    public static void publisch(){}
    public void think();
}


public class Twins  implements Alex ,Michael{
    
    
    
    @Override
    public void write() {
    
    }
    
    @Override
    public void think() {
    
    }
}