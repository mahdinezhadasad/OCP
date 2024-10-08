package set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class B04_TreeSetMitInteger {

	public static void main(String[] args) {

		System.out.println("*** TreeSet mit der Standard-Sortierung");
		Set<Integer> set = new TreeSet<Integer>();
		
		set.add(56);
		set.add(56);
		set.add(56);
		set.add(56);

		System.out.println("1. size: " + set.size()); // 1
		
		set.add(-13);
		set.add(2);
		set.add(-7);
		set.add(100);
		
		System.out.println("2. size: " + set.size()); // 5
		
		System.out.println("3. set: " + set); //  [-13, -7, 2, 56, 100]
		
		System.out.println("\n*** TreeSet mit der absteigenden Sortierung");
		
		Comparator<Integer> cmp = Comparator.reverseOrder();
		Set<Integer> set2 = new TreeSet<Integer>(cmp);
		
		set2.add(7);
		set2.add(7);
		set2.add(7);
		set2.add(7);
		set2.add(-3);
		set2.add(-12);
		set2.add(222);
		set2.add(8);

		System.out.println("size: " + set2.size()); // 5
		System.out.println("set2: " + set2); // [222, 8, 7, -3, -12]
		
	}

}
