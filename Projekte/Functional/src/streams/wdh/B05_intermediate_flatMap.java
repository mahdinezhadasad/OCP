package streams.wdh;

import java.util.stream.Stream;

public class B05_intermediate_flatMap {

	public static void main(String[] args) {
		
		/*
		 * ohne flatMap
		 */
		Integer[] a1 = { 1, 2, 3 }; 
		Integer[] a2 = { 4, 5 }; 

		Stream<Integer> s1 = Stream.of(a1);
		Stream<Integer> s2 = Stream.of(a2);
		
		Stream<Integer> sA = Stream.concat(s1, s2); // Daten: 1, 2, 3, 4, 5
		
		//---
		Integer[] a3 = { 6, 7, 8 };
		
		Stream<Integer> s3 = Stream.of(a3);
		
		Stream<Integer> sB = Stream.concat(sA, s3); // Daten: 1, 2, 3, 4, 5, 6, 7, 8
		
		//---
		Integer[] a4 = { 9, 10, 11, 12 };
		
		Stream<Integer> s4 = Stream.of(a4);
		
		Stream<Integer> sC = Stream.concat(sB, s4); // Daten: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
		
		long count = sC.count();
		
		System.out.println("count: " + count); // 12
		
		/*
		 * mit flatMap
		 * 
		 * 	- aus einem Element eines Streams einen Stream erzeugen,
		 *  - alle so erzeugten Streams konkatenieren
		 */
		
		long count2 = Stream.of(a1, a2, a3, a4) // Elemente sind Arrays
				.flatMap(Stream::of) // aus jedem Array ein Stream erzeugen 
									 // und solche Streams konkatenieren
				.count();
		
		System.out.println("count2: " + count2); // 12
		
	}

}
