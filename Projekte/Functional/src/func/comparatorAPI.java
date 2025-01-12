package Functional.src.func;

import java.util.Comparator;

class Persone {
    
   private String vorname;
   private String nachname;
   private int geburtsjahr;
     
     public Persone(String vorname, String nachname, int geburtsjahr) {
         this.vorname = vorname;
         this.nachname = nachname;
         this.geburtsjahr = geburtsjahr;
     }
     
     public String getVorname() {
         return vorname;
     }
     
     public String getNachname() {
         return nachname;
     }
     
     public int getGeburtsjahr() {
         return geburtsjahr;
     }
     
     @Override
     public String toString() {
         return "Persone{" +
                 "vorname='" + vorname + '\'' +
                 ", nachname='" + nachname + '\'' +
                 ", geburtsjahr=" + geburtsjahr +
                 '}';
     }
 }


public class comparatorAPI{
    
    
    public static void main(String[] args) {
      test_comparing ();
    }
    
    static void test_comparing(){
        
        System.out.println ("\n **** comparing");
        
//Function<aufgaben.personen.Person,String> keyExtractor = Person::getNachname;
        
/*        Comparator<Person> c1= (PersonA, PersonB) ->{
             Comparable keyA = PersonA.getNachname ();
             Comparable keyB = PersonB.getNachname ();
             
             return keyA.compareTo (keyB);
            
        };
        
       
        
        Comparator<Person> c2 = (PersonA,PersonB)->{
            
            Comparable keyA = keyExtractor.apply (PersonA);
            Comparable keyB = keyExtractor.apply (PersonB);
            
            return keyA.compareTo (keyB);
        };*/
        /*Comparator<Person> c3 = Comparator.comparing(keyExtractor);
        Person p1 = new Person("John", "Smith", 1);
        Person p2 = new Person("Peter", "MAAd", 2);*/
       /*
        int result = c3.compare (p1,p2);
        System.out.println ("compare(p1,p2) :" +result);
        
        result = c3.compare (p2,p1);
        */
       /* System.out.println ("compare(p2,p1) :" +result);*/
    }
    
    static void test_naturalOrder_reverseOrder(){
        
        System.out.println ("\n **** naturalOrder, reverseOrder");
        
        Comparator<Integer> cmpNatural = Comparator.naturalOrder ();
        Comparator<Integer> cmpReverse = Comparator.reverseOrder ();
        
        
        
        Integer x = 12;
        Integer y =1200;
        
        System.out.println ("natural: " +cmpNatural.compare (x,y));
        System.out.println ("Reverse :" +cmpReverse.compare (x,y));
        
    }
    
    static void test_compare(){
        
        System.out.println ("**** compare");
        
        Comparator<String> cmp = new Comparator<String> () {
           
            public int compare(String o1, String o2) {
                return o1.compareTo (o2);
            }
        };
        
        String x = "bbbb";
        String y = "bbddb";
        
        int result = cmp.compare (x,y);
        
        if(result<0){
            
            System.out.println ("'" + x + "' is less than '" + y + "'");
            
        }
        else if(result>0){
            
            System.out.println ("'" + x + "' is greater than '" + y + "'");
        }
        
        else {
            
            System.out.println ("'" + x + "' is equal to '" + y + "'");
        }
        
        
    }


}