package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class B03_Deque {

	public static void main(String[] args) {
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		// HEAD [] TAIL
		System.out.println("1. deque: " + deque); 

		/*
		 * void addFirst(E e)
		 * void offerFirst(E e)
		 * 
		 * void addLast(E e)
		 * void offerLast(E e)
		 * 
		 */
		
		deque.addLast(5); // HEAD [5] TAIL
		deque.offerFirst(4); // HEAD [4, 5] TAIL
		
		System.out.println("2. deque: " + deque); 
		
		deque.offerLast(6); // HEAD [4, 5, 6] TAIL
		System.out.println("3. deque: " + deque); 
		
		/*
		 * getFirst
		 * peekFirst
		 * 
		 * getLast
		 * peekLast
		 * 
		 * removeFirst
		 * pollFirst
		 * 
		 * removeLast
		 * pollLast
		 */
		
		Integer x = deque.pollFirst(); // HEAD [5, 6] TAIL
		System.out.println("x = " + x); // 4
		
		
		/*
		 * TAIL-Methoden:
		 * 		boolean add(E e)
		 * 		boolean offer(E e)
		 * 
		 * HEAD-Methoden:
		 * 		element()
		 * 		peek()
		 * 
		 * 		remove()
		 * 		poll()
		 * 
		 * HEAD-Methoden für Stack-Simulation:
		 * 		void push(E e)
		 * 		peek()
		 * 		pop()
		 * 
		 */
		
		// HEAD [5, 6] TAIL
		System.out.println("4. deque: " + deque);
	
		deque.add(-3);    // HEAD [5, 6, -3] TAIL
		deque.offer(17);  // HEAD [5, 6, -3, 17] TAIL
		
		System.out.println("5. deque: " + deque);
		
		System.out.println("element(): " + deque.element()); // 5
		System.out.println("poll(): " + deque.poll()); // 5
		
		// HEAD [6, -3, 17] TAIL
		System.out.println("6. deque: " + deque);
		
		deque.push(101);  // HEAD [101, 6, -3, 17] TAIL
		System.out.println("7. deque: " + deque);
		
		/*
		 * Frage A.
		 * 
		 * Gegeben ist die Zeile:
		 * 
		 *   System.out.println(deque.remove() + " " + deque.push(92));
		 * 
		 * Was ist das Ergebnis für die Zeile?
		 * 
		 *   A. Compilerfehler 			<- richtige Antwort (push ist void)
		 *   B. Exception 	
		 *   C. [92, 101, 6, -3]
		 *   D. true true
		 *   E. 101 true
		 * 
		 */
		
		/*
		 * Frage B.
		 * 
		 * Gegeben ist die Zeile:
		 * 
		 *   System.out.println(deque.remove() + " " + deque.add(92));
		 * 
		 * Was ist das Ergebnis für die Zeile?
		 * 
		 *   A. Compilerfehler 			
		 *   B. Exception 	
		 *   C. [92, 101, 6, -3]
		 *   D. true true				
		 *   E. 101 true			<- richtige Antwort
		 * 
		 */
		
		System.out.println(deque.remove() + " " + deque.add(92)); // 101 true
		
		// HEAD [6, -3, 17, 92] TAIL
		System.out.println("8. deque: " + deque);
	}

}









