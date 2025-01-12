package Wdh.src.vererbung;

class Vehiclee {
    int id;
    
    public void start() {
         class Engine {  // Local class inside a method
            int eNo = id;  // Can access enclosing class's members
        }
    }
}

class Computer {
    private Card sCard = new SoundCard();  // Instantiate the nested subclass
    
    private abstract class Card {  // Abstract nested class
    }
    
    private class SoundCard extends Card {  // Concrete subclass of Card
    }
}

class Produuct {
    interface Moveable {  // Interface
        void move();
    }
    
    Moveable mProduct = new Moveable() {  // Anonymous inner class implementing Moveable
        @Override
        public void move() {  // Provide implementation for the abstract method
        }
    };
}