package Threads.src.threads;


import java.util.function.DoubleUnaryOperator;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.DoubleStream;

class Tourist{
    
    public Tourist(double distance){
        this.distance=distance;
    }
    public double distance;
}

public class Lifeguard {
    
    private void saveLife(Predicate<Tourist> canSave, Tourist tourist) {
        
        System.out.println (canSave.test (tourist) ? "Saved" : "Not Saved");
    }
    
    public final static void main(String[] args) {
        
        ToDoubleBiFunction<Rectangle, Double> scaledArea = ((rectangle, aDouble) -> rectangle.length * rectangle.width * aDouble);
        Rectangle rectangle = new Rectangle (5.0, 3.0);
        double distance = scaledArea.applyAsDouble (rectangle, 1.2);
        System.out.println("Skalierte Fläche: " + distance); // Ausgabe: 18.0
        
        DoubleUnaryOperator halve = x ->x/2;
        DoubleStream.of(10,20,30)
                .map (halve)
                .forEach (System.out::println);
        
    }
}

class Rectangle{
    
    double length;
    double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
}