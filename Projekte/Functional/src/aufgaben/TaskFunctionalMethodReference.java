package Functional.src.aufgaben;

import java.util.function.BiFunction;

class Praktik {
 
   Besitzerr createBesitzerunbestimmteObjektvomSpeziallenType(int id){
       return new Besitzerr (this,id);
   }
}

class Besitzerr{
    
    private Praktik a;
    private int id;
    
    public Besitzerr(Praktik a, int id) {
        
        
        this.a = a;
        this.id = id;
        
    }
    
    static Besitzerr createInstance(Praktik a, int id) {
        
        return new Besitzerr(a, id);
    }
    
    @Override
    public String toString() {
        return "Besitzerr. id " + id + " Praktik " + a;
    }
}

class BesitzerrBildur{
    
    Besitzerr build(Praktik a, Integer id){
        
        return new Besitzerr(a,id);
    }
}


public class TaskFunctionalMethodReference{
    
    public static void main(String[] args) {
        
        BiFunction<Praktik,Integer,Besitzerr>  f1 = new BiFunction<Praktik,Integer,Besitzerr>() {
            
            public Besitzerr apply(Praktik a, Integer id) {
                return new Besitzerr (a,id);
            }
        };
        
        Besitzerr b1 = f1.apply (new Praktik (),1);
        System.out.println ("b1 : " + b1);
        
        
        BiFunction<Praktik,Integer,Besitzerr> f2 = (praktik, integer) -> new Besitzerr (praktik,integer);
        
        Besitzerr b3 = f2.apply (new Praktik (),2);
        System.out.println ("b3 : " + b3);
        
        
        
        BiFunction<Praktik,Integer,Besitzerr> f3 = Besitzerr::createInstance;
        
        Besitzerr b4 = f3.apply (new Praktik (),3);
        System.out.println ("b4 : " + b4);
        
        
        BiFunction<Praktik,Integer,Besitzerr> f4 = Besitzerr::new;
        
        Besitzerr b5 = f4.apply (new Praktik (),2);
        System.out.println ("b3 : " + b3);
        
        BesitzerrBildur obj = new BesitzerrBildur();
        BiFunction<Praktik,Integer,Besitzerr> f6 = obj::build;
        
        Besitzerr b6 = f6.apply (new Praktik (),6);
        System.out.println ("b6 : " + b6);
    
        
        BiFunction<Praktik,Integer,Besitzerr> f7 = Praktik::createBesitzerunbestimmteObjektvomSpeziallenType;
        
        Besitzerr b10 = f7.apply (new Praktik (),10);
        System.out.println ("b10" + b10);
    }
    
}