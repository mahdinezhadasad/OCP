package IO.src.io;

public class Woods {
    
    static class Tree{};
    public void method(){
        int water = 15;
        
        final class Oak extends Tree{
            
            public int getWatter(){
                
                return water;
            }
        }
        ;
        System.out.println (new Oak().getWatter());
    }
    public static void main(String[] args) {
        
        Woods w = new Woods();
        w.method();
    }
}

class OuterCttlass {
    static class StaticNestedClass {
        void printMessage() {
            System.out.println("StaticNestedClass method");
        }
    }
}

// Final class
final class FinalClass extends OuterCttlass.StaticNestedClass {
    void anotherMethod() {
        System.out.println("FinalClass method");
    }
}