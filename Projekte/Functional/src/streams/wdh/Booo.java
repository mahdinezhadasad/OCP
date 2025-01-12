package Functional.src.streams.wdh;

class Boo {
    Boo(String s) {
        System.out.println ("Boo with construntor Created");
    }
    Boo() {
        System.out.println ("Boo without constructor created");
    }
}

class Bar extends Boo {
    Bar() {
        System.out.println ("BAr without Constructor created");
    }
    Bar(String s) {
        super(s);
    }
    void zoo() {
        // Option A
        // Boo f = new Boo(24) { }; // Compilation error: No matching constructor
        
        // Option B
       Boo f1 = new Bar() { }; // Creates an anonymous inner class extending Bar
        
       // Boo f6 = new Bar ("ssss");
        
        // Option C
       // Boo f2 = new Boo() {
     //       String s;
      //  }; // Creates an anonymous inner class extending Boo
        
        
     //   Boo f4 = new Boo( "ssss") {};
        // Option D
        // Bar f3 = new Boo(String s) { }; // Compilation error: Type mismatch
        
        // Option E
        // Boo f4 = new Boo.Bar(String s) { }; // Compilation error: Invalid syntax
    }
}

public class Booo {
    public static void main(String[] args) {
        class Horse {
            public String name;
            
            public Horse(String s) {
                name = s;
            }
        }
        Horse obj = new Horse("Zippo"); // Declare obj as Horse
        System.out.println(obj.name);  // No casting needed
    }
}