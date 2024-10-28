package streams.wdh;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class B01_bilden {

	public static void main(String[] args) {

		/*
		 * Methoden aus dem Interface Stream
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
		 * static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
		 */
		System.out.println("*** Bsp. 5");
		
		UnaryOperator<Integer> op1 = x -> x + 2;
		
		Stream.iterate(1, op1)
			.limit(5)
			.forEach(System.out::println);
		
		/*
		 * static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
		 */
		System.out.println("*** Bsp. 6");
		
		Stream<Integer> sA = Stream.of(1, 2, 3);
		Stream<Integer> sB = Stream.of(4, 5);
		
		Stream.concat(sA, sB)
			.forEach(System.out::println);
		
		/*
		 * static<T> Stream<T> empty()
		 */
		System.out.println("*** Bsp. 7");
		
		Stream.empty()
			.forEach(System.out::println);
		
		/*
		 * 
		 * Methoden der Klasse Arrays
		 * 
		 * static <T> Stream<T> stream(T[] array)
		 * static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive)
		 */
		System.out.println("*** Bsp. 8");
		
		//                 0   1   2   3   4   5   6
		Integer[] arr = { 10, 11, 12, 13, 14, 15, 16 };
		
		Arrays.stream(arr, 1, 5)
			.forEach(System.out::println);
		
		System.out.println("*** Bsp. 9");
		Arrays.stream(arr)
			.forEach(System.out::println);
		
//		Arrays.stream(7, 8, 9)	// cf
//			.forEach(System.out::println);
		

		/*
		 * Methoden aus dem Interface Collection
		 * 
		 * default Stream<E> stream()
		 * default Stream<E> parallelStream()
		 */
		
		Collection<Integer> coll = Arrays.asList(5, 6, 7, 8);
		
		System.out.println("*** Bsp. 10");
		coll.stream()
			.forEach(System.out::println);
		
		
		System.out.println("*** Bsp. 11");
		coll.parallelStream()
			.forEach(System.out::println);
		
		
		/*
		 * Weitere prüfungsrelevante Methoden, die ein Stream bilden,
		 * werden im Projekt IO präsentiert
		 */
		
		/*
		 * Weitere (nicht prüfungsrelevanten) Methoden gibt es
		 * in vielen Klassen der Standardbibliothek.
		 * 
		 * Z.B.:
		 */
		System.out.println("\n*** Bsp. 12");
		String str = "abcDEF";
		
		str.chars() // IntStream
			.forEach(System.out::println);
			
		
		
	} // end of main

}
