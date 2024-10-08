package set;

import java.util.HashSet;
import java.util.Set;

public class B01_HashSetMitStrings {
	/* 
	 * Ein Set ist eine Menge einzigartiger Elemente. 
	 * 
	 * HashSet ist nicht geordnet.
	 */
	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();

		System.out.println("1. size: " + set.size()); // 0
		
		set.add("mo");
		set.add("mo");
		set.add("MO".toLowerCase());
		set.add(new String("mo"));
		
		System.out.println("2. size: " + set.size()); // 1
		
		System.out.println("3. set: " + set); // [mo]
		
		set.add("di");
		set.add("mi");
		set.add("do");
		
		System.out.println("4. set: " + set); // [alle Elemente in irgendeine Reihenfolge]
		
		System.out.println("5. size: " + set.size()); // 4
	}

}
