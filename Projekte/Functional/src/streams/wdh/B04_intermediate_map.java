package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class B04_intermediate_map {

	/*
	 *  <R> Stream<R> map(Function<? super T, ? extends R> mapper)
	 */
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("a", "bb", "c", "dddd");
		
		System.out.println("*** Bsp. 1");
		
		list.stream() 					// Stream<String>
			.map(s -> "(" + s + ")")	// Stream<String>
			.map(String::length)		// Stream<Integer>
			.forEach(System.out::println); // s 4 3 6
			
		
		System.out.println("*** Bsp. 2");

		Function<String, String> f1 = s -> "(" + s + ")";
		Function<String, Integer> f2 = String::length;
		Consumer<Integer> c1 = System.out::println;
		
		list.stream() 	// Stream<String>
			.map(f1)	// Stream<String>
			.map(f2)	// Stream<Integer>
			.forEach(c1); // s 4 3 6
		
	}

}
