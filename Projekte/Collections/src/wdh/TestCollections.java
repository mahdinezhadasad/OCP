package wdh;

import java.util.*;

class Blume implements Comparable<Blume> {
	private int id;

	public Blume(int id) {
		this.id = id;
	}

	public String toString() {
		return String.valueOf(id);
	}
	
	public int getId() {
		return id;
	}

	public boolean equals(Object obj) {
		return this.id == ((Blume)obj).id;
	}
	
	public int hashCode() {
		return id;
	}
	
	public int compareTo(Blume b2) {
		return id - b2.id;
	}
}

public class TestCollections {

	public static void main(String[] args) {
//		run(new ArrayList<>());  // 9 3 9 1
//		run(new LinkedList<>()); // 9 3 9 1
//		run(new Vector<>()); 	 // 9 3 9 1
//		run(new ArrayDeque<>()); // 9 3 9 1
//		run(new HashSet<>());    // 1 3 9 in einer unbestimmten Reihenfolge
//		run(new LinkedHashSet<>()); // 9 3 1
		
		run(new TreeSet<>());		// 1 3 9
//		run(new PriorityQueue<>()); // 1 3 9 9 (Reihenfolge ist beim Iterieren nicht garantiert)
		
		Comparator<Blume> cmp = Comparator.comparing(Blume::getId);
//		run(new TreeSet<>(cmp));
//		run(new PriorityQueue<>(cmp));
	}

	static void run(Collection<Blume> coll) {
		try {
			coll.add(new Blume(9));
			coll.add(new Blume(3));
			coll.add(new Blume(9));
			coll.add(new Blume(1));
			
			System.out.println(coll);
		} catch (ClassCastException e) {
			System.out.println("Exc");
		}
	}
}
