package Functional.src.collections;

interface Modern {
    default String speak() { return "modern! "; }  // line a
    static String doStuff(String gerund) {        // line b
        return gerund + " in your sleep";
    }
}

public class PostModern implements Modern {
    public static void main(String[] args) {
        new PostModern().go();
    }
    
    void go() {
        System.out.print(new PostModern().speak());        // line c
        System.out.print(speak());               // line d
        System.out.print(Modern.doStuff("walking")); // line e
       // System.out.print(doStuff("talking"));    // line f
    }
}