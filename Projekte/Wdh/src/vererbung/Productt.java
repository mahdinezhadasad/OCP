package Wdh.src.vererbung;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayDeque;

public class Productt {
   
    
    public static void main(String[] args) {
        // Create an ArrayDeque
        ArrayDeque<String> deque = new ArrayDeque<>();
        
        // Add elements using the add() method
        deque.add("Element 1");
        deque.add("Element 2");
        deque.add("Element 3");
        
        System.out.println("Deque after add operations: " + deque);
        
        // Remove an element using the remove() method
        String removedElement = deque.remove(); // Removes the head (Element 1)
        System.out.println("Removed element: " + removedElement);
        System.out.println("Deque after remove operation: " + deque);
        
        // Add more elements
        deque.add("Element 4");
        System.out.println("Deque after adding Element 4: " + deque);
        
        // Pop an element using the pop() method
        String poppedElement = deque.pop(); // Removes the head (Element 2)
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Deque after pop operation: " + deque);
    }
}