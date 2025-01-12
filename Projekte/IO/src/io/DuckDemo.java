package IO.src.io;



import java.util.Iterator;

import java.util.TreeSet;

class Clidders {
    public final void flipper() { System.out.println("Flip a Clidder"); }
}
@FunctionalInterface
interface QuackBehavior{
    
    public void quack();
}

class Duck{
    
    QuackBehavior fb;
    
    public void quack(){
        
        fb.quack ();
    }
    
}

class RedheadDuck extends Duck{
    
    public RedheadDuck(){
        
        fb = () -> System.out.println ("Quack,quack");
    }
}
class Combination {
    private int[] combo = {17, 24, 36};
    int[] getCombo() { return combo; }
    void printCombo() {
        for(int x : combo) System.out.print(x + " ");
    }
}
class Thief implements Comparable{
    public static void main(String[] args) {
        Combination c = new Combination();
        
      
        c.printCombo();
        int[] myArray = c.getCombo();
        myArray[0] = 18;
        c.printCombo();
    }
    
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
class RubberDuck extends Duck{
    
    public RubberDuck(){
        
        fb = () -> System.out.println ("Squeak,squeak");
    }
}


public class DuckDemo {
   
    public static void main(String[] args) {
       /* RedheadDuck huey = new RedheadDuck (); // Create a RedheadDuck
        RubberDuck louie = new RubberDuck (); // Create a RubberDuck
        huey.quack();
        louie.quack();*/
        TreeSet map = new TreeSet ();
        map.add("one");
        map.add("two");
        map.add("three");
        map.add("four");
        map.add("one");
        Iterator it = map.iterator ();
        while (it.hasNext ()) {
            System.out.println (it.next () + "");
        }
       
        
        QuackBehavior redheadQuack = () -> System.out.print("Quack, quack ");
        QuackBehavior rubberQuack = () -> System.out.println("Squeak, squeak");
        
        // Call quack behaviors directly
        redheadQuack.quack(); // Outputs: Quack, quack
        rubberQuack.quack();  // Outputs: Squeak, squeak
    }
   
    
}

class TarsierX {
    static String s = "-";
    public static void main(String[] args) {
        go();
        System.out.println(s);
    }
    { go(); }
    static { go(); }
    static void go() { s+= "s"; }
}