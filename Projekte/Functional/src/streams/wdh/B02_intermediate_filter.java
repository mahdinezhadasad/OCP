package streams.wdh;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class B02_intermediate_filter {

	/*
	 * Stream<T> filter(Predicate<? super T> predicate)
	 */
	public static void main(String[] args) {
		
		Integer[] arr = { -5, 3, -12, 22, 0, -7 };
	
//		Arrays.stream(arr) 
//			.filter(x -> x + 1) // cf: Predicate nötig
//			.forEach(System.out::println);

		Predicate<Double> p1 = x -> true;
		
//		Arrays.stream(arr) // Stream<Integer> 
//			.filter(p1) // cf: Predicate<Integer> nötig
//			.forEach(System.out::println);
		
		Predicate<Integer> p2 = x -> true;
		
		Arrays.stream(arr)  
			.filter(p2) 
			.forEach(System.out::println);
		
	}

}
