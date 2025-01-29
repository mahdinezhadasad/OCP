package Threads.src.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;





class Laptop extends Computer {
    
     String name = "Laptop";
    public  void startup() {
        System.out.print("laptop-");
    }
    
    public int hashCode(){
        
        return name.hashCode();
    }
    
    public boolean equals(Object obj){
        
        if(!(obj instanceof Laptop)) return false;
        Laptop l = (Laptop)obj;
        return name.equals(l.name);
    }
}
class Building{}
class House extends Building{}
public class Computer {
    
    static interface Vehichle{}
    static class Bus implements Vehichle{}
    
     String name = "Computerffffffff"; // Statische Variable in der Unterklasse
    public  void startup() {
        System.out.print("computer-");
    }
    
    public static void main(String[] args) {
   /*     Computer computer = new Laptop();
        Laptop laptop = new Laptop();
      //  System.out.println (computer.name + " Computer");
       // System.out.println (laptop.name + " Laptorrrrrp");
        computer.startup();  // Computer-Version wird aufgerufen
        laptop.startup();    // Laptop-Version wird aufgerufen*/
        
        /*Bus bus = new Bus();
        System.out.println (null instanceof Bus);
        System.out.println (bus instanceof Vehichle);
        System.out.println (bus instanceof Bus);*/
     //   System.out.println (bus instanceof ArrayList);
       // System.out.println (bus instanceof Collections);
        
        Building b = new Building();
        House h = new House();
        Building bh = new House();
        Building p = (House)b;
        House  q = (House) h;
        Building r = (Building) bh;
        House s = (House) bh;
        
    }
}