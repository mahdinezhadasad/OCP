package aufgaben;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AufgabeGenerischeMethodenFunctional {

	public static void main(String[] args) {
		Predicate<Integer> isEven = i -> i % 2 == 0;
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println( count(list1, isEven) ); // 2  

		Predicate<Number> isOdd = b -> b.intValue() % 2 != 0;
		List<Number> list2 = Arrays.asList(1, 1.2, 3, 3.4);
		System.out.println( count(list2, isOdd) ); // 4  
		
		Predicate<String> isEmpty = String::isEmpty;
		List<String> list3 = Arrays.asList("a", "", "b", "", "c");
		System.out.println( count(list3, isEmpty) ); // 2
		
		// count(list1, isEmpty); // cf: unterschiedliche Parametrisierungen der Argumente
	}

	static <T> int count(List<T> values, Predicate<T> predicate) {
		
		int count = 0;

		for(T x : values) {
			if( predicate.test(x) ) {
				count++;
			}
		}
		
		return count;
	}
}
