package IO.src.io;

enum Light{}
public enum Color  {
    
    RED,BLUE;
    
  
}

abstract class AbstractClass{
    
    static void staticMethod(){
        
        System.out.println ("Static method in AbstractClass");
    }
}
class Test{
    public static void main(String[] args) {
        AbstractClass.staticMethod ();
        OutereClass.StaticNestedClass.staticMethod ();
        MyInterface.staticMethod ();
        OutereClass myClass = new OutereClass();
       
    
    }
}
class OutereClass{
    
    static class StaticNestedClass{
        
        static void staticMethod(){
            
            System.out.println ("Static method in OutereClass");
        }
        
        
    }
    
    void OutereMethod(){
        class LocalInnerClass{
            
            static void staticMethod(){
                
                System.out.println ("Static method in LocalInnerClass");
            }
        }
    }
}
interface MyInterface{
    static void staticMethod(){
        System.out.println ("Static method in MyInterface");
    }
}


class Bottle {
    public static class Ship { // Static nested class
        private enum Sail { // Enum inside static nested class
            TALL {
                protected int getHeight() {
                    return 100;
                }
            },
            SHORT {
                protected int getHeight() {
                    return 2;
                }
            };
            
            protected abstract int getHeight(); // Abstract method
        }
        
        public Sail getSail() {
            return Sail.TALL; // Returning the enum constant TALL
        }
    }
    
    public static void main(String[] stars) {
        Bottle.Ship ship = new Bottle.Ship(); // Correct way to instantiate static nested class
        System.out.print(ship.getSail().getHeight ());
    }
}