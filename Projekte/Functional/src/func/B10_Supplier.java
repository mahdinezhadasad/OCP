package func;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class B10_Supplier {

	/*
	 * interface Supplier <T> {
	 * 		T get();
	 * }
	 */
	public static void main(String[] args) {
		// anonyme Klasse
		Supplier<Integer> s1 = new Supplier<Integer> () {
			public Integer get() {
				return 42;
			}
		};

		List<Integer> list1 = buildList(5, s1);
		System.out.println(list1);
		
		// Lambda, ausführlich
		Supplier<Integer> s2 = () -> {
			return 42;
		};
		
		List<Integer> list2 = buildList(5, s2);
		System.out.println(list2);
		
		// Lambda, kompakt
		Supplier<Integer> s3 = () -> 42;
		
		List<Integer> list3 = buildList(5, s3);
		System.out.println(list3);
		
	} // 

	
	static List<Integer> buildList(int size, Supplier<Integer> s) {
		System.out.println("*** Liste wird erzeugt, Daten kommen aus dem Supplier");
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.add( s.get() );
		}
		return list;
	}
}
