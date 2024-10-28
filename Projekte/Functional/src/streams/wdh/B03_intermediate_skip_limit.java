package streams.wdh;

import java.util.stream.Stream;

public class B03_intermediate_skip_limit {

	/*
	 * Stream<T> skip(long n)
	 * Stream<T> limit(long n)
	 * 
	 */
	public static void main(String[] args) {

		System.out.println("*** Bsp. 1");
		
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
			.skip(3)
			.limit(2)
			.forEach(System.out::println); // 4 5

		System.out.println("\n*** Bsp. 2");
		
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
			.limit(2)
			.skip(3)
			.forEach(System.out::println); // keine Ausgaben
		
		System.out.println("\n*** Bsp. 3");
		
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
			.limit(5)
			.skip(3)
			.forEach(System.out::println); // 4, 5
		
	}

}
