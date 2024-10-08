package set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Blume implements Comparable<Blume> {
	int preis;

	public Blume(int preis) {
		this.preis = preis;
	}

	public String toString() {
		return "Blume (" + preis + ")";
	}
	
	@Override
	public int compareTo(Blume b2) {
		return preis - b2.preis;
	}
}

public class B06_TreeSetMitBlumen {

	public static void main(String[] args) {
		System.out.println("*** TreeSet mit der Standard-Sortierung");

		Set<Blume> set = new TreeSet<Blume>();
		
		set.add(new Blume(220));
		set.add(new Blume(90));
		set.add(new Blume(120));
		set.add(new Blume(90));

		System.out.println("size: " + set.size());
		System.out.println("set: " + set); // [Blume (90), Blume (120), Blume (220)]
		
		System.out.println("\n*** TreeSet mit der absteigenden Sortierung");
		
		Comparator<Blume> cmp = Comparator.reverseOrder();
		Set<Blume> set2 = new TreeSet<Blume>(cmp);
		
		set2.addAll(set);
		
		System.out.println("size: " + set2.size()); // 3
		System.out.println("set2: " + set2); // [Blume (220), Blume (120), Blume (90)]
		
		
	}

}
