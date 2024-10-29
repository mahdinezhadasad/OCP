package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class B14_terminal_anyMatch_allMatch_noneMatch {

	/*
	 *  - anyMatch, allMatch, noneMatch haben Predicate-Parameter 
	 *  - anyMatch, allMatch, noneMatch liefern boolean zurück 
	 *  - anyMatch, allMatch, noneMatch sind 'lazy' 
	 */
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(12, -7, 33, 4, 85);
		
		Predicate<Integer> isNegativ = x -> x < 0;
		
		boolean result = list.stream()
				.peek(x -> System.out.println("a. peek " + x)) // 12, -7
				.anyMatch(isNegativ);
		System.out.println("mindestens ein Element ist negativ: " + result); // true
		
		result = list.stream()
				.peek(x -> System.out.println("b. peek " + x)) // 12
				.allMatch(isNegativ);
		System.out.println("alle Elemente sind negativ: " + result); // false

		result = list.stream()
				.peek(x -> System.out.println("c. peek " + x)) // 12, -7
				.noneMatch(isNegativ);
		System.out.println("kein einziges Element ist negativ: " + result); // false
		
	}

}
