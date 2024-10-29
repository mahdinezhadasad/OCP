package streams.wdh;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class B13_terminal_findFirst_findAny {

	/*
	 * Optional<T> findFirst();
	 * Optional<T> findAny();
	 */
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(-9, 13, 11, -7);
		Set<Integer> set = new HashSet<>(list);
		
		/*
		 * Exam:
		 */
//		Integer x1 = list.stream().findFirst(); // cf: findFirst liefert Optional zurück
		Optional<Integer> maybeInt = list.stream().findFirst();
		Integer x2 = list.stream().findFirst().get();
		
		
		/*
		 * - Datenquelle ist geordnet
		 * - Stream ist sequentiell
		 * - findFirst
		 */
		System.out.println("1. result: " + 
				list.stream().findFirst().get()); // -9
		
		/*
		 * - Datenquelle ist ungeordnet !!!
		 * - Stream ist sequentiell
		 * - findFirst
		 */
		System.out.println("2. result: " + 
				set.stream().findFirst().get()); // unbestimmt
		
		/*
		 * - Datenquelle ist geordnet
		 * - Stream ist sequentiel
		 * - findAny
		 */
		System.out.println("3. result: " + 
				list.stream().findAny().get()); // unbestimmt, obwohl Datenquelle geordnet 
												// ist und der Stream nicht parallel ist
	}
}
