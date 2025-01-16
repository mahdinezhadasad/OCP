package IO.src.io;


interface Alex{
    
    default void write(){}
    static void publish(){}
    void think();
}
@FunctionalInterface interface Study {
    abstract int learn(String subject, int duration);
}
class BiologyMaterial implements Study {
    @Override public int learn(String subject, int duration) {
        if(subject == null)
            return duration;
        else
            return duration+1;
    }
}
interface Michael{
    
    public default void write(){}
    public static void publish(){}
    public void think();
}

public class Twins{
    
    public static void main(String[] args) {
        for (Proposition p : Proposition.values()) {
            System.out.println(p + ": " + p.getValue() + ", " + p.getNickName());
        }
    
    }
}
 enum Proposition {
    TRUE(-10) {
        @Override
         String getNickName() {
            return "RIGHT";
        }
    },
    FALSE(-10) {
        @Override
         String getNickName() {
            return "WRONG";
        }
    },
    UNKNOWN(0) {
        @Override
         String getNickName() {
            return "LOST";
        }
    }; // Note the semicolon at the end of the enum constants
    
    private final int value;
    
    Proposition(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
     abstract String getNickName(); // Changed to public from protected
}


final class Botetle{
    
    final private int size= 14;
    final protected class Insert{
        
        private  final int size =25;
        public final int getSize(){
            
            return Botetle.this.size;
        }
    }
    
    
    final Insert insert = new Insert();
    
    public static void main(String[] args) {
        
        System.out.println (new Botetle ().insert.getSize ());
    }
}

abstract interface CanSwim {
    public void swim();
}
 class Turtle {
    public static void main(String[] seaweed) {
        int distance = 7;
        CanSwim seaTurtle = new CanSwim () {
            @Override
            public void swim() {
                System.out.print(distance);
            }
        };
        seaTurtle.swim ();
      };
      
    }


interface Toy { String play(); }
class Gift {
    public static void main(String[] matrix) {
        abstract class Robot {}
        class Transformer extends Robot implements Toy {
            public String name = "GiantRobot";
            public String play() {return "DinosaurRobot";}
        }
        Transformer prime = new Transformer () {
            public String play() {return name;}  // y1
        };
        System.out.print(prime.play());
    }
}

class Leader {}
class Follower {}
abstract  class Dancer {
    public Leader getPartner() { return new Leader(); }
    abstract public Leader getPartner(int count);  // u1
}

abstract class SwingDancer extends Dancer {

}


class Ready {
    protected static int first = 2;
    private  final short DEFAULT_VALUE = 10; // Changed to static to make it accessible in the static nested class
    
    private static class GetSet {
        int first = 5;
        static int second = DEFAULT_VALUE; // Now works because DEFAULT_VALUE is static
    }
    
    private GetSet go = new GetSet();
    
    public static void main(String[] begin) {
        Ready r = new Ready();
        System.out.print(r.go.first); // Accessing the first field of the GetSet instance
        System.out.print(", " + r.go.second); // Accessing the static second field of the GetSet class
    }
}