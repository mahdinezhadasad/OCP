package queue;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class B02_QueueAPI {

	/*
	 * ArrayDeque als eine Queue: FIFO
	 */
	public static void main(String[] args) {

		/*
		 * boolean add(E e)
		 * boolean offer(E e)
		 */
		
		Queue<String> queue = new ArrayDeque<String>();
		
		queue.add("mo");
		queue.offer("di");
		
		System.out.println("1. queue: " + queue); // [mo, di]
		
		queue.add("mi");
		queue.offer("do");

		System.out.println("2. queue: " + queue); // [mo, di, mi, do]
		
		/*
		 * E element()
		 * E peek()
		 */
		String s = queue.element();
		System.out.println("element(): " + s); // mo
		
		s = queue.peek();
		System.out.println("peek(): " + s); // mo
		
		System.out.println("2. Nochmal queue: " + queue); // [mo, di, mi, do]
		
		/*
		 * E remove()
		 * E poll()
		 */
		s = queue.remove();
		System.out.println("remove(): " + s); // mo
		
		System.out.println("3. queue: " + queue); // [di, mi, do]
		
		s = queue.poll();
		System.out.println("poll(): " + s); // di
		
		System.out.println("4. queue: " + queue); // [mi, do]
		
		queue.clear();
		System.out.println("5. queue: " + queue); // []
		
		try {
			s = queue.element();
		} catch (NoSuchElementException e) {
			System.out.println("Exception in element(): Die Schlange ist leer");
		}
		
		s = queue.peek();
		System.out.println("peek(): " + s); // null
		
		try {
			s = queue.remove();
		} catch (NoSuchElementException e) {
			System.out.println("Exception in remove(): Die Schlange ist leer");
		}
		
		s = queue.poll();
		System.out.println("poll(): " + s); // null
		
	}

}
