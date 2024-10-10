package wdh;

import java.util.*;

class Blume {
	private int id;

	public Blume(int id) {
		this.id = id;
	}

	public String toString() {
		return String.valueOf(id);
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Blume)obj).id;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
}

public class TestCollections {

	public static void main(String[] args) {
//		run(new ArrayList<>());  // 9 3 9 1
//		run(new LinkedList<>()); // 9 3 9 1
//		run(new Vector<>()); 	 // 9 3 9 1
//		run(new ArrayDeque<>()); // 9 3 9 1
		
		run(new HashSet<>());    // 1, 3, 9 in einer unbestimmten Reihenfolge
	}

	static void run(Collection<Blume> coll) {
		try {
			coll.add(new Blume(9));
			coll.add(new Blume(3));
			coll.add(new Blume(9));
			coll.add(new Blume(1));
			
			System.out.println(coll);
		} catch (Exception e) {
			System.out.println("Exc");
		}
	}
}
