package IO.src.io;

import javax.net.ssl.HostnameVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class CountResource extends ListResourceBundle {
    private static int count = 0; // Count is static to persist across instances
    
    
    protected Object[][] getContents() {
        return new Object[][] { { "keys", new ArrayList<String> ()} };
    }
    
    public static void main(String[] args) {
       ResourceBundle  rb = ResourceBundle.getBundle("IO.src.io.CountResource", Locale.ENGLISH);
        List<String> keys = (List<String>)rb.getObject("keys");
        keys.add ("q");
        keys.add ("p");
        keys.add ("r");
        keys.add ("t");
        keys.add ("w");
        
      
    }
}

class Transport{
    
    static interface vehicle{}
    static class Bus implements vehicle{}
    static class Apartment extends Building{}
    
    public static void main(String[] args) {
        
        Building b =  new Building();
        House h = new House();
        Building bh = new House();
        
        
        Building q = (Building) bh;
  
    }
}

class Building {}
class House extends Building{}

class OuterClass {
    
    private final int x = 5;
    final int  b = 6;
    int c = 7;
    static int d = 10;
     final class FinalNestedClass {
        
       
        void display() {
            System.out.println("This is a final static nested class." + c+b );
        }
    }
    
     abstract  static class AbstractNestedClass {
        private final int x = 5;
        final int  b = 6;
        int c = 7;
        abstract void show();
    }
    
    public static void main(String[] args) {
       
  
        
        OuterClass.AbstractNestedClass abstractNestedClass = new OuterClass.AbstractNestedClass (){
            
            @Override
            void show() {
                System.out.println("This is an abstract class." + d);
            }
        };
        
        abstractNestedClass.show();
    }
}

class AbstractLocalInnerClassExample {
    public void method() {
        // Abstract local inner class
        abstract class AbstractLocalInnerClass {
            abstract void display();
        }
        
        // Provide implementation using an anonymous inner class
        AbstractLocalInnerClass inner = new AbstractLocalInnerClass() {
            @Override
            void display() {
                System.out.println("Implemented abstract method in local inner class.");
            }
        };
        
        inner.display(); // Output: Implemented abstract method in local inner class.
    }
    
    public static void main(String[] args) {
        AbstractLocalInnerClassExample example = new AbstractLocalInnerClassExample();
        example.method();
    }
}