package Generics.src.generics;
class A {
    void m() {
        System.out.println("outer");
    }
}

public class TestInners {
    public static void main(String[] args) {
        new TestInners().go();
    }
    
    void go() {
        new A().m();  // Hier wird die äußere Klasse A verwendet
        
        class A {
            void m() {
                System.out.println("inner");
            }
        }
        
        System.out.println("After inner class");
        
        // Eine Instanz der lokalen Klasse A erstellen
        A localA = new A();
        localA.m();  // Jetzt wird die lokale Klasse A verwendet
        
        // Eine Instanz der inneren Klasse A erstellen
       // new TestInners.A().m();
    }
    
    class A {
        void m() {
            System.out.println("middle");
        }
    }
}