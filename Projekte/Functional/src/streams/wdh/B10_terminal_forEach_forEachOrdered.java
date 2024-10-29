package streams.wdh;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class B10_terminal_forEach_forEachOrdered {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(-7, 13, 11, -9, 5);
		Set<Integer> set = new HashSet<Integer>(list);
		
		
		/*
		 * - Datenquelle ist geordnet
		 * - Stream ist sequentiell
		 * - terminal forEach
		 */
		list.stream()
			.forEach(x -> System.out.print(x + " ")); // -7 13 11 -9 5 
		System.out.println();
		
		/*
		 * - Datenquelle ist ungeordnet !!!
		 * - Stream ist sequentiell
		 * - terminal forEach
		 */
		set.stream()
			.forEach(x -> System.out.print(x + " ")); // Reihenfolge unbestimmt
		System.out.println();
		
		
		/*
		 * - Datenquelle ist geordnet
		 * - Stream ist parallel !!!
		 * - terminal forEach
		 */
		list.parallelStream()
			.forEach(x -> System.out.print(x + " ")); // Reihenfolge unbestimmt
		System.out.println();

		/*
		 * - Datenquelle ist geordnet  !
		 * - Stream ist parallel       !
		 * - terminal forEachOrdered   !
		 */
		list.parallelStream()
			//...
			.forEachOrdered(x -> System.out.print(x + " ")); // -7 13 11 -9 5 
		System.out.println();

		/*
		 * noch ein Test
		 */
		Stream.of(1, 2, 3, 4, 5)
			.parallel()
			.filter(x -> x % 2 != 0)
			.map(x -> x + "!")
			.forEachOrdered(System.out::println); // 1! 3! 5!
		
	}

}
