package streams.wdh;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class B01_bilden {

	public static void main(String[] args) {

		/*
		 * Interface Stream
		 */
		
		/*
		 *  static<T> Stream<T> of(T... values)
		 */
		
		System.out.println("*** Bsp. 1");
		Stream<Integer> s1 = Stream.of(2, 4, 6, 8); 
		s1.forEach(System.out::println);
		
		System.out.println("*** Bsp. 2");
		Integer[] a1 = { 1, 2, 3 };
		
		Stream<Integer> s2 = Stream.of(a1); // Stream<Integer>
		s2.forEach(System.out::println);
		
		
		/*
		 *  static<T> Stream<T> of(T values) 
		 */
		System.out.println("*** Bsp. 3"); // in der Prüfung nicht so kompliziert
		
		Stream.<Integer[]>of(a1) // Stream<Integer[]>
			.forEach(System.out::println); // [Ljava.lang.Integer;@52d455b8
		
		/*
		 * static<T> Stream<T> generate(Supplier<? extends T> s)
		 */
		System.out.println("*** Bsp. 4");
		
		Supplier<Integer> sup1 = () -> 42;
		
		Stream.generate(sup1)
			.limit(5)
			.forEach(System.out::println);
		
		/*
		 * Bsp. 5
		 */
		System.out.println("*** Bsp. 5");
		
		UnaryOperator<Integer> op1 = x -> x + 2;
		
		Stream.iterate(1, op1)
			.limit(5)
			.forEach(System.out::println);
		
	} // end of main

}
