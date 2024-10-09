package queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class B01_Queue {

	public static void main(String[] args) {
		
		/*
		 * LinkedList als Queue ist unwahrscheinlich in der Prüfung
		 */
		System.out.println("*** LinkedList als Queue");
		Queue<Integer> queue = new LinkedList<>(); // FIFO
		
		queue.add(23);
		queue.offer(-7);
		queue.add(5);
		
		System.out.println("1. queue: " + queue); // [23, -7, 5]
		
		/*
		 * Ausgaben (FIFO): 23, -7, 5
		 */
		while (!queue.isEmpty()) {
			Integer next = queue.remove();
			System.out.println(next); 
		}

		System.out.println("2. queue: " + queue); // []
		
		/*
		 * PriorityQueue ist unwahrscheinlich in der Prüfung
		 * 
		 * PriorityQueue: das kleinste Element hat die höchste Priorität.
		 * 
		 * PriorityQueue funktioniert als sortierte Collection  bei den Methoden 
		 * 		element()
		 * 		peek()
		 * 
		 * 		remove()
		 * 		poll()
		 */
		System.out.println("\n*** PriorityQueue als Queue");
		queue = new PriorityQueue<>();
		
		queue.add(23);
		queue.add(-7);
		queue.add(5);
		
		System.out.println("1. queue: " + queue); // [irgendeine Reihenfolge beim Iterieren]
		
		/*
		 * Ausgaben (nach Priorität): -7, 5, 23
		 */
		while (!queue.isEmpty()) {
			Integer next = queue.remove();
			System.out.println(next); 
		}

		System.out.println("2. queue: " + queue); // []
		
	}

}
