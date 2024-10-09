package set;

import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class B07_TreeSetAlsNavigableSet {

	/*
	 * Methoden aus NavigableSet sind unwahrscheinlich in der Prüfung
	 */
	public static void main(String[] args) {
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		set.add(67);
		set.add(-5);
		set.add(-5);
		set.add(101);
		set.add(-33);
		set.add(27);
		set.add(51);

		/*
		 * [-33, -5, 27, 51, 67, 101]
		 */
		System.out.println("*** set: " + set);

		/*
		 * E first()
		 * E last()
		 */
		Integer x = set.first();
		System.out.println("first(): " + x); // -33
		System.out.println("last(): " + set.last()); // 101
		
		/*
		 * E higher(E key)   - größer als
		 * E ceiling(E key)  - größer oder gleich als
		 *  
		 * E lower(E key) 	 - kleiner als
		 * E floor(E key) 	 - kleiner oder gleich als
		 * 
		 */
		Integer key = 51;
		x = set.higher(key);
		System.out.println("higher(51): " + x); // 67
		
		x = set.lower(key);
		System.out.println("lower(51): " + x); // 27
		
		x = set.ceiling(key); // sucht Element >= key
		System.out.println("ceiling(51): " + x); // 51
		
		x = set.floor(key); // sucht Element <0 key
		System.out.println("floor(51): " + x); // 51
		
		
		/*
		 *
		 * headSet
		 * tailSet
		 * subSet
		 * 
		 */
		Integer toElement = 51;
		SortedSet<Integer> headSet1 = set.headSet(toElement); // Obergrenze exklusive
		System.out.println("headSet1: " + headSet1); // [-33, -5, 27]
		
		boolean isInclusive = true; // inklusive
		NavigableSet<Integer> headSet2 = set.headSet(toElement, isInclusive);
		System.out.println("headSet2: " + headSet2); // [-33, -5, 27, 51]
		
		Integer fromElement = 27;
		SortedSet<Integer> tailSet1 = 
				set.tailSet(fromElement); // Untergrenze inklusive
		NavigableSet<Integer> tailSet2 = 
				set.tailSet(fromElement, false); // Untergrenze exklusive
	
		
		fromElement = -5;
		toElement = 67;
		SortedSet<Integer> subSet1 = 
				set.subSet(fromElement, toElement); // Untergrenze inklusive, 
												    // Obergrenze exklusive
		System.out.println("subSet1: " + subSet1); // [-5, 27, 51]
		
		NavigableSet<Integer> subSet2 = 
				set.subSet(fromElement, false, toElement, true);
												// Untergrenze exklusive,
												// Obergrenze inklusive
		System.out.println("subSet2: " + subSet2); // [27, 51, 67]
		
		/*
		 * Achtung in der Praxis:
		 * headSet, tailSet, subSet liefern backed-Sets zurück.
		 * 
		 */
		
		System.out.println();
		System.out.println("*** a. set: " + set); // [-33, -5, 27, 51, 67, 101]		
		System.out.println("*** a. subSet1: " + subSet1); //  [-5, 27, 51]
		
		set.add(10);
		System.out.println("*** b. set: " + set); // [-33, -5, 10, 27, 51, 67, 101]		
		System.out.println("*** b. subSet1: " + subSet1); //  [-5, 10, 27, 51]
		
		subSet1.add(35);
		System.out.println("*** c. set: " + set); // [-33, -5, 10, 27, 35, 51, 67, 101]		
		System.out.println("*** c. subSet1: " + subSet1); //  [-5, 10, 27, 35, 51]
		
		set.add(1000); // ok. TreeSet hat keine Grenzen
		subSet1.add(1000); // Exception. SubSet hat Grenzen [-5 .. 67)
	}

}
