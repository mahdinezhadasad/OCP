package Collections.src.list;

interface Hungry<E> {
    void munch(E x);
}

interface Carnivore<E extends Animal> extends Hungry<E> {}

interface Herbivore<E extends Animal> extends Hungry<E> {}

abstract class Plant {}

class Grass extends Plant {}

abstract class Animal {}

class Sheep extends Animal implements Herbivore<Sheep> {
 
    
    @Override
    public void munch(Sheep x) {
    
    }
}

class Wolf extends Animal implements Carnivore<Sheep> {
    public void munch(Sheep x) {
        // Implementation for munching Sheep
    }
    
    public static void main(String[] args) {
    
    }
}