package Generics.src.generics;

public class Carrr {
    
    class Engine{
        
     /*   Engine(){
             Carrr.this.drive ();
        }*/
        
        {Carrr.this.drive ();}
    }
    
    public static void main(String[] args) {
        
        new Carrr ().go();
        
    }
    void go(){
        
        new Engine ();
    }
    void drive(){
        System.out.println ("hi");
    }
}