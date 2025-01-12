package IO.src.nio;

 class Computer {
     
     private Card sCard = new SoundCard ();
     
     private abstract class Card{};
     private class SoundCard extends Card{};
}

class Vehichle{
     
     int id ;
     public void start(){
         
          class Engine{
             
             int eNo = id;
         }
     }
}

class Block{
    static int bno;
     static class Counter{
         
         int locator;
         Counter(){  locator = bno;};
     }
     
}

class Productt{
     
     interface Moveablee{ void move();}
    
     Moveablee mProduct = new Moveablee(){
         public void move(){
         
         
         }
     };
}