package set;

import java.util.Set;
import java.util.TreeSet;

public class B05_TreeSetMitStrings {

	public static void main(String[] args) {
		
		System.out.println("*** TreeSet mit der Standard-Sortierung");
		
		Set<String> set = new TreeSet<String>();
		
		set.add("gg");
		set.add("kk");
		set.add("gg");
		set.add("bb");
		set.add("gg");
		set.add("yy");

		System.out.println("size: " + set.size()); // 4
		System.out.println("set: " + set); // [bb, gg, kk, yy]

	}

}
