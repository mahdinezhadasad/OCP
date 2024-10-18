package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

public class B02_Collection_removeIf {

	/*
	 * Die Methoden 'stream' und 'parallelStream'
	 * werden beim Thema 'funktionale Streams' besprochen.
	 */
	public static void main(String[] args) {
		
		Collection<Integer> coll = new ArrayList<>();
		
		coll.add(1);
		coll.add(22);
		coll.add(7);
		coll.add(4);
		coll.add(19);
		
		System.out.println("1. coll: " + coll);

		/*
		 *  default boolean removeIf(Predicate<? super E> filter)
		 *  
		 *  Jedes Element der Collection wird mit dem
		 *  Predicate getestet. Die Elemente, für die
		 *  die Methode test true zurück liefert, werden entfernt.
		 */
		Predicate<Integer> p1 = (Integer x) -> {
			return x % 2 == 0;
		};
		
		coll.removeIf(p1);
		
		System.out.println("2. coll: " + coll); // [1, 7, 19]
		
//		kleineFrage();
		kleineFrage2();
	}
	
	static void kleineFrage() {
		/*
		 * Achtung! asList liefert eine Liste mit der
		 * fixierten Größe!
		 */
		Collection<String> coll = Arrays.asList("mo", null, "di", "null");
		
		coll.removeIf(s -> s==null); // Exception! 
		System.out.println(coll.size()); 
	}

	static void kleineFrage2() {
		System.out.println("\n*** Frage 2");
		Collection<String> coll = Arrays.asList("mo", null, "di", "null");
		coll = new ArrayList<>(coll);
		
		coll.removeIf(s -> s==null);  
		System.out.println("size: " + coll.size()); // 3 
		System.out.println(coll); // [mo, di, null] 
	}
	
}
